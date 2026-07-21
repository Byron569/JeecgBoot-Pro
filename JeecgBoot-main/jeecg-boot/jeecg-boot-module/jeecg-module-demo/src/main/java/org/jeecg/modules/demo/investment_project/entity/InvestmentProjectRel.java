package org.jeecg.modules.demo.investment_project.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="项目关联企业")
@Data
@TableName("investment_project_rel")
public class InvestmentProjectRel implements Serializable {
    private static final long serialVersionUID = 1L;

	@Schema(description = "主表ID")
    private java.lang.String headId;

	@Excel(name = "企业名称", width = 15)
    @Schema(description = "企业名称")
    private java.lang.String companyName;

	@Excel(name = "开始日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "开始日期")
    private java.util.Date startDate;

	@Excel(name = "状态", width = 15)
    @Schema(description = "状态")
    private java.lang.String status;
}
