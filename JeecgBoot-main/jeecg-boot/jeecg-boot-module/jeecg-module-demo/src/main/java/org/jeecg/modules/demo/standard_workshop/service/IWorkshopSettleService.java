package org.jeecg.modules.demo.standard_workshop.service;

import org.jeecg.modules.demo.standard_workshop.entity.WorkshopSettle;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 厂房入驻情况
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
public interface IWorkshopSettleService extends IService<WorkshopSettle> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<WorkshopSettle>
	 */
	public List<WorkshopSettle> selectByMainId(String mainId);
}
