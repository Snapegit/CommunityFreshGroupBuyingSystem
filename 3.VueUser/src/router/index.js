import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import tuanzhangList from '@/views/pages/tuanzhang/list'
import tuanzhangDetail from '@/views/pages/tuanzhang/formModel'
import tuanzhangAdd from '@/views/pages/tuanzhang/formAdd'
import shangpinfenleiList from '@/views/pages/shangpinfenlei/list'
import shangpinfenleiDetail from '@/views/pages/shangpinfenlei/formModel'
import shangpinfenleiAdd from '@/views/pages/shangpinfenlei/formAdd'
import shangpinxinxiList from '@/views/pages/shangpinxinxi/list'
import shangpinxinxiDetail from '@/views/pages/shangpinxinxi/formModel'
import shangpinxinxiAdd from '@/views/pages/shangpinxinxi/formAdd'
import storeupList from '@/views/pages/storeup/list'
import cartList from '@/views/pages/shop_order/cart'
import newsList from '@/views/pages/news/list'
import zitidianshenqingList from '@/views/pages/zitidianshenqing/list'
import zitidianshenqingDetail from '@/views/pages/zitidianshenqing/formModel'
import zitidianshenqingAdd from '@/views/pages/zitidianshenqing/formAdd'
import jiehuoxinxiList from '@/views/pages/jiehuoxinxi/list'
import jiehuoxinxiDetail from '@/views/pages/jiehuoxinxi/formModel'
import jiehuoxinxiAdd from '@/views/pages/jiehuoxinxi/formAdd'
import quhuoxinxiList from '@/views/pages/quhuoxinxi/list'
import quhuoxinxiDetail from '@/views/pages/quhuoxinxi/formModel'
import quhuoxinxiAdd from '@/views/pages/quhuoxinxi/formAdd'
import order_confirm from '@/views/pages/shop_order/confirm'
import ordersList from '@/views/pages/shop_order/list'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'tuanzhangList',
			component: tuanzhangList
		}, {
			path: 'tuanzhangDetail',
			component: tuanzhangDetail
		}, {
			path: 'tuanzhangAdd',
			component: tuanzhangAdd
		}
		, {
			path: 'shangpinfenleiList',
			component: shangpinfenleiList
		}, {
			path: 'shangpinfenleiDetail',
			component: shangpinfenleiDetail
		}, {
			path: 'shangpinfenleiAdd',
			component: shangpinfenleiAdd
		}
		, {
			path: 'shangpinxinxiList',
			component: shangpinxinxiList
		}, {
			path: 'shangpinxinxiDetail',
			component: shangpinxinxiDetail
		}, {
			path: 'shangpinxinxiAdd',
			component: shangpinxinxiAdd
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		, {
			path: 'cartList',
			component: cartList
		}
		, {
			path: 'newsList',
			component: newsList
		}
		, {
			path: 'zitidianshenqingList',
			component: zitidianshenqingList
		}, {
			path: 'zitidianshenqingDetail',
			component: zitidianshenqingDetail
		}, {
			path: 'zitidianshenqingAdd',
			component: zitidianshenqingAdd
		}
		, {
			path: 'jiehuoxinxiList',
			component: jiehuoxinxiList
		}, {
			path: 'jiehuoxinxiDetail',
			component: jiehuoxinxiDetail
		}, {
			path: 'jiehuoxinxiAdd',
			component: jiehuoxinxiAdd
		}
		, {
			path: 'quhuoxinxiList',
			component: quhuoxinxiList
		}, {
			path: 'quhuoxinxiDetail',
			component: quhuoxinxiDetail
		}, {
			path: 'quhuoxinxiAdd',
			component: quhuoxinxiAdd
		}
		, {
			path: 'order_confirm',
			component: order_confirm
		}
		, {
			path: 'ordersList',
			component: ordersList
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
