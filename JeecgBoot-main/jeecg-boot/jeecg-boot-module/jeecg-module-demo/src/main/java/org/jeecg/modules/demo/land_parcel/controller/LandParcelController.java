package org.jeecg.modules.demo.land_parcel.controller;

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
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.land_parcel.entity.LandParcel;
import org.jeecg.modules.demo.land_parcel.service.ILandParcelService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
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
 /**
 * @Description: 地块信息表
 * @Author: jeecg-boot
 * @Date:   2026-07-14
 * @Version: V1.0
 */
@Tag(name="地块信息表")
@RestController
@RequestMapping("/land_parcel/landParcel")
@Slf4j
public class LandParcelController extends JeecgController<LandParcel, ILandParcelService> {
	@Autowired
	private ILandParcelService landParcelService;
	
	/**
	 * 分页列表查询
	 *
	 * @param landParcel
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "地块信息表-分页列表查询")
	@Operation(summary="地块信息表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LandParcel>> queryPageList(LandParcel landParcel,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {


        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("industrialPark", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("landPurpose", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("landStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<LandParcel> queryWrapper = QueryGenerator.initQueryWrapper(landParcel, req.getParameterMap(),customeRuleMap);
		Page<LandParcel> page = new Page<LandParcel>(pageNo, pageSize);
		IPage<LandParcel> pageList = landParcelService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param landParcel
	 * @return
	 */
	@AutoLog(value = "地块信息表-添加")
	@Operation(summary="地块信息表-添加")
	@RequiresPermissions("land_parcel:land_parcel:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LandParcel landParcel) {
		landParcelService.save(landParcel);

		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param landParcel
	 * @return
	 */
	@AutoLog(value = "地块信息表-编辑")
	@Operation(summary="地块信息表-编辑")
	@RequiresPermissions("land_parcel:land_parcel:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LandParcel landParcel) {
		landParcelService.updateById(landParcel);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "地块信息表-通过id删除")
	@Operation(summary="地块信息表-通过id删除")
	@RequiresPermissions("land_parcel:land_parcel:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		landParcelService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "地块信息表-批量删除")
	@Operation(summary="地块信息表-批量删除")
	@RequiresPermissions("land_parcel:land_parcel:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.landParcelService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "地块信息表-通过id查询")
	@Operation(summary="地块信息表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<LandParcel> queryById(@RequestParam(name="id",required=true) String id) {
		LandParcel landParcel = landParcelService.getById(id);
		if(landParcel==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(landParcel);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param landParcel
    */
    @RequiresPermissions("land_parcel:land_parcel:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LandParcel landParcel) {
        return super.exportXls(request, landParcel, LandParcel.class, "地块信息表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("land_parcel:land_parcel:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, LandParcel.class);
    }

}
