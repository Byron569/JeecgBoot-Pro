package org.jeecg.modules.demo.device.service.impl;

import org.jeecg.modules.demo.device.entity.Device;
import org.jeecg.modules.demo.device.mapper.DeviceMapper;
import org.jeecg.modules.demo.device.service.IDeviceService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 设备管理
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

}
