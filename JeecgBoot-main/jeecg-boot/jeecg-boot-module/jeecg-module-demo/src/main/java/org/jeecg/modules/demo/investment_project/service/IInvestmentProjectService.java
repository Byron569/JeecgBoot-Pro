package org.jeecg.modules.demo.investment_project.service;

import org.jeecg.modules.demo.investment_project.entity.InvestmentProjectRel;
import org.jeecg.modules.demo.investment_project.entity.InvestmentProject;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IInvestmentProjectService extends IService<InvestmentProject> {

	public void saveMain(InvestmentProject investmentProject,List<InvestmentProjectRel> investmentProjectRelList) ;
	
	public void updateMain(InvestmentProject investmentProject,List<InvestmentProjectRel> investmentProjectRelList);
	
	public void delMain (String id);
	
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
