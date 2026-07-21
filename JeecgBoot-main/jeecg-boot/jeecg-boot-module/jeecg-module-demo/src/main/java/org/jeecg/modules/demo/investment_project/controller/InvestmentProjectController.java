package org.jeecg.modules.demo.investment_project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.investment_project.entity.InvestmentProject;
import org.jeecg.modules.demo.investment_project.entity.InvestmentProjectRel;
import org.jeecg.modules.demo.investment_project.vo.InvestmentProjectPage;
import org.jeecg.modules.demo.investment_project.service.IInvestmentProjectService;
import org.jeecg.modules.demo.investment_project.service.IInvestmentProjectRelService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@Tag(name="招商项目管理")
@RestController
@RequestMapping("/investment_project/investmentProject")
@Slf4j
public class InvestmentProjectController extends JeecgController<InvestmentProject, IInvestmentProjectService> {
	@Autowired
	private IInvestmentProjectService investmentProjectService;
	@Autowired
	private IInvestmentProjectRelService investmentProjectRelService;

	@Operation(summary="招商项目管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<InvestmentProject>> queryPageList(InvestmentProject investmentProject,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        customeRuleMap.put("industryType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("projectStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<InvestmentProject> queryWrapper = QueryGenerator.initQueryWrapper(investmentProject, req.getParameterMap(),customeRuleMap);
		Page<InvestmentProject> page = new Page<InvestmentProject>(pageNo, pageSize);
		IPage<InvestmentProject> pageList = investmentProjectService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	@AutoLog(value = "招商项目管理-添加")
	@Operation(summary="招商项目管理-添加")
	@RequiresPermissions("investment_project:investment_project:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody InvestmentProjectPage investmentProjectPage) {
		InvestmentProject investmentProject = new InvestmentProject();
		BeanUtils.copyProperties(investmentProjectPage, investmentProject);
		investmentProjectService.saveMain(investmentProject, investmentProjectPage.getInvestmentProjectRelList());
		return Result.OK("添加成功！");
	}

	@AutoLog(value = "招商项目管理-编辑")
	@Operation(summary="招商项目管理-编辑")
	@RequiresPermissions("investment_project:investment_project:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody InvestmentProjectPage investmentProjectPage) {
		InvestmentProject investmentProject = new InvestmentProject();
		BeanUtils.copyProperties(investmentProjectPage, investmentProject);
		InvestmentProject investmentProjectEntity = investmentProjectService.getById(investmentProject.getId());
		if(investmentProjectEntity==null) {
			return Result.error("未找到对应数据");
		}
		investmentProjectService.updateMain(investmentProject, investmentProjectPage.getInvestmentProjectRelList());
		return Result.OK("编辑成功!");
	}

	@AutoLog(value = "招商项目管理-通过id删除")
	@Operation(summary="招商项目管理-通过id删除")
	@RequiresPermissions("investment_project:investment_project:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		investmentProjectService.delMain(id);
		return Result.OK("删除成功!");
	}

	@AutoLog(value = "招商项目管理-批量删除")
	@Operation(summary="招商项目管理-批量删除")
	@RequiresPermissions("investment_project:investment_project:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.investmentProjectService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	@Operation(summary="招商项目管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<InvestmentProject> queryById(@RequestParam(name="id",required=true) String id) {
		InvestmentProject investmentProject = investmentProjectService.getById(id);
		if(investmentProject==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(investmentProject);
	}

	@Operation(summary="项目关联企业主表ID查询")
	@GetMapping(value = "/queryInvestmentProjectRelByMainId")
	public Result<List<InvestmentProjectRel>> queryInvestmentProjectRelListByMainId(@RequestParam(name="id",required=true) String id) {
		List<InvestmentProjectRel> investmentProjectRelList = investmentProjectRelService.selectByMainId(id);
		return Result.OK(investmentProjectRelList);
	}

    @RequiresPermissions("investment_project:investment_project:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, InvestmentProject investmentProject) {
      QueryWrapper<InvestmentProject> queryWrapper = QueryGenerator.initQueryWrapper(investmentProject, request.getParameterMap());
      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
      String selections = request.getParameter("selections");
      if(oConvertUtils.isNotEmpty(selections)) {
         List<String> selectionList = Arrays.asList(selections.split(","));
         queryWrapper.in("id",selectionList);
      }
      List<InvestmentProject> investmentProjectList = investmentProjectService.list(queryWrapper);
      List<InvestmentProjectPage> pageList = new ArrayList<InvestmentProjectPage>();
      for (InvestmentProject main : investmentProjectList) {
          InvestmentProjectPage vo = new InvestmentProjectPage();
          BeanUtils.copyProperties(main, vo);
          List<InvestmentProjectRel> investmentProjectRelList = investmentProjectRelService.selectByMainId(main.getId());
          vo.setInvestmentProjectRelList(investmentProjectRelList);
          pageList.add(vo);
      }
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "招商项目管理列表");
      mv.addObject(NormalExcelConstants.CLASS, InvestmentProjectPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("招商项目管理数据", "导出人:"+sysUser.getRealname(), "招商项目管理", ExcelType.XSSF));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
    }

    @RequiresPermissions("investment_project:investment_project:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          MultipartFile file = entity.getValue();
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<InvestmentProjectPage> list = ExcelImportUtil.importExcel(file.getInputStream(), InvestmentProjectPage.class, params);
              for (InvestmentProjectPage page : list) {
                  InvestmentProject po = new InvestmentProject();
                  BeanUtils.copyProperties(page, po);
                  investmentProjectService.saveMain(po, page.getInvestmentProjectRelList());
              }
              return Result.OK("文件导入成功！数据行数:" + list.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.OK("文件导入失败！");
    }

    @PutMapping(value = "/batchBinding")
    public Result<String> batchBinding(@RequestParam String ids, @RequestParam String landParcelId) {
        investmentProjectService.lambdaUpdate()
            .set(InvestmentProject::getLandParcelId, landParcelId)
            .in(InvestmentProject::getId, Arrays.asList(ids.split(",")))
            .update();
        return Result.OK("绑定成功");
    }

    @PutMapping(value = "/batchUnbinding")
    public Result<String> batchUnbinding(@RequestParam String ids) {
        investmentProjectService.lambdaUpdate()
            .set(InvestmentProject::getLandParcelId, null)
            .set(InvestmentProject::getLandStatus, null)
            .in(InvestmentProject::getId, Arrays.asList(ids.split(",")))
            .update();
        return Result.OK("解绑成功");
    }

}
