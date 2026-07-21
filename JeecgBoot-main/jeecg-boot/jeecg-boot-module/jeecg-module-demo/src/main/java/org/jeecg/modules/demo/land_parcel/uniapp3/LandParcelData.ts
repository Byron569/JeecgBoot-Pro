import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '	地块编号',
    align:"center",
    dataIndex: 'parcelCode'
   },
   {
    title: '	地块名称',
    align:"center",
    dataIndex: 'parcelName'
   },
   {
    title: '	所属工业园',
    align:"center",
    dataIndex: 'industrialPark_dictText'
   },
   {
    title: '	面积(亩)',
    align:"center",
    dataIndex: 'landArea'
   },
   {
    title: '地块状态',
    align:"center",
    dataIndex: 'landStatus_dictText'
   },
];