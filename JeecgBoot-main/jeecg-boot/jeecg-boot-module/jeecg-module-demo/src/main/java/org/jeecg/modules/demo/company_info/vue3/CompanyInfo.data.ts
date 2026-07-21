import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
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
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业ID',
    field: 'companyId',
    component: 'Input',
  },
  {
    label: '企业全称',
    field: 'companyName',
    component: 'Input',
  },
  {
    label: '企业简称',
    field: 'companyShortName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业简称!'},
          ];
     },
  },
  {
    label: '所在地块',
    field: 'landParcelId',
    component: 'JPopup',
    componentProps: ({ formActionType }) => {
        const {setFieldsValue} = formActionType;
        return{
            setFieldsValue:setFieldsValue,
            code:"land_parcel",
            fieldConfig: [
                { source: 'parcel_name', target: 'id' },
            ],
            multi:true
        }
    },

    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所在地块!'},
          ];
     },
  },
  {
    label: '统一信用代码',
    field: 'creditCode',
    component: 'Input',
  },
  {
    label: '企业类型',
    field: 'companyType',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业类型!'},
          ];
     },
  },
  {
    label: '所属行业',
    field: 'industry',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属行业!'},
          ];
     },
  },
  {
    label: '注册资本',
    field: 'registeredCapital',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入注册资本!'},
          ];
     },
  },
  {
    label: '法人姓名',
    field: 'legalPerson',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入法人姓名!'},
          ];
     },
  },
  {
    label: '对接人姓名',
    field: 'contactPerson',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入对接人姓名!'},
          ];
     },
  },
  {
    label: '对接人电话',
    field: 'contactPhone',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入对接人电话!'},
          ];
     },
  },
  {
    label: '经营地址',
    field: 'businessAddress',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入经营地址!'},
          ];
     },
  },
  {
    label: '企业简介/核心业务',
    field: 'companyProfile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业简介/核心业务!'},
          ];
     },
  },
  {
    label: '企业状态',
    field: 'companyStatus',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业状态!'},
          ];
     },
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
  companyId: {title: '企业ID',order: 0,view: 'text', type: 'string',},
  companyName: {title: '企业全称',order: 1,view: 'text', type: 'string',},
  companyShortName: {title: '企业简称',order: 2,view: 'text', type: 'string',},
  landParcelId: {title: '所在地块',order: 3,view: 'popup', type: 'string',code: 'land_parcel', orgFields: 'parcel_name', destFields: 'landParcelId', popupMulti: false,},
  creditCode: {title: '统一信用代码',order: 4,view: 'text', type: 'string',},
  companyType: {title: '企业类型',order: 5,view: 'text', type: 'string',},
  industry: {title: '所属行业',order: 6,view: 'text', type: 'string',},
  registeredCapital: {title: '注册资本',order: 7,view: 'number', type: 'number',},
  legalPerson: {title: '法人姓名',order: 8,view: 'text', type: 'string',},
  contactPerson: {title: '对接人姓名',order: 9,view: 'text', type: 'string',},
  contactPhone: {title: '对接人电话',order: 10,view: 'text', type: 'string',},
  businessAddress: {title: '经营地址',order: 11,view: 'text', type: 'string',},
  companyProfile: {title: '企业简介/核心业务',order: 12,view: 'text', type: 'string',},
  companyStatus: {title: '企业状态',order: 13,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}