package org.jeecg.modules.demo.standard_workshop.mapper;

import java.util.List;
import org.jeecg.modules.demo.standard_workshop.entity.WorkshopSettle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 厂房入驻情况
 * @Author: jeecg-boot
 * @Date:   2026-07-17
 * @Version: V1.0
 */
public interface WorkshopSettleMapper extends BaseMapper<WorkshopSettle> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<WorkshopSettle>
   */
	public List<WorkshopSettle> selectByMainId(@Param("mainId") String mainId);
}
