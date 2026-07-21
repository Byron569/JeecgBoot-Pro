package org.jeecg.modules.demo.land_parcel.entity;

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
 * @Description: 地块信息表
 * @Author: jeecg-boot
 * @Date:   2026-07-14
 * @Version: V1.0
 */
@Data
@TableName("land_parcel")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="地块信息表")
public class LandParcel implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
    /**地块编号*/
    @Excel(name = "地块编号", width = 15)
    @Schema(description = "地块编号")
    private java.lang.String parcelCode;
    /**地块名称*/
    @Excel(name = "地块名称", width = 15)
    @Schema(description = "地块名称")
    private java.lang.String parcelName;
    /**所属工业园*/
    @Excel(name = "所属工业园", width = 15)
    @Dict(dicCode = "industrial_park")
    @Schema(description = "所属工业园")
    private java.lang.String industrialPark;
    /**用途*/
    @Excel(name = "用途", width = 15)
    @Dict(dicCode = "land_purpose")
    @Schema(description = "用途")
    private java.lang.String landPurpose;
    /**面积(亩)*/
    @Excel(name = "面积(亩)", width = 15)
    @Schema(description = "面积(亩)")
    private java.lang.Double landArea;
    /**建筑面积(㎡)*/
    @Excel(name = "建筑面积(㎡)", width = 15)
    @Schema(description = "建筑面积(㎡)")
    private java.lang.Double buildingArea;
    /**容积率*/
    @Excel(name = "容积率", width = 15)
    @Schema(description = "容积率")
    private java.lang.Double floorAreaRatio;
    /**竞得单位*/
    @Excel(name = "竞得单位", width = 15)
    @Schema(description = "竞得单位")
    private java.lang.String winningCompany;
    /**挂牌价格(万元)*/
    @Excel(name = "挂牌价格(万元)", width = 15)
    @Schema(description = "挂牌价格(万元)")
    private java.lang.Double listingPrice;
    /**成交总价(万元)*/
    @Excel(name = "成交总价(万元)", width = 15)
    @Schema(description = "成交总价(万元)")
    private java.lang.Double transactionPrice;
    /**地块位置*/
    @Excel(name = "地块位置", width = 15)
    @Schema(description = "地块位置")
    private java.lang.String location;
    /**地块状态*/
    @Excel(name = "地块状态", width = 15)
    @Dict(dicCode = "land_status")
    @Schema(description = "地块状态")
    private java.lang.String landStatus;
    /**场地状态*/
    @Excel(name = "场地状态", width = 15)
    @Dict(dicCode = "site_status")
    @Schema(description = "场地状态")
    private java.lang.String siteStatus;
    /**成交日期*/
    @Excel(name = "成交日期", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "成交日期")
    private java.util.Date transactionDate;
    /**楼面价(元/㎡)*/
    @Excel(name = "楼面价(元/㎡)", width = 15)
    @Schema(description = "楼面价(元/㎡)")
    private java.lang.Double floorPrice;
    /**溢价率(%)*/
    @Excel(name = "溢价率(%)", width = 15)
    @Schema(description = "溢价率(%)")
    private java.lang.String premiumRate;
    /**交通配套*/
    @Excel(name = "交通配套", width = 15)
    @Schema(description = "交通配套")
    private java.lang.String transportation;
    /**教育资源*/
    @Excel(name = "教育资源", width = 15)
    @Schema(description = "教育资源")
    private java.lang.String education;
    /**商业配套*/
    @Excel(name = "商业配套", width = 15)
    @Schema(description = "商业配套")
    private java.lang.String commercial;
    /**休闲配套*/
    @Excel(name = "休闲配套", width = 15)
    @Schema(description = "休闲配套")
    private java.lang.String recreation;
    /**周边楼盘*/
    @Excel(name = "周边楼盘", width = 15)
    @Schema(description = "周边楼盘")
    private java.lang.String surroundingBuildings;
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
