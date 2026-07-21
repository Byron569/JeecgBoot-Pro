package org.jeecg.modules.demo.investment_project.service;

import org.jeecg.modules.demo.investment_project.entity.InvestmentProjectRel;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface IInvestmentProjectRelService extends IService<InvestmentProjectRel> {

	public List<InvestmentProjectRel> selectByMainId(String mainId);
}
