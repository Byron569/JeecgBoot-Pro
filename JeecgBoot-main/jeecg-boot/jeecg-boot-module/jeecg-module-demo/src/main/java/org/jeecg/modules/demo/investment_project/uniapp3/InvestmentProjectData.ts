import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '项目编号',
    align:"center",
    dataIndex: 'projectCode'
   },
   {
    title: '项目名称',
    align:"center",
    dataIndex: 'projectName'
   },
   {
    title: '产业类型',
    align:"center",
    dataIndex: 'industryType_dictText'
   },
   {
    title: '所在地块',
    align:"center",
    dataIndex: 'landParcelId_dictText'
   },
   {
    title: '地块状态',
    align:"center",
    dataIndex: 'landStatus_dictText'
   },
   {
    title: '投资额（万元）',
    align:"center",
    dataIndex: 'investmentAmount'
   },
   {
    title: '联系电话',
    align:"center",
    dataIndex: 'contactPhone'
   },
   {
    title: '项目状态',
    align:"center",
    dataIndex: 'projectStatus_dictText'
   },
   {
    title: '引资单位',
    align:"center",
    dataIndex: 'investmentUnit'
   },
];