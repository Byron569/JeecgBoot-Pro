package org.jeecg.modules.demo.company_info.service.impl;

import org.jeecg.modules.demo.company_info.entity.CompanyInfo;
import org.jeecg.modules.demo.company_info.mapper.CompanyInfoMapper;
import org.jeecg.modules.demo.company_info.service.ICompanyInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 企业信息管理
 * @Author: jeecg-boot
 * @Date:   2026-07-14
 * @Version: V1.0
 */
@Service
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfo> implements ICompanyInfoService {

}
