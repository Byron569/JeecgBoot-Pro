package org.jeecg.modules.demo.standard_workshop.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Schema(description="标准厂房管理")
@Data
@TableName("standard_workshop")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class StandardWorkshop implements Serializable {
    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;

	@Excel(name = "厂房编号", width = 15)
    @Schema(description = "厂房编号")
    private java.lang.String workshopCode;

	@Excel(name = "厂房全称", width = 15)
    @Schema(description = "厂房全称")
    private java.lang.String workshopFullName;

	@Excel(name = "总面积", width = 15)
    @Schema(description = "总面积")
    private java.lang.Double totalArea;

	@Excel(name = "空置面积", width = 15)
    @Schema(description = "空置面积")
    private java.lang.Double vacantArea;

	@Excel(name = "关联地块", width = 15)
	@Dict(dictTable = "land_parcel", dicText = "parcel_name", dicCode = "id")
    @Schema(description = "关联地块")
    private java.lang.String landParcelId;

	@Excel(name = "楼层数", width = 15)
    @Schema(description = "楼层数")
    private java.lang.Integer floorCount;

	@Excel(name = "空置状态", width = 15)
	@Dict(dicCode = "vacant_status")
    @Schema(description = "空置状态")
    private java.lang.String vacantStatus;
	/**坐标(经度,纬度)*/
    @Schema(description = "坐标(经度,纬度)")
    private java.lang.String longitudeLatitude;

    @Schema(description = "创建人")
    private java.lang.String createBy;

	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建日期")
    private java.util.Date createTime;

    @Schema(description = "更新人")
    private java.lang.String updateBy;

	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新日期")
    private java.util.Date updateTime;

    @Schema(description = "所属部门")
    private java.lang.String sysOrgCode;
}
