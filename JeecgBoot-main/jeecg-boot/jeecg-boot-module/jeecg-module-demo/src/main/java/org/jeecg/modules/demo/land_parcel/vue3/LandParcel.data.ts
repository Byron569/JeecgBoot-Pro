import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
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
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "	地块编号",
      field: 'parcelCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "	地块名称",
      field: 'parcelName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "	所属工业园",
      field: 'industrialPark',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sys_dict,industrial_park,industrial_park"
      },
      //colProps: {span: 6},
 	},
	{
      label: "	用途",
      field: 'landPurpose',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sys_dict,land_purpose,land_purpose"
      },
      //colProps: {span: 6},
 	},
	{
      label: "地块状态",
      field: 'landStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sys_dict,land_status,land_status"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '	地块编号',
    field: 'parcelCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入	地块编号!'},
          ];
     },
  },
  {
    label: '	地块名称',
    field: 'parcelName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入	地块名称!'},
          ];
     },
  },
  {
    label: '	所属工业园',
    field: 'industrialPark',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sys_dict,industrial_park,industrial_park",
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入	所属工业园!'},
          ];
     },
  },
  {
    label: '	用途',
    field: 'landPurpose',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sys_dict,land_purpose,land_purpose",
     },
  },
  {
    label: '	面积(亩)',
    field: 'landArea',
    component: 'InputNumber',
  },
  {
    label: '建筑面积(㎡)',
    field: 'buildingArea',
    component: 'InputNumber',
  },
  {
    label: '	容积率',
    field: 'floorAreaRatio',
    component: 'InputNumber',
  },
  {
    label: '竞得单位',
    field: 'winningCompany',
    component: 'Input',
  },
  {
    label: '挂牌价格(万元)',
    field: 'listingPrice',
    component: 'InputNumber',
  },
  {
    label: '成交总价(万元)',
    field: 'transactionPrice',
    component: 'InputNumber',
  },
  {
    label: '	地块位置',
    field: 'location',
    component: 'Input',
  },
  {
    label: '地块状态',
    field: 'landStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sys_dict,land_status,land_status",
     },
  },
  {
    label: '场地状态',
    field: 'siteStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sys_dict,	site_status,	site_status",
     },
  },
  {
    label: '成交日期',
    field: 'transactionDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '	楼面价(元/㎡)',
    field: 'floorPrice',
    component: 'InputNumber',
  },
  {
    label: '溢价率(%)',
    field: 'premiumRate',
    component: 'Input',
  },
  {
    label: '交通配套',
    field: 'transportation',
    component: 'InputTextArea',
  },
  {
    label: '教育资源',
    field: 'education',
    component: 'InputTextArea',
  },
  {
    label: '商业配套',
    field: 'commercial',
    component: 'InputTextArea',
  },
  {
    label: '	休闲配套',
    field: 'recreation',
    component: 'InputTextArea',
  },
  {
    label: '周边楼盘',
    field: 'surroundingBuildings',
    component: 'InputTextArea',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  parcelCode: {title: '	地块编号',order: 0,view: 'text', type: 'string',},
  parcelName: {title: '	地块名称',order: 1,view: 'text', type: 'string',},
  industrialPark: {title: '	所属工业园',order: 2,view: 'list', type: 'string',dictTable: "sys_dict", dictCode: 'industrial_park', dictText: 'industrial_park',},
  landArea: {title: '	面积(亩)',order: 4,view: 'number', type: 'number',},
  landStatus: {title: '地块状态',order: 11,view: 'list', type: 'string',dictTable: "sys_dict", dictCode: 'land_status', dictText: 'land_status',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}