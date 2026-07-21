package org.jeecg.modules.demo.investment_project.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 招商项目管理
 * @Author: jeecg-boot
 * @Date:   2026-07-15
 * @Version: V1.0
 */
@Data
@TableName("investment_project")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="招商项目管理")
public class InvestmentProject implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
	/**项目编号*/
	@Excel(name = "项目编号", width = 15)
    @Schema(description = "项目编号")
    private java.lang.String projectCode;
	/**项目名称*/
	@Excel(name = "项目名称", width = 15)
    @Schema(description = "项目名称")
    private java.lang.String projectName;
	/**产业类型*/
	@Excel(name = "产业类型", width = 15)
	@Dict(dicCode = "industry")
    @Schema(description = "产业类型")
    private java.lang.String industryType;
	/**所在地块*/
	@Excel(name = "所在地块", width = 15)
	@Dict(dictTable = "land_parcel", dicText = "parcel_name", dicCode = "id")
	@TableField(updateStrategy = FieldStrategy.ALWAYS)
    @Schema(description = "所在地块")
    private java.lang.String landParcelId;
	/**地块状态*/
	@Excel(name = "地块状态", width = 15)
	@Dict(dicCode = "land_status")
	@TableField(updateStrategy = FieldStrategy.ALWAYS)
    @Schema(description = "地块状态")
    private java.lang.String landStatus;
	/**投资额（万元）*/
	@Excel(name = "投资额（万元）", width = 15)
    @Schema(description = "投资额（万元）")
    private java.lang.Double investmentAmount;
	/**联系人*/
	@Excel(name = "联系人", width = 15)
    @Schema(description = "联系人")
    private java.lang.String contactPerson;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @Schema(description = "联系电话")
    private java.lang.String contactPhone;
	/**项目简介*/
	@Excel(name = "项目简介", width = 15)
    @Schema(description = "项目简介")
    private java.lang.String projectIntro;
	/**项目意向*/
	@Excel(name = "项目意向", width = 15)
    @Schema(description = "项目意向")
    private java.lang.String projectIntention;
	/**预计投产时间*/
	@Excel(name = "预计投产时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "预计投产时间")
    private java.util.Date expectedStartDate;
	/**实际投产时间*/
	@Excel(name = "实际投产时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "实际投产时间")
    private java.util.Date actualStartDate;
	/**项目状态*/
	@Excel(name = "项目状态", width = 15)
	@Dict(dicCode = "project_status")
    @Schema(description = "项目状态")
    private java.lang.String projectStatus;
	/**引资单位*/
	@Excel(name = "引资单位", width = 15)
    @Schema(description = "引资单位")
    private java.lang.String investmentUnit;
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
}
