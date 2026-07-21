package org.jeecg.modules.demo.investment_project.service.impl;

import org.jeecg.modules.demo.investment_project.entity.InvestmentProjectRel;
import org.jeecg.modules.demo.investment_project.mapper.InvestmentProjectRelMapper;
import org.jeecg.modules.demo.investment_project.service.IInvestmentProjectRelService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InvestmentProjectRelServiceImpl extends ServiceImpl<InvestmentProjectRelMapper, InvestmentProjectRel> implements IInvestmentProjectRelService {
	
	@Autowired
	private InvestmentProjectRelMapper investmentProjectRelMapper;
	
	@Override
	public List<InvestmentProjectRel> selectByMainId(String mainId) {
		return investmentProjectRelMapper.selectByMainId(mainId);
	}
}
