package org.jeecg.modules.demo.standard_workshop.vo;

import java.util.List;
import org.jeecg.modules.demo.standard_workshop.entity.StandardWorkshop;
import org.jeecg.modules.demo.standard_workshop.entity.WorkshopSettle;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @Description: 标准厂房管理
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
@Data
@Schema(description="标准厂房管理")
public class StandardWorkshopPage {

	/**主键*/
	@Schema(description = "主键")
    private java.lang.String id;
	/**	厂房编号*/
	@Excel(name = "	厂房编号", width = 15)
	@Schema(description = "	厂房编号")
    private java.lang.String workshopCode;
	/**	厂房全称*/
	@Excel(name = "	厂房全称", width = 15)
	@Schema(description = "	厂房全称")
    private java.lang.String workshopFullName;
	/**总面积*/
	@Excel(name = "总面积", width = 15)
	@Schema(description = "总面积")
    private java.lang.Double totalArea;
	/**空置面积	*/
	@Excel(name = "空置面积	", width = 15)
	@Schema(description = "空置面积	")
    private java.lang.Double vacantArea;
	/**	关联地块*/
	@Excel(name = "	关联地块", width = 15)
	@Schema(description = "	关联地块")
    private java.lang.String landParcelId;
	/**楼层数*/
	@Excel(name = "楼层数", width = 15)
	@Schema(description = "楼层数")
    private java.lang.Integer floorCount;
	/**空置状态*/
	@Excel(name = "空置状态", width = 15)
	@Schema(description = "空置状态")
    private java.lang.String vacantStatus;
	/**创建人*/
	@Schema(description = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Schema(description = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
	@Schema(description = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Schema(description = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
	@Schema(description = "所属部门")
    private java.lang.String sysOrgCode;

	@ExcelCollection(name="厂房入驻情况")
	@Schema(description = "厂房入驻情况")
	private List<WorkshopSettle> workshopSettleList;

}
