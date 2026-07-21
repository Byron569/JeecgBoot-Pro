package org.jeecg.modules.demo.investment_project.vo;

import java.util.List;
import org.jeecg.modules.demo.investment_project.entity.InvestmentProject;
import org.jeecg.modules.demo.investment_project.entity.InvestmentProjectRel;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description="招商项目管理")
public class InvestmentProjectPage {

	private java.lang.String id;
	@Excel(name = "项目编号", width = 15)
	private java.lang.String projectCode;
	@Excel(name = "项目名称", width = 15)
	private java.lang.String projectName;
	@Excel(name = "产业类型", width = 15)
	private java.lang.String industryType;
	@Excel(name = "所在地块", width = 15)
	private java.lang.String landParcelId;
	@Excel(name = "地块状态", width = 15)
	private java.lang.String landStatus;
	@Excel(name = "投资额（万元）", width = 15)
	private java.lang.Double investmentAmount;
	@Excel(name = "联系人", width = 15)
	private java.lang.String contactPerson;
	@Excel(name = "联系电话", width = 15)
	private java.lang.String contactPhone;
	@Excel(name = "项目简介", width = 15)
	private java.lang.String projectIntro;
	@Excel(name = "项目意向", width = 15)
	private java.lang.String projectIntention;
	@Excel(name = "预计投产时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date expectedStartDate;
	@Excel(name = "实际投产时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date actualStartDate;
	@Excel(name = "项目状态", width = 15)
	private java.lang.String projectStatus;
	@Excel(name = "引资单位", width = 15)
	private java.lang.String investmentUnit;
	private java.lang.String createBy;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	private java.lang.String updateBy;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;
	private java.lang.String sysOrgCode;

	@ExcelCollection(name="项目关联企业")
	@Schema(description = "项目关联企业")
	private List<InvestmentProjectRel> investmentProjectRelList;

}
