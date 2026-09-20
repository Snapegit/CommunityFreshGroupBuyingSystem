	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import news from '@/views/news/list'
	import shangpinxinxi from '@/views/shangpinxinxi/list'
	import jiehuoxinxi from '@/views/jiehuoxinxi/list'
	import quhuoxinxi from '@/views/quhuoxinxi/list'
	import storeup from '@/views/storeup/list'
	import users from '@/views/users/list'
	import yonghu from '@/views/yonghu/list'
	import shangpinfenlei from '@/views/shangpinfenlei/list'
	import discussshangpinxinxi from '@/views/discussshangpinxinxi/list'
	import orders from '@/views/orders/list'
	import tuanzhang from '@/views/tuanzhang/list'
	import zitidianshenqing from '@/views/zitidianshenqing/list'
	import config from '@/views/config/list'
	import tuanzhangRegister from '@/views/tuanzhang/register'
	import tuanzhangCenter from '@/views/tuanzhang/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页Home',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/tuanzhangCenter',
			name: '团长个人中心',
			component: tuanzhangCenter
		}
		,{
			path: '/news',
			name: '商品资讯',
			component: news
		}
		,{
			path: '/shangpinxinxi',
			name: '商品信息',
			component: shangpinxinxi
		}
		,{
			path: '/jiehuoxinxi',
			name: '接货信息',
			component: jiehuoxinxi
		}
		,{
			path: '/quhuoxinxi',
			name: '取货信息',
			component: quhuoxinxi
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/shangpinfenlei',
			name: '商品分类',
			component: shangpinfenlei
		}
		,{
			path: '/discussshangpinxinxi',
			name: '商品信息评论',
			component: discussshangpinxinxi
		}
		,{
			path: '/orders',
			name: '订单管理',
			component: orders
		}
		,{
			path: '/tuanzhang',
			name: '团长',
			component: tuanzhang
		}
		,{
			path: '/zitidianshenqing',
			name: '自提点申请',
			component: zitidianshenqing
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		]
	},
	{
		path: '/tuanzhangRegister',
		name: '团长注册',
		component: tuanzhangRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
