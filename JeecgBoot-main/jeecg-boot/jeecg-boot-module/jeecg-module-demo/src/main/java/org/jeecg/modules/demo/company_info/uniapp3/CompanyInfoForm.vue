<route lang="json5" type="page">
{
layout: 'default',
style: {
navigationStyle: 'custom',
navigationBarTitleText: '企业信息管理',
},
}
</route>
<template>
  <PageLayout :navTitle="navTitle" :backRouteName="backRouteName">
    <scroll-view class="scrollArea" scroll-y>
      <view class="form-container">
        <wd-form ref="form" :model="myFormData">
          <wd-cell-group border>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['companyId']"
                  :label="get4Label('企业ID')"
                  name='companyId'
                  prop='companyId'
                  placeholder="请选择企业ID"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['companyName']"
                  :label="get4Label('企业全称')"
                  name='companyName'
                  prop='companyName'
                  placeholder="请选择企业全称"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['companyShortName']"
                  :label="get4Label('企业简称')"
                  name='companyShortName'
                  prop='companyShortName'
                  placeholder="请选择企业简称"
                  :rules="[
                                  { required: true, message: '请输入企业简称!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
             <Popup
                labelWidth="100px"
                :label="get4Label('所在地块')"
                v-model="myFormData['landParcelId']"
                :multi="true"
                code="land_parcel"
                :setFieldsValue="setFieldsValue"
                :fieldConfig="[
                    { source: 'parcel_name', target: 'id' },
                ]"
              ></Popup>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['creditCode']"
                  :label="get4Label('统一信用代码')"
                  name='creditCode'
                  prop='creditCode'
                  placeholder="请选择统一信用代码"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['companyType']"
                  :label="get4Label('企业类型')"
                  name='companyType'
                  prop='companyType'
                  placeholder="请选择企业类型"
                  :rules="[
                                  { required: true, message: '请输入企业类型!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['industry']"
                  :label="get4Label('所属行业')"
                  name='industry'
                  prop='industry'
                  placeholder="请选择所属行业"
                  :rules="[
                                  { required: true, message: '请输入所属行业!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['registeredCapital']"
                   :label="get4Label('注册资本')"
                   name='registeredCapital'
                   prop='registeredCapital'
                   placeholder="请选择注册资本"
                   inputMode="numeric"
                   :rules="[
                             { required: true, message: '请输入注册资本!'},
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['legalPerson']"
                  :label="get4Label('法人姓名')"
                  name='legalPerson'
                  prop='legalPerson'
                  placeholder="请选择法人姓名"
                  :rules="[
                                  { required: true, message: '请输入法人姓名!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['contactPerson']"
                  :label="get4Label('对接人姓名')"
                  name='contactPerson'
                  prop='contactPerson'
                  placeholder="请选择对接人姓名"
                  :rules="[
                                  { required: true, message: '请输入对接人姓名!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['contactPhone']"
                  :label="get4Label('对接人电话')"
                  name='contactPhone'
                  prop='contactPhone'
                  placeholder="请选择对接人电话"
                  :rules="[
                                  { required: true, message: '请输入对接人电话!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['businessAddress']"
                  :label="get4Label('经营地址')"
                  name='businessAddress'
                  prop='businessAddress'
                  placeholder="请选择经营地址"
                  :rules="[
                                  { required: true, message: '请输入经营地址!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['companyProfile']"
                  :label="get4Label('企业简介/核心业务')"
                  name='companyProfile'
                  prop='companyProfile'
                  placeholder="请选择企业简介/核心业务"
                  :rules="[
                                  { required: true, message: '请输入企业简介/核心业务!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['companyStatus']"
                  :label="get4Label('企业状态')"
                  name='companyStatus'
                  prop='companyStatus'
                  placeholder="请选择企业状态"
                  :rules="[
                                  { required: true, message: '请输入企业状态!'},
                  ]"
                  clearable
              />
        </view>
          </wd-cell-group>
        </wd-form>
      </view>
    </scroll-view>
    <view class="footer">
      <wd-button :disabled="loading" block :loading="loading" @click="handleSubmit">提交</wd-button>
    </view>
  </PageLayout>
</template>

<script lang="ts" setup>
import { onLoad } from '@dcloudio/uni-app'
import { http } from '@/utils/http'
import { useToast } from 'wot-design-uni'
import { useRouter } from '@/plugin/uni-mini-router'
import { ref, onMounted, computed,reactive } from 'vue'
import OnlineImage from '@/components/online/view/online-image.vue'
import OnlineFile from '@/components/online/view/online-file.vue'
import OnlineFileCustom from '@/components/online/view/online-file-custom.vue'
import OnlineSelect from '@/components/online/view/online-select.vue'
import OnlineTime from '@/components/online/view/online-time.vue'
import OnlineDate from '@/components/online/view/online-date.vue'
import OnlineRadio from '@/components/online/view/online-radio.vue'
import OnlineCheckbox from '@/components/online/view/online-checkbox.vue'
import OnlineMulti from '@/components/online/view/online-multi.vue'
import OnlinePopupLinkRecord from '@/components/online/view/online-popup-link-record.vue'
import OnlinePca from '@/components/online/view/online-pca.vue'
import SelectDept from '@/components/SelectDept/SelectDept.vue'
import SelectUser from '@/components/SelectUser/SelectUser.vue'
import {duplicateCheck} from "@/service/api";
defineOptions({
  name: 'CompanyInfoForm',
  options: {
    styleIsolation: 'shared',
  },
})
const toast = useToast()
const router = useRouter()
const form = ref(null)
// 定义响应式数据
const myFormData = reactive({})
const loading = ref(false)
const navTitle = ref('新增')
const dataId = ref('')
const backRouteName = ref('CompanyInfoList')
// 定义 initForm 方法
const initForm = (item) => {
  console.log('initForm item', item)
  if(item?.dataId){
    dataId.value = item.dataId;
    navTitle.value = item.dataId?'编辑':'新增';
    initData();
  }
}
// 初始化数据
const initData = () => {
  http.get("/company_info/companyInfo/queryById",{id:dataId.value}).then((res) => {
    if (res.success) {
      let obj = res.result
      Object.assign(myFormData, { ...obj })
    }else{
      toast.error(res?.message || '表单加载失败！')
    }
  })
}
const handleSuccess = () => {
  uni.$emit('refreshList');
  router.back()
}
/**
 * 校验唯一
 * @param values
 * @returns {boolean}
 */
async function fieldCheck(values: any) {
   const onlyField = [
   ];
   for (const field of onlyField) {
      if (values[field]) {
          // 仅校验有值的字段
          const res: any = await duplicateCheck({
              tableName: 'company_info',
              fieldName: field,  // 使用处理后的字段名
              fieldVal: values[field],
              dataId: values.id,
          });
          if (!res.success) {
              toast.warning(res.message);
              return true;  // 校验失败
          }
      }
   }
   return false;  // 校验通过
}
// 提交表单
const handleSubmit = async () => {
 // 判断字段必填和正则
  if (await fieldCheck(myFormData)) {
    return
  }
  let url = dataId.value?'/company_info/companyInfo/edit':'/company_info/companyInfo/add';
  form.value
    .validate()
    .then(({ valid, errors }) => {
      if (valid) {
        loading.value = true;
        http.post(url,myFormData).then((res) => {
          loading.value = false;
          if (res.success) {
            toast.success('保存成功');
            handleSuccess()
          }else{
            toast.error(res?.message || '表单保存失败！')
          }
        })
      }
    })
    .catch((error) => {
      console.log(error, 'error')
      loading.value = false;
    })
}
// 标题
const get4Label = computed(() => {
  return (label) => {
    return label && label.length > 4 ? label.substring(0, 4) : label;
  }
})

// 标题
const getFormSchema = computed(() => {
  return (dictTable,dictCode,dictText) => {
    return {
      dictCode,
      dictTable,
      dictText
    };
  }
})
/**
 * 获取日期控件的扩展类型
 * @param picker
 * @returns {string}
 */
const getDateExtendType = (picker: string) => {
    let mapField = {
      month: 'year-month',
      year: 'year',
      quarter: 'quarter',
      week: 'week',
      day: 'date',
    }
    return picker && mapField[picker]
      ? mapField[picker]
      : 'date'
}
//设置pop返回值
const setFieldsValue = (data) => {
   Object.assign(myFormData, {...data })
}
// onLoad 生命周期钩子
onLoad((option) => {
  initForm(option)
})
</script>

<style lang="scss" scoped>
.footer {
  width: 100%;
  padding: 10px 20px;
  padding-bottom: calc(constant(safe-area-inset-bottom) + 10px);
  padding-bottom: calc(env(safe-area-inset-bottom) + 10px);
}
:deep(.wd-cell__label) {
  font-size: 14px;
  color: #444;
}
:deep(.wd-cell__value) {
  text-align: left;
}
</style>
