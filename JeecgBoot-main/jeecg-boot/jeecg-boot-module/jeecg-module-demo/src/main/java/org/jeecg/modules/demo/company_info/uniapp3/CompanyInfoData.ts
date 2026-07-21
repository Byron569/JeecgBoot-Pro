import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '企业ID',
    align:"center",
    dataIndex: 'companyId'
   },
   {
    title: '企业全称',
    align:"center",
    dataIndex: 'companyName'
   },
   {
    title: '企业简称',
    align:"center",
    dataIndex: 'companyShortName'
   },
   {
    title: '所在地块',
    align:"center",
    dataIndex: 'landParcelId'
   },
   {
    title: '统一信用代码',
    align:"center",
    dataIndex: 'creditCode'
   },
   {
    title: '企业类型',
    align:"center",
    dataIndex: 'companyType'
   },
   {
    title: '所属行业',
    align:"center",
    dataIndex: 'industry'
   },
   {
    title: '注册资本',
    align:"center",
    dataIndex: 'registeredCapital'
   },
   {
    title: '法人姓名',
    align:"center",
    dataIndex: 'legalPerson'
   },
   {
    title: '对接人姓名',
    align:"center",
    dataIndex: 'contactPerson'
   },
   {
    title: '对接人电话',
    align:"center",
    dataIndex: 'contactPhone'
   },
   {
    title: '经营地址',
    align:"center",
    dataIndex: 'businessAddress'
   },
   {
    title: '企业简介/核心业务',
    align:"center",
    dataIndex: 'companyProfile'
   },
   {
    title: '企业状态',
    align:"center",
    dataIndex: 'companyStatus'
   },
];