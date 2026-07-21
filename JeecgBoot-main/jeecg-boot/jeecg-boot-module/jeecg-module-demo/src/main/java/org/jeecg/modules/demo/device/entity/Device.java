package org.jeecg.modules.demo.device.entity;

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
 * @Description: 设备管理
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
@Data
@TableName("device")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="设备管理")
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
	/**设备编号*/
	@Excel(name = "设备编号", width = 15)
    @Schema(description = "设备编号")
    private java.lang.String deviceCode;
	/**设备名称*/
	@Excel(name = "设备名称", width = 15)
    @Schema(description = "设备名称")
    private java.lang.String deviceName;
	/**设备类型*/
	@Excel(name = "设备类型", width = 15, dicCode = "device_type")
	@Dict(dicCode = "device_type")
    @Schema(description = "设备类型")
    private java.lang.String deviceType;
	/**所属地块*/
	@Excel(name = "所属地块", width = 15)
	@Dict(dictTable = "land_parcel", dicText = "parcel_name", dicCode = "id")
    @Schema(description = "所属地块")
    private java.lang.String landParcelId;
	/**坐标*/
	@Excel(name = "坐标", width = 15)
    @Schema(description = "坐标")
    private java.lang.String coordinates;
	/**设备状态*/
	@Excel(name = "设备状态", width = 15, dicCode = "device_status")
	@Dict(dicCode = "device_status")
    @Schema(description = "设备状态")
    private java.lang.String deviceStatus;
	/**安装时间*/
	@Excel(name = "安装时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "安装时间")
    private java.util.Date installTime;
	/**监控URL*/
	@Excel(name = "监控URL", width = 15)
    @Schema(description = "监控URL")
    private java.lang.String monitorUrl;
	/**坐标(经度,纬度)*/
    @Schema(description = "坐标(经度,纬度)")
    private java.lang.String longitudeLatitude;
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
