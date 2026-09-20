<template>
	<div class="app-contain" :style='{"width":"1200px","padding":"0px 0px 20px","margin":"0px auto 40px","position":"relative","borderRadius":"0px","background":"none"}'>
		<div class="section_title">
			{{formName}}
		</div>
		<el-card>
			<el-divider content-position="left">商品清单</el-divider>
			<el-table :data="list" :stripe='false'>
				<el-table-column label="商品名称" :resizable='true' align="left" header-align="left">
					<template #default="scope">
						{{scope.row.goodname}}
					</template>
				</el-table-column>
				<el-table-column label="商品图片" :resizable='true' align="left" header-align="left">
					<template #default="scope">
						<img :src="scope.row.picture?($config.url + scope.row.picture):''" alt=""
							style="width: 150px;height: 150px;">
					</template>
				</el-table-column>
				<el-table-column label="价格" :resizable='true' align="left" header-align="left">
					<template #default="scope">
						<span style="font-size: 12px;" >￥</span>{{scope.row.price}} 					</template>
				</el-table-column>
				<el-table-column label="数量" :resizable='true' align="left" header-align="left">
					<template #default="scope">{{scope.row.buynumber}}
					</template>
				</el-table-column>
				<el-table-column label="总价" :resizable='true' align="left" header-align="left">
					<template #default="scope">
						<span style="font-size: 12px;" >￥</span>{{(scope.row.price * scope.row.buynumber).toFixed(2)}} 					</template>
				</el-table-column>
			</el-table>
			<el-divider content-position="left">备注</el-divider>
			
			<el-input v-model="remark" placeholder="请输入备注" type="textarea"></el-input>
			<div class="order_confirm_btn" >
				<div class="order_confirm_price">
					总价：<span >￥</span>{{allPrice()}} 				</div>
				<el-button class="pay_btn"  @click="payClick" type="success">余额支付</el-button>
			</div>
		</el-card>
		<br>
	</div>
</template>

<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const router = useRouter()
	const route = useRoute()
	//基础信息
	const tableName = 'orders'
	const formName = '订单提交'
	//基础信息
	const list = ref(null)
	const remark = ref('')
	//统计总价
	const allPrice = () => {
		let price = 0
		for (let x in list.value) {
			price += Number((list.value[x].price * list.value[x].buynumber).toFixed(2))
		}
		return Number(price)
	}
	//获取订单id
	const createOrder = () => {
		let order = '';
		let now = new Date();
		order += now.getFullYear();
		order += now.getMonth() + 1;
		order += now.getDate();
		order += now.getHours();
		order += now.getMinutes();
		order += now.getSeconds();
		order += now.getMilliseconds();

		return order;
	}
	//正常支付
	const payClick = () => {
		list.value.forEach(item => {
			context?.$http({
				url: `${item.tablename}/info/${item.goodid}`,
				method: 'get'
			}).then(res => {
				var orderId = createOrder()
				var data = res.data.data
				//添加订单
				let order = {
					orderid: orderId,
					tablename: item.tablename,
					userid: userinfo.value.id,
					goodid: item.goodid,
					goodname: item.goodname,
                    tuanzhangzhanghao: item.tuanzhangzhanghao,
                    goodtype: item.goodtype,
					picture: item.picture,
					buynumber: item.buynumber,
					discountprice: item.price,
					discounttotal: (item.price * item.buynumber).toFixed(2),
					price: item.price,
					total: (item.price * item.buynumber).toFixed(2),
					type: payType.value,
					remark: remark.value,
					status: '未支付'
				}
				//新增订单
				context.$http({
					url: 'orders/add',
					method: 'post',
					data: order
				}).then(obj1 => {
					//判断用户余额是否充足
					if(Number(userinfo.value.money) < Number(item.price * item.buynumber)){
						context?.$toolUtil.message(`余额不足以支付${item.goodname}，请充值后前往订单页面完成支付`,'error',()=>{
							router.push(`/index/${context?.$toolUtil.storageGet('frontSessionTable')}Center`)
						})
						return false
					}
					//减去用户余额
					userinfo.value.money = (parseFloat(userinfo.value.money) - parseFloat(item.price * item.buynumber)).toFixed(2)
					context?.$http({
						url: `${context?.$toolUtil.storageGet('frontSessionTable')}/update`,
						method:'post',
						data: userinfo.value
					}).then(obj2=>{})
					//如果商品有库存 减去商品库存
					if (data.hasOwnProperty('alllimittimes')) {
						data.alllimittimes = data.alllimittimes - item.buynumber
					}
					context?.$http({
						url: `${item.tablename}/update`,
						method: 'post',
						data: data
					}).then(obj => {})
					//余额减去，即支付完成 修改订单支付状态
					context?.$http({
						url: 'orders/list',
						method:'get',
						params:{
							page:1,
							limit:1,
							orderid: orderId
						}
					}).then(obj3=>{
						obj3.data.data.list[0].status = '已支付'
						
						context?.$http({
							url: 'orders/update',
							method: 'post',
							data: obj3.data.data.list[0]
						}).then(obj4=>{
							//如果存在item.id。说明从购物车跳转。否则从商品详情立即购买
							if(item.id){
								context?.$http({url:'cart/delete',method:'post',data:[item.id]}).then(res1=>{})
							}
							//下单完成，跳转订单
							context?.$toolUtil.message('购买成功','success',()=>{
								router.push('/index/ordersList')
							})
						})
					})
				})
			})
		})
	}
	//付款类型
	const payType = ref(1)
	//获取个人信息
	const userinfo = ref({})
	const getUserInfo = () => {
		context?.$http({
			url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
			method: 'get'
		}).then(res => {
			userinfo.value = res.data.data
		})
	}
	//初始化
	const init = () => {
		list.value = JSON.parse(context?.$toolUtil.storageGet('orders_good'))
		if (route.query.type) {
			payType.value = route.query.type
		}
		getUserInfo()
	}
	init()
</script>

<style lang="scss" scoped>
	// 表格样式
	.el-table {
		padding: 0;
		margin: 30px auto 0;
		background: #fff;
		width: calc(100% - 40px);
		border-color: #eee;
		border-width: 1px 0 0 1px;
		border-style: solid;
		:deep(.el-table__header-wrapper) {
			thead {
				color: #999;
				font-weight: 500;
				width: 100%;
				tr {
					background: #fcfcfc;
					th {
						padding: 12px 0;
						background: none;
						border-color: #eee;
						border-width: 0 0px 1px 0;
						border-style: solid;
						text-align: left;
						.cell {
							padding: 0 10px;
							word-wrap: normal;
							color: #333;
							word-break: break-all;
							white-space: normal;
							font-weight: bold;
							display: inline-block;
							vertical-align: middle;
							width: 100%;
							line-height: 24px;
							position: relative;
							text-overflow: ellipsis;
						}
					}
				}
			}
		}
		:deep(.el-table__body-wrapper) {
			tbody {
				width: 100%;
				tr {
					background: #fff;
					td {
						padding: 12px 0;
						color: #999;
						background: #fff;
						border-color: #eee;
						border-width: 0 0px 1px 0;
						border-style: solid;
						text-align: left;
						.cell {
							padding: 0 10px;
							overflow: hidden;
							word-break: break-all;
							white-space: normal;
							line-height: 24px;
							text-overflow: ellipsis;
						}
					}
				}
				tr:hover {
					td {
						padding: 12px 0;
						color: #333;
						background: #fcfcfc;
						border-color: #eee;
						border-width: 0 0px 1px 0;
						border-style: solid;
						text-align: left;
					}
				}
			}
		}
	}
	// 分割线样式
	:deep(.el-divider) {
		border: none;
		margin: 40px auto 0;
		background: #ddd;
		width: calc(100% - 40px);
		line-height: 30px;
		// 分割线文字样式
		.el-divider__text {
			border: 1px solid #ddd;
			color: #333;
			font-size: 16px;
		}
	}
	// 底部盒子
	.order_confirm_btn {
		border: 0px solid #ddd;
		padding: 20px;
		margin: 10px auto;
		background: none;
		display: flex;
		width: calc(100% - 40px);
		justify-content: center;
		align-items: center;
		box-sizing: border-box;
		// 总价
		.order_confirm_price {
			margin: 0 20px 0 0;
			color: #f00;
			font-weight: bold;
			font-size: 18px;
		}
		// 余额支付
		.pay_btn {
			border: 0px solid #27bacc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 20px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #499ac9;
			width: auto;
			font-size: 14px;
			height: 36px;
		}
		// 余额支付-悬浮
		.pay_btn:hover {
		}
	}
</style>