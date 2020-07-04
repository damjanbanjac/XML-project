import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginForm from '../components/LoginForm.vue'
import ClientRegistrationForm from '../components/ClientRegistrationForm.vue'
import HomePage from '../components/HomePage.vue'
import PriceList from '../components/views/User/PriceListUser.vue'
import AddCarAd from '../components/views/User/AddCarAd.vue'
import SearchCarAds from '../components/views/User/SearchCarAds.vue'
import Messages from '../components/views/User/Messages.vue'

import UserAdList from '../components/views/User/UserAdList.vue'
import AllAdList from '../components/views/User/AllAdList.vue'
import OpenedAdByAgent from '../components/views/Agent/OpenedAd.vue'
import OpenedAdByUser from '../components/views/User/OpenedAd.vue'
import OpenedMyAdByUser from '../components/views/User/OpenedMyAd.vue'

import NewAd from '../components/views/Agent/NewAd.vue'
import AddPricelist from '../components/views/Agent/AddPricelist.vue'
import AgentAdList from '../components/views/Agent/AgentAdList.vue'
import MakeReport from '../components/views/Agent/MakeReport.vue'

import AgentRegistrationForm from '../components/views/Admin/AgentRegistrationForm.vue'

import AddCarBrand from '../components/views/Admin/add/AddCarBrand.vue'
import AddCarClass from '../components/views/Admin/add/AddCarClass.vue'
import AddCarModel from '../components/views/Admin/add/AddCarModel.vue'
import AddTypeOfFuel from '../components/views/Admin/add/AddTypeOfFuel.vue'
import AddTypeOfGearshift from '../components/views/Admin/add/AddTypeOfGearshift.vue'

import UpdateCarBrand from '../components/views/Admin/update/UpdateCarBrand.vue'
import UpdateCarClass from '../components/views/Admin/update/UpdateCarClass.vue'
import UpdateCarModel from '../components/views/Admin/update/UpdateCarModel.vue'
import UpdateTypeOfFuel from '../components/views/Admin/update/UpdateTypeOfFuel.vue'
import UpdateTypeOfGearshift from '../components/views/Admin/update/UpdateTypeOfGearshift.vue'

import RegistrationRequestList from '../components/views/Admin/lists/RegistrationRequestList.vue'
import UserList from '../components/views/Admin/lists/UserList.vue'
import CarBrandList from '../components/views/Admin/lists/CarBrandList.vue'
import CarClassList from '../components/views/Admin/lists/CarClassList.vue'
import CarModelList from '../components/views/Admin/lists/CarModelList.vue'
import FuelTypeList from '../components/views/Admin/lists/FuelTypeList.vue'
import GearshiftTypeList from '../components/views/Admin/lists/GearshiftTypeList.vue'
import CommentRequestList from '../components/views/Admin/lists/CommentRequestList.vue'
import CommentList from '../components/views/Agent/CommentList.vue'

import AdCarListOrder from '../components/views/Order/AdCarListOrder.vue'
import Bag from '../components/views/Order/Bag.vue'
import AgentRequests from '../components/views/Order/AgentRequests.vue'
import UserRequests from '../components/views/Order/UserRequests.vue'
import ReservePayGo from '../components/views/Order/ReservePayGo.vue'

Vue.use(VueRouter);

const routes = [
  {
    path: '/login',
    name: 'login',
    component: LoginForm,
    meta: {
      requiresAuth: true
    } 
  }, 
  {
    path: '/agentRegistration',
    name: 'agent-registration',
    component: AgentRegistrationForm,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/clientRegistration',
    name: 'client-registration',
    component: ClientRegistrationForm,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/',
    name: 'home-page',
    component: HomePage,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/createPriceList',
    name: 'create-price-list',
    component: PriceList,
    meta: {
      requiresAuth: false
    } 
  },
  {
    path: '/addCarAd',
    name: 'add-car-ad',
    component: AddCarAd,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/newAd',
    name: 'new-ad',
    component: NewAd,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/addPricelist',
    name: 'add-pricelist',
    component: AddPricelist,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/agentAdList',
    name: 'agent-ad-list',
    component: AgentAdList,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/makeReport',
    name: 'make-report',
    component: MakeReport,
    meta: {
      requiresAuth: true
    } 
  },
  // lists
  {
    path: '/userList',
    name: 'user-list',
    component: UserList,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/registrationRequests',
    name: 'registration-requests',
    component: RegistrationRequestList,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/carBrandList',
    name: 'car-brand-list',
    component: CarBrandList,
    meta: {
      requiresAuth: true
    },
  },
  {
    path: '/searchCarAds',
    name: 'search-car-ads',
    component: SearchCarAds,
    meta: {
      requiresAuth: true
    }
     
  },
  {
    path: '/userAdList',
    name: 'user-ad-list',
    component: UserAdList,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/allAdList',
    name: 'all-ad-list',
    component: AllAdList,
    meta: {
      requiresAuth: true
    } 
  },
  {
    path: '/openedAdByAgent/:id',
    name: 'opened-ad-by-agent',
    component: OpenedAdByAgent,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/openedAdByUser/:id',
    name: 'opened-ad-by-user',
    component: OpenedAdByUser,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/openedMyAdByUser/:id',
    name: 'opened-my-ad-by-user',
    component: OpenedMyAdByUser,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/carClassList',
    name: 'car-class-list',
    component: CarClassList,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/carModelList',
    name: 'car-model-list',
    component: CarModelList,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/fuelTypeList',
    name: 'fuel-type-list',
    component: FuelTypeList,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/gearshiftTypeList',
    name: 'gearshift-type-list',
    component: GearshiftTypeList,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/commentRequestList',
    name: 'comment-request-list',
    component: CommentRequestList,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/commentList/:id',
    name: 'comment-list',
    component: CommentList,
    meta: {
      requiresAuth: true
    }
  },
  // add
  {
    path: '/addCarBrand',
    name: 'add-car-brand',
    component: AddCarBrand,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/addCarClass',
    name: 'add-car-class',
    component: AddCarClass,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/addCarModel',
    name: 'add-car-model',
    component: AddCarModel,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/addTypeOfFuel',
    name: 'add-type-of-fuel',
    component: AddTypeOfFuel,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/addTypeOfGearshift',
    name: 'add-type-of-gearshift',
    component: AddTypeOfGearshift,
    meta: {
      requiresAuth: true
    }
  },
  // update
  {
    path: '/updateCarBrand/:id',
    name: 'update-car-brand',
    component: UpdateCarBrand,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/updateCarClass/:id',
    name: 'update-car-class',
    component: UpdateCarClass,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/updateCarModel/:id',
    name: 'update-car-model',
    component: UpdateCarModel,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/updateTypeOfFuel/:id',
    name: 'update-type-of-fuel',
    component: UpdateTypeOfFuel,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/messages',
    name: 'messages',
    component: Messages,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/updateTypeOfGearshift/:id',
    name: 'update-type-of-gearshift',
    component: UpdateTypeOfGearshift,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/adCarListOrder',
    name: 'ad-car-list-order',
    component: AdCarListOrder,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/bag',
    name: 'bag',
    component: Bag,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/agentRequests',
    name: 'agent-requests',
    component: AgentRequests,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/userRequests',
    name: 'user-requests',
    component: UserRequests,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/reservePayGo',
    name: 'reserve-pay-go',
    component: ReservePayGo,
    meta: {
      requiresAuth: true
    }
  },

]

const router = new VueRouter({
  
    routes
  
})

router.beforeEach((to, from, next) => {

  if (to.meta.requiresAuth) {
    next();
    return;
  }
  
  if(localStorage.getItem('jwt'))
  {
    next();
    return;
  }
   
  next("/")
  
})

export default router