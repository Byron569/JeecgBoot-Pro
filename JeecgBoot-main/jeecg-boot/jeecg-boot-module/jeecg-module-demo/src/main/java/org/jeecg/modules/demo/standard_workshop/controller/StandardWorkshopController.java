package org.jeecg.modules.demo.standard_workshop.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecg.modules.demo.standard_workshop.entity.WorkshopSettle;
import org.jeecg.modules.demo.standard_workshop.entity.StandardWorkshop;
import org.jeecg.modules.demo.standard_workshop.vo.StandardWorkshopPage;
import org.jeecg.modules.demo.standard_workshop.service.IStandardWorkshopService;
import org.jeecg.modules.demo.standard_workshop.service.IWorkshopSettleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;


 /**
 * @Description: 标准厂房管理
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
@Tag(name="标准厂房管理")
@RestController
@RequestMapping("/standard_workshop/standardWorkshop")
@Slf4j
public class StandardWorkshopController {
	@Autowired
	private IStandardWorkshopService standardWorkshopService;
	@Autowired
	private IWorkshopSettleService workshopSettleService;
	
	/**
	 * 分页列表查询
	 *
	 * @param standardWorkshop
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "标准厂房管理-分页列表查询")
	@Operation(summary="标准厂房管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<StandardWorkshop>> queryPageList(StandardWorkshop standardWorkshop,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<StandardWorkshop> queryWrapper = QueryGenerator.initQueryWrapper(standardWorkshop, req.getParameterMap());
		Page<StandardWorkshop> page = new Page<StandardWorkshop>(pageNo, pageSize);
		IPage<StandardWorkshop> pageList = standardWorkshopService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param standardWorkshopPage
	 * @return
	 */
	@AutoLog(value = "标准厂房管理-添加")
	@Operation(summary="标准厂房管理-添加")
    @RequiresPermissions("standard_workshop:standard_workshop:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody StandardWorkshopPage standardWorkshopPage) {
		StandardWorkshop standardWorkshop = new StandardWorkshop();
		BeanUtils.copyProperties(standardWorkshopPage, standardWorkshop);
		standardWorkshopService.saveMain(standardWorkshop, standardWorkshopPage.getWorkshopSettleList());
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param standardWorkshopPage
	 * @return
	 */
	@AutoLog(value = "标准厂房管理-编辑")
	@Operation(summary="标准厂房管理-编辑")
    @RequiresPermissions("standard_workshop:standard_workshop:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody StandardWorkshopPage standardWorkshopPage) {
		StandardWorkshop standardWorkshop = new StandardWorkshop();
		BeanUtils.copyProperties(standardWorkshopPage, standardWorkshop);
		StandardWorkshop standardWorkshopEntity = standardWorkshopService.getById(standardWorkshop.getId());
		if(standardWorkshopEntity==null) {
			return Result.error("未找到对应数据");
		}
		standardWorkshopService.updateMain(standardWorkshop, standardWorkshopPage.getWorkshopSettleList());
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "标准厂房管理-通过id删除")
	@Operation(summary="标准厂房管理-通过id删除")
    @RequiresPermissions("standard_workshop:standard_workshop:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		standardWorkshopService.delMain(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "标准厂房管理-批量删除")
	@Operation(summary="标准厂房管理-批量删除")
    @RequiresPermissions("standard_workshop:standard_workshop:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.standardWorkshopService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "标准厂房管理-通过id查询")
	@Operation(summary="标准厂房管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<StandardWorkshop> queryById(@RequestParam(name="id",required=true) String id) {
		StandardWorkshop standardWorkshop = standardWorkshopService.getById(id);
		if(standardWorkshop==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(standardWorkshop);

	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "厂房入驻情况通过主表ID查询")
	@Operation(summary="厂房入驻情况主表ID查询")
	@GetMapping(value = "/queryWorkshopSettleByMainId")
	public Result<List<WorkshopSettle>> queryWorkshopSettleListByMainId(@RequestParam(name="id",required=true) String id) {
		List<WorkshopSettle> workshopSettleList = workshopSettleService.selectByMainId(id);
		return Result.OK(workshopSettleList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param standardWorkshop
    */
    @RequiresPermissions("standard_workshop:standard_workshop:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, StandardWorkshop standardWorkshop) {

      // Step.1 组装查询条件查询数据
      QueryWrapper<StandardWorkshop> queryWrapper = QueryGenerator.initQueryWrapper(standardWorkshop, request.getParameterMap());
      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

      //配置选中数据查询条件
      String selections = request.getParameter("selections");
      if(oConvertUtils.isNotEmpty(selections)) {
         List<String> selectionList = Arrays.asList(selections.split(","));
         queryWrapper.in("id",selectionList);
      }
      //Step.2 获取导出数据
      List<StandardWorkshop> standardWorkshopList = standardWorkshopService.list(queryWrapper);

      // Step.3 组装pageList
      List<StandardWorkshopPage> pageList = new ArrayList<StandardWorkshopPage>();
      for (StandardWorkshop main : standardWorkshopList) {
          StandardWorkshopPage vo = new StandardWorkshopPage();
          BeanUtils.copyProperties(main, vo);
          List<WorkshopSettle> workshopSettleList = workshopSettleService.selectByMainId(main.getId());
          vo.setWorkshopSettleList(workshopSettleList);
          pageList.add(vo);
      }

      // Step.4 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "标准厂房管理列表");
      mv.addObject(NormalExcelConstants.CLASS, StandardWorkshopPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("标准厂房管理数据", "导出人:"+sysUser.getRealname(), "标准厂房管理", ExcelType.XSSF));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
    }

    /**
    * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("standard_workshop:standard_workshop:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          // 获取上传文件对象
          MultipartFile file = entity.getValue();
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<StandardWorkshopPage> list = ExcelImportUtil.importExcel(file.getInputStream(), StandardWorkshopPage.class, params);
              for (StandardWorkshopPage page : list) {
                  StandardWorkshop po = new StandardWorkshop();
                  BeanUtils.copyProperties(page, po);
                  standardWorkshopService.saveMain(po, page.getWorkshopSettleList());
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

}
