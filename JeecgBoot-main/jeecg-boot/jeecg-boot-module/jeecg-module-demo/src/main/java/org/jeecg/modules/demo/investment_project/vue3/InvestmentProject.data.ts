import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
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
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "项目编号",
      field: 'projectCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
  {
    label: "项目名称",
    field: "projectName",
    component: 'JInput',
  },
	{
      label: "产业类型",
      field: 'industryType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sys_dict,	industry,	industry"
      },
      //colProps: {span: 6},
 	},
	{
      label: "项目状态",
      field: 'projectStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sys_dict,project_status,project_status"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '项目编号',
    field: 'projectCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目编号!'},
          ];
     },
  },
  {
    label: '项目名称',
    field: 'projectName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目名称!'},
          ];
     },
  },
  {
    label: '产业类型',
    field: 'industryType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sys_dict,	industry,	industry",
     },
  },
  {
    label: '所在地块',
    field: 'landParcelId',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"	land_parcel,parcel_name,	id",
     },
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
    label: '投资额（万元）',
    field: 'investmentAmount',
    component: 'InputNumber',
  },
  {
    label: '联系人',
    field: 'contactPerson',
    component: 'Input',
  },
  {
    label: '联系电话',
    field: 'contactPhone',
    component: 'Input',
  },
  {
    label: '项目简介',
    field: 'projectIntro',
    component: 'InputTextArea',
  },
  {
    label: '项目意向',
    field: 'projectIntention',
    component: 'InputTextArea',
  },
  {
    label: '预计投产时间',
    field: 'expectedStartDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '实际投产时间',
    field: 'actualStartDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '项目状态',
    field: 'projectStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sys_dict,project_status,project_status",
     },
  },
  {
    label: '引资单位',
    field: 'investmentUnit',
    component: 'Input',
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
  projectCode: {title: '项目编号',order: 0,view: 'text', type: 'string',},
  projectName: {title: '项目名称',order: 1,view: 'text', type: 'string',},
  industryType: {title: '产业类型',order: 2,view: 'list', type: 'string',dictTable: "sys_dict", dictCode: '	industry', dictText: '	industry',},
  landParcelId: {title: '所在地块',order: 3,view: 'list', type: 'string',dictTable: "	land_parcel", dictCode: '	id', dictText: 'parcel_name',},
  landStatus: {title: '地块状态',order: 4,view: 'list', type: 'string',dictTable: "sys_dict", dictCode: 'land_status', dictText: 'land_status',},
  investmentAmount: {title: '投资额（万元）',order: 5,view: 'number', type: 'number',},
  contactPhone: {title: '联系电话',order: 7,view: 'text', type: 'string',},
  projectStatus: {title: '项目状态',order: 12,view: 'list', type: 'string',dictTable: "sys_dict", dictCode: 'project_status', dictText: 'project_status',},
  investmentUnit: {title: '引资单位',order: 13,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}