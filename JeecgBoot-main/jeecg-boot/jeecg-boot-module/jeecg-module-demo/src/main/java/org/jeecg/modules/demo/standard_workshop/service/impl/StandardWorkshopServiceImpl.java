package org.jeecg.modules.demo.standard_workshop.service.impl;

import org.jeecg.modules.demo.standard_workshop.entity.StandardWorkshop;
import org.jeecg.modules.demo.standard_workshop.entity.WorkshopSettle;
import org.jeecg.modules.demo.standard_workshop.mapper.WorkshopSettleMapper;
import org.jeecg.modules.demo.standard_workshop.mapper.StandardWorkshopMapper;
import org.jeecg.modules.demo.standard_workshop.service.IStandardWorkshopService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 标准厂房管理
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
@Service
public class StandardWorkshopServiceImpl extends ServiceImpl<StandardWorkshopMapper, StandardWorkshop> implements IStandardWorkshopService {

	@Autowired
	private StandardWorkshopMapper standardWorkshopMapper;
	@Autowired
	private WorkshopSettleMapper workshopSettleMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(StandardWorkshop standardWorkshop, List<WorkshopSettle> workshopSettleList) {
		standardWorkshopMapper.insert(standardWorkshop);
		if(workshopSettleList!=null && workshopSettleList.size()>0) {
			for(WorkshopSettle entity:workshopSettleList) {
				//外键设置
				entity.setHeadId(standardWorkshop.getId());
				workshopSettleMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(StandardWorkshop standardWorkshop,List<WorkshopSettle> workshopSettleList) {
		standardWorkshopMapper.updateById(standardWorkshop);
		
		//1.先删除子表数据
		workshopSettleMapper.deleteByMainId(standardWorkshop.getId());
		
		//2.子表数据重新插入
		if(workshopSettleList!=null && workshopSettleList.size()>0) {
			for(WorkshopSettle entity:workshopSettleList) {
				//外键设置
				entity.setHeadId(standardWorkshop.getId());
				workshopSettleMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		workshopSettleMapper.deleteByMainId(id);
		standardWorkshopMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			workshopSettleMapper.deleteByMainId(id.toString());
			standardWorkshopMapper.deleteById(id);
		}
	}
	
}
