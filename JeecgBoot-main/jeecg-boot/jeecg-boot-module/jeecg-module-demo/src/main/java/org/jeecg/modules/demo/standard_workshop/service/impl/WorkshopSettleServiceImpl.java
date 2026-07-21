package org.jeecg.modules.demo.standard_workshop.service.impl;

import org.jeecg.modules.demo.standard_workshop.entity.WorkshopSettle;
import org.jeecg.modules.demo.standard_workshop.mapper.WorkshopSettleMapper;
import org.jeecg.modules.demo.standard_workshop.service.IWorkshopSettleService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 厂房入驻情况
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
@Service
public class WorkshopSettleServiceImpl extends ServiceImpl<WorkshopSettleMapper, WorkshopSettle> implements IWorkshopSettleService {
	
	@Autowired
	private WorkshopSettleMapper workshopSettleMapper;
	
	@Override
	public List<WorkshopSettle> selectByMainId(String mainId) {
		return workshopSettleMapper.selectByMainId(mainId);
	}
}
