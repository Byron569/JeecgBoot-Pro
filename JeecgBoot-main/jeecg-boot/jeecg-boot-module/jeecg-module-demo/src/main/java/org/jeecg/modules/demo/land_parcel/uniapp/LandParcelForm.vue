<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">地块信息表</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	地块编号：</text></view>
                  <input  placeholder="请输入	地块编号" v-model="model.parcelCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	地块名称：</text></view>
                  <input  placeholder="请输入	地块名称" v-model="model.parcelName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	所属工业园：</text></view>
                  <input  placeholder="请输入	所属工业园" v-model="model.industrialPark"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	用途：</text></view>
                  <input  placeholder="请输入	用途" v-model="model.landPurpose"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	面积(亩)：</text></view>
                  <input type="number" placeholder="请输入	面积(亩)" v-model="model.landArea"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">建筑面积(㎡)：</text></view>
                  <input type="number" placeholder="请输入建筑面积(㎡)" v-model="model.buildingArea"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	容积率：</text></view>
                  <input type="number" placeholder="请输入	容积率" v-model="model.floorAreaRatio"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">竞得单位：</text></view>
                  <input  placeholder="请输入竞得单位" v-model="model.winningCompany"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">挂牌价格(万元)：</text></view>
                  <input type="number" placeholder="请输入挂牌价格(万元)" v-model="model.listingPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">成交总价(万元)：</text></view>
                  <input type="number" placeholder="请输入成交总价(万元)" v-model="model.transactionPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	地块位置：</text></view>
                  <input  placeholder="请输入	地块位置" v-model="model.location"/>
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
                  <view class="title"><text space="ensp">场地状态：</text></view>
                  <input  placeholder="请输入场地状态" v-model="model.siteStatus"/>
                </view>
              </view>
              <my-date label="成交日期：" fields="day" v-model="model.transactionDate" placeholder="请输入成交日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	楼面价(元/㎡)：</text></view>
                  <input type="number" placeholder="请输入	楼面价(元/㎡)" v-model="model.floorPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">溢价率(%)：</text></view>
                  <input  placeholder="请输入溢价率(%)" v-model="model.premiumRate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">交通配套：</text></view>
                  <input  placeholder="请输入交通配套" v-model="model.transportation"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">教育资源：</text></view>
                  <input  placeholder="请输入教育资源" v-model="model.education"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商业配套：</text></view>
                  <input  placeholder="请输入商业配套" v-model="model.commercial"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">	休闲配套：</text></view>
                  <input  placeholder="请输入	休闲配套" v-model="model.recreation"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">周边楼盘：</text></view>
                  <input  placeholder="请输入周边楼盘" v-model="model.surroundingBuildings"/>
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
        name: "LandParcelForm",
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
                  queryById: "/land_parcel/landParcel/queryById",
                  add: "/land_parcel/landParcel/add",
                  edit: "/land_parcel/landParcel/edit",
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
