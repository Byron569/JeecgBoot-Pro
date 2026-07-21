package org.jeecg.modules.demo.standard_workshop.service;

import org.jeecg.modules.demo.standard_workshop.entity.WorkshopSettle;
import org.jeecg.modules.demo.standard_workshop.entity.StandardWorkshop;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 标准厂房管理
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
public interface IStandardWorkshopService extends IService<StandardWorkshop> {

	/**
	 * 添加一对多
	 *
	 * @param standardWorkshop
	 * @param workshopSettleList
	 */
	public void saveMain(StandardWorkshop standardWorkshop,List<WorkshopSettle> workshopSettleList) ;
	
	/**
	 * 修改一对多
	 *
   * @param standardWorkshop
   * @param workshopSettleList
	 */
	public void updateMain(StandardWorkshop standardWorkshop,List<WorkshopSettle> workshopSettleList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
