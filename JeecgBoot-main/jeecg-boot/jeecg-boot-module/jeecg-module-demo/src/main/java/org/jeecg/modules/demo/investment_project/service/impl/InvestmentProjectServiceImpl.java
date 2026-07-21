package org.jeecg.modules.demo.investment_project.service.impl;

import org.jeecg.modules.demo.investment_project.entity.InvestmentProject;
import org.jeecg.modules.demo.investment_project.entity.InvestmentProjectRel;
import org.jeecg.modules.demo.investment_project.mapper.InvestmentProjectRelMapper;
import org.jeecg.modules.demo.investment_project.mapper.InvestmentProjectMapper;
import org.jeecg.modules.demo.investment_project.service.IInvestmentProjectService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

@Service
public class InvestmentProjectServiceImpl extends ServiceImpl<InvestmentProjectMapper, InvestmentProject> implements IInvestmentProjectService {

	@Autowired
	private InvestmentProjectMapper investmentProjectMapper;
	@Autowired
	private InvestmentProjectRelMapper investmentProjectRelMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(InvestmentProject investmentProject, List<InvestmentProjectRel> investmentProjectRelList) {
		investmentProjectMapper.insert(investmentProject);
		if(investmentProjectRelList!=null && investmentProjectRelList.size()>0) {
			for(InvestmentProjectRel entity:investmentProjectRelList) {
				entity.setHeadId(investmentProject.getId());
				investmentProjectRelMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(InvestmentProject investmentProject,List<InvestmentProjectRel> investmentProjectRelList) {
		investmentProjectMapper.updateById(investmentProject);
		investmentProjectRelMapper.deleteByMainId(investmentProject.getId());
		if(investmentProjectRelList!=null && investmentProjectRelList.size()>0) {
			for(InvestmentProjectRel entity:investmentProjectRelList) {
				entity.setHeadId(investmentProject.getId());
				investmentProjectRelMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		investmentProjectRelMapper.deleteByMainId(id);
		investmentProjectMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			investmentProjectRelMapper.deleteByMainId(id.toString());
			investmentProjectMapper.deleteById(id);
		}
	}
	
}
