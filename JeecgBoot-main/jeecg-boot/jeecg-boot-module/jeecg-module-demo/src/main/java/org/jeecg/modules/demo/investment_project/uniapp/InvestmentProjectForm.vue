<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">招商项目管理</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目编号：</text></view>
                  <input  placeholder="请输入项目编号" v-model="model.projectCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目名称：</text></view>
                  <input  placeholder="请输入项目名称" v-model="model.projectName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产业类型：</text></view>
                  <input  placeholder="请输入产业类型" v-model="model.industryType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所在地块：</text></view>
                  <input  placeholder="请输入所在地块" v-model="model.landParcelId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">地块状态：</text></view>
                  <input  placeholder="请输入地块状态" v-model="model.landStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">投资额（万元）：</text></view>
                  <input type="number" placeholder="请输入投资额（万元）" v-model="model.investmentAmount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">联系人：</text></view>
                  <input  placeholder="请输入联系人" v-model="model.contactPerson"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">联系电话：</text></view>
                  <input  placeholder="请输入联系电话" v-model="model.contactPhone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目简介：</text></view>
                  <input  placeholder="请输入项目简介" v-model="model.projectIntro"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目意向：</text></view>
                  <input  placeholder="请输入项目意向" v-model="model.projectIntention"/>
                </view>
              </view>
              <my-date label="预计投产时间：" fields="day" v-model="model.expectedStartDate" placeholder="请输入预计投产时间"></my-date>
              <my-date label="实际投产时间：" fields="day" v-model="model.actualStartDate" placeholder="请输入实际投产时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目状态：</text></view>
                  <input  placeholder="请输入项目状态" v-model="model.projectStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">引资单位：</text></view>
                  <input  placeholder="请输入引资单位" v-model="model.investmentUnit"/>
                </view>
              </view>
				<view class="padding">
					<button class="cu-btn block bg-blue margin-tb-sm lg" @click="onSubmit">
						<text v-if="loading" class="cuIcon-loading2 cuIconfont-spin"></text>提交
					</button>
				</view>
			</form>
		</view>
    </view>
</template>

<script>
    import myDate from '@/components/my-componets/my-date.vue'

    export default {
        name: "InvestmentProjectForm",
        components:{ myDate },
        props:{
          formData:{
              type:Object,
              default:()=>{},
              required:false
          }
        },
        data(){
            return {
				CustomBar: this.CustomBar,
				NavBarColor: this.NavBarColor,
				loading:false,
                model: {},
                backRouteName:'index',
                url: {
                  queryById: "/investment_project/investmentProject/queryById",
                  add: "/investment_project/investmentProject/add",
                  edit: "/investment_project/investmentProject/edit",
                },
            }
        },
        created(){
             this.initFormData();
        },
        methods:{
           initFormData(){
               if(this.formData){
                    let dataId = this.formData.dataId;
                    this.$http.get(this.url.queryById,{params:{id:dataId}}).then((res)=>{
                        if(res.data.success){
                            console.log("表单数据",res);
                            this.model = res.data.result;
                        }
                    })
                }
            },
            onSubmit() {
                let myForm = {...this.model};
                this.loading = true;
                let url = myForm.id?this.url.edit:this.url.add;
				this.$http.post(url,myForm).then(res=>{
				   console.log("res",res)
				   this.loading = false
				   this.$Router.push({name:this.backRouteName})
				}).catch(()=>{
					this.loading = false
				});
            }
        }
    }
</script>
