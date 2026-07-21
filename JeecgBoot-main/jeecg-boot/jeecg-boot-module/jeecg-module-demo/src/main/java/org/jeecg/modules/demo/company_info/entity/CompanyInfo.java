package org.jeecg.modules.demo.company_info.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
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
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 企业信息管理
 * @Author: jeecg-boot
 * @Date:   2026-07-14
 * @Version: V1.0
 */
@Data
@TableName("company_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="企业信息管理")
public class CompanyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
	/**企业ID*/
	@Excel(name = "企业ID", width = 15)
    @Schema(description = "企业ID")
    private java.lang.String companyId;
	/**企业全称*/
	@Excel(name = "企业全称", width = 15)
    @Schema(description = "企业全称")
    private java.lang.String companyName;
	/**企业简称*/
	@Excel(name = "企业简称", width = 15)
    @Schema(description = "企业简称")
    private java.lang.String companyShortName;
	/**所在地块*/
	@Excel(name = "所在地块", width = 15)
	@Dict(dictTable = "land_parcel", dicText = "parcel_name", dicCode = "id")
    @Schema(description = "所在地块")
    private java.lang.String landParcelId;
	/**统一信用代码*/
	@Excel(name = "统一信用代码", width = 15)
    @Schema(description = "统一信用代码")
    private java.lang.String creditCode;
	/**企业类型*/
	@Excel(name = "企业类型", width = 15)
	@Dict(dicCode = "company_type")
    @Schema(description = "企业类型")
    private java.lang.String companyType;
	/**所属行业*/
	@Excel(name = "所属行业", width = 15)
	@Dict(dicCode = "industry")
    @Schema(description = "所属行业")
    private java.lang.String industry;
	/**注册资本*/
	@Excel(name = "注册资本", width = 15)
    @Schema(description = "注册资本")
    private java.lang.Double registeredCapital;
	/**法人姓名*/
	@Excel(name = "法人姓名", width = 15)
    @Schema(description = "法人姓名")
    private java.lang.String legalPerson;
	/**对接人姓名*/
	@Excel(name = "对接人姓名", width = 15)
    @Schema(description = "对接人姓名")
    private java.lang.String contactPerson;
	/**对接人电话*/
	@Excel(name = "对接人电话", width = 15)
    @Schema(description = "对接人电话")
    private java.lang.String contactPhone;
	/**经营地址*/
	@Excel(name = "经营地址", width = 15)
    @Schema(description = "经营地址")
    private java.lang.String businessAddress;
	/**企业简介/核心业务*/
	@Excel(name = "企业简介/核心业务", width = 15)
    @Schema(description = "企业简介/核心业务")
    private java.lang.String companyProfile;
	/**企业状态*/
	@Excel(name = "企业状态", width = 15)
	@Dict(dicCode = "company_status")
    @Schema(description = "企业状态")
    private java.lang.String companyStatus;
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
