import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../components/HomePage.vue'
import NewAd from '../components/Agent/Ad/NewAd.vue'
import OpenedAdByAgent from '../components/Agent/Ad/OpenedAd.vue'

import OpenedAdByUser from '../components/views/User/OpenedAd.vue'

import MakeReport from '../components/Agent/Ad/MakeReport.vue'

import AdsListByAgent from '../components/Agent/Ad/AdsList.vue'
import AdsListByUser from '../components/views/User/AdsList.vue'

import Login from '../components/Login.vue'
import AgentRegistrationForm from '../components/views/Admin/AgentRegistrationForm.vue'
import UserRegistrationRequest from '../components/views/User/UserRegistrationRequest.vue'

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
import CommentList from '../components/Agent/Ad/CommentList.vue'
import CommentRequestList from '../components/views/Admin/lists/CommentRequestList.vue'

import Bag from '../components/views/User/Bag.vue'
import UserRequests from '../components/views/User/UserRequests.vue'

import AgentRequests from '../components/Agent/AgentRequests.vue'
import ReservePayGo from '../components/Agent/ReservePayGo.vue'

Vue.use(VueRouter)

const routes = [
      {
        path: '/login',
        name: 'login',
        component: Login,
        meta: {
          requiresAuth: true
        } 

      },
      {
        path: '/newAd',
        name: 'new-ad',
        component: NewAd,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/adsListByAgent',
        name: 'ads-list-by-agent',
        component: AdsListByAgent,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/adsListByUser',
        name: 'ads-list-by-user',
        component: AdsListByUser,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/makeReport',
        name: 'make-riport',
        component: MakeReport,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/openedAdByAgent/:id',
        name: 'opened-ad-by-agent',
        component: OpenedAdByAgent,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/openedAdByUser/:id',
        name: 'opened-ad-by-user',
        component: OpenedAdByUser,
        meta: {
          requiresAuth: false
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
        path: '/userRegistrationRequest',
        name: 'user-registration-request',
        component: UserRegistrationRequest,
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
          requiresAuth: false
        } 
      },
      {
        path: '/registrationRequests',
        name: 'registration-requests',
        component: RegistrationRequestList,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/carBrandList',
        name: 'car-brand-list',
        component: CarBrandList,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/carClassList',
        name: 'car-class-list',
        component: CarClassList,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/carModelList',
        name: 'car-model-list',
        component: CarModelList,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/fuelTypeList',
        name: 'fuel-type-list',
        component: FuelTypeList,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/gearshiftTypeList',
        name: 'gearshift-type-list',
        component: GearshiftTypeList,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/commentList/:id',
        name: 'comment-list',
        component: CommentList,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/commentRequestList',
        name: 'comment-request-list',
        component: CommentRequestList,
        meta: {
          requiresAuth: false
        } 
      },

      // add
      {
        path: '/addCarBrand',
        name: 'add-car-brand',
        component: AddCarBrand,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/addCarClass',
        name: 'add-car-class',
        component: AddCarClass,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/addCarModel',
        name: 'add-car-model',
        component: AddCarModel,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/addTypeOfFuel',
        name: 'add-type-of-fuel',
        component: AddTypeOfFuel,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/addTypeOfGearshift',
        name: 'add-type-of-gearshift',
        component: AddTypeOfGearshift,
        meta: {
          requiresAuth: false
        } 
      },
      // update
      {
        path: '/updateCarBrand/:id',
        name: 'update-car-brand',
        component: UpdateCarBrand,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/updateCarClass/:id',
        name: 'update-car-class',
        component: UpdateCarClass,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/updateCarModel/:id',
        name: 'update-car-model',
        component: UpdateCarModel,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/updateTypeOfFuel/:id',
        name: 'update-type-of-fuel',
        component: UpdateTypeOfFuel,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/',
        name: 'home',
        component: Home,
        meta: {
          requiresAuth: true
        } 
      },
      {
        path: '/updateTypeOfGearshift/:id',
        name: 'update-type-of-gearshift',
        component: UpdateTypeOfGearshift,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/bag',
        name: 'bag',
        component: Bag,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/userRequests',
        name: 'user-requests',
        component: UserRequests,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/agentRequests',
        name: 'agent-requests',
        component: AgentRequests,
        meta: {
          requiresAuth: false
        } 
      },
      {
        path: '/reservePayGo',
        name: 'reserve-pay-go',
        component: ReservePayGo,
        meta: {
          requiresAuth: false
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