package org.jeecg.modules.demo.investment_project.mapper;

import java.util.List;
import org.jeecg.modules.demo.investment_project.entity.InvestmentProjectRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface InvestmentProjectRelMapper extends BaseMapper<InvestmentProjectRel> {

	public boolean deleteByMainId(@Param("mainId") String mainId);

	public List<InvestmentProjectRel> selectByMainId(@Param("mainId") String mainId);
}
