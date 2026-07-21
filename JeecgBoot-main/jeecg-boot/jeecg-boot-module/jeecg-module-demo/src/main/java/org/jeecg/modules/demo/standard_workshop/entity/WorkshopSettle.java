package org.jeecg.modules.demo.standard_workshop.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 厂房入驻情况
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
@Schema(description="厂房入驻情况")
@Data
@TableName("workshop_settle")
public class WorkshopSettle implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
	/**层数*/
	@Excel(name = "层数", width = 15)
    @Schema(description = "层数")
    private java.lang.Integer floorNum;
	/**面积(㎡)*/
	@Excel(name = "面积(㎡)", width = 15)
    @Schema(description = "面积(㎡)")
    private java.lang.Double area;
	/**项目名称*/
	@Excel(name = "项目名称", width = 15)
    @Schema(description = "项目名称")
    private java.lang.String projectName;
	/**公司名称*/
	@Excel(name = "公司名称", width = 15)
    @Schema(description = "公司名称")
    private java.lang.String companyName;
	/**引资单位*/
	@Excel(name = "引资单位", width = 15)
    @Schema(description = "引资单位")
    private java.lang.String investmentUnit;
	/**入驻状态*/
	@Excel(name = "入驻状态", width = 15)
	@Dict(dicCode = "settled_status")
    @Schema(description = "入驻状态")
    private java.lang.String settleStatus;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @Schema(description = "备注")
    private java.lang.String remark;
	/**主表ID*/
    @Schema(description = "主表ID")
    private java.lang.String headId;
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
