<route lang="json5" type="page">
{
layout: 'default',
style: {
navigationStyle: 'custom',
navigationBarTitleText: '地块信息表',
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
                  v-model="myFormData['parcelCode']"
                  :label="get4Label('	地块编号')"
                  name='parcelCode'
                  prop='parcelCode'
                  placeholder="请选择	地块编号"
                  :rules="[
                                  { required: true, message: '请输入	地块编号!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['parcelName']"
                  :label="get4Label('	地块名称')"
                  name='parcelName'
                  prop='parcelName'
                  placeholder="请选择	地块名称"
                  :rules="[
                                  { required: true, message: '请输入	地块名称!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <online-select
                :label="get4Label('	所属工业园')"
                 labelWidth="100px"
                 type="list"
                 name='industrialPark'
                 dict="sys_dict,industrial_park,industrial_park"
                v-model="myFormData['industrialPark']"
              ></online-select>
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <online-select
                :label="get4Label('	用途')"
                 labelWidth="100px"
                 type="list"
                 name='landPurpose'
                 dict="sys_dict,land_purpose,land_purpose"
                v-model="myFormData['landPurpose']"
              ></online-select>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['landArea']"
                   :label="get4Label('	面积(亩)')"
                   name='landArea'
                   prop='landArea'
                   placeholder="请选择	面积(亩)"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['buildingArea']"
                   :label="get4Label('建筑面积(㎡)')"
                   name='buildingArea'
                   prop='buildingArea'
                   placeholder="请选择建筑面积(㎡)"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['floorAreaRatio']"
                   :label="get4Label('	容积率')"
                   name='floorAreaRatio'
                   prop='floorAreaRatio'
                   placeholder="请选择	容积率"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['winningCompany']"
                  :label="get4Label('竞得单位')"
                  name='winningCompany'
                  prop='winningCompany'
                  placeholder="请选择竞得单位"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['listingPrice']"
                   :label="get4Label('挂牌价格(万元)')"
                   name='listingPrice'
                   prop='listingPrice'
                   placeholder="请选择挂牌价格(万元)"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['transactionPrice']"
                   :label="get4Label('成交总价(万元)')"
                   name='transactionPrice'
                   prop='transactionPrice'
                   placeholder="请选择成交总价(万元)"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['location']"
                  :label="get4Label('	地块位置')"
                  name='location'
                  prop='location'
                  placeholder="请选择	地块位置"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <online-select
                :label="get4Label('地块状态')"
                 labelWidth="100px"
                 type="list"
                 name='landStatus'
                 dict="sys_dict,land_status,land_status"
                v-model="myFormData['landStatus']"
              ></online-select>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <online-select
                :label="get4Label('场地状态')"
                 labelWidth="100px"
                 type="list"
                 name='siteStatus'
                 dict="sys_dict,	site_status,	site_status"
                v-model="myFormData['siteStatus']"
              ></online-select>
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <online-date
                  :label="get4Label('成交日期')"
                  labelWidth="100px"
                  type="date"
                  name='transactionDate'
                  v-model:value="myFormData['transactionDate']"
              ></online-date>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['floorPrice']"
                   :label="get4Label('	楼面价(元/㎡)')"
                   name='floorPrice'
                   prop='floorPrice'
                   placeholder="请选择	楼面价(元/㎡)"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['premiumRate']"
                  :label="get4Label('溢价率(%)')"
                  name='premiumRate'
                  prop='premiumRate'
                  placeholder="请选择溢价率(%)"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-textarea
                :label="get4Label('交通配套')"
                 labelWidth="100px"
                 type="textarea"
                 name='transportation'
                 prop='transportation'
                 clearable
                 :maxlength="300"
                v-model="myFormData['transportation']"
              ></wd-textarea>
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-textarea
                :label="get4Label('教育资源')"
                 labelWidth="100px"
                 type="textarea"
                 name='education'
                 prop='education'
                 clearable
                 :maxlength="300"
                v-model="myFormData['education']"
              ></wd-textarea>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-textarea
                :label="get4Label('商业配套')"
                 labelWidth="100px"
                 type="textarea"
                 name='commercial'
                 prop='commercial'
                 clearable
                 :maxlength="300"
                v-model="myFormData['commercial']"
              ></wd-textarea>
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-textarea
                :label="get4Label('	休闲配套')"
                 labelWidth="100px"
                 type="textarea"
                 name='recreation'
                 prop='recreation'
                 clearable
                 :maxlength="300"
                v-model="myFormData['recreation']"
              ></wd-textarea>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-textarea
                :label="get4Label('周边楼盘')"
                 labelWidth="100px"
                 type="textarea"
                 name='surroundingBuildings'
                 prop='surroundingBuildings'
                 clearable
                 :maxlength="300"
                v-model="myFormData['surroundingBuildings']"
              ></wd-textarea>
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
  name: 'LandParcelForm',
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
const backRouteName = ref('LandParcelList')
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
  http.get("/land_parcel/landParcel/queryById",{id:dataId.value}).then((res) => {
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
              tableName: 'land_parcel',
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
  let url = dataId.value?'/land_parcel/landParcel/edit':'/land_parcel/landParcel/add';
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
