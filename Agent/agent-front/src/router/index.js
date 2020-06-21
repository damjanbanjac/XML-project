import Vue from 'vue'
import VueRouter from 'vue-router'

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


Vue.use(VueRouter)

const routes = [
      {
        path: '/login',
        name: 'login',
        component: Login
      },
      {
        path: '/newAd',
        name: 'new-ad',
        component: NewAd
      },
      {
        path: '/adsListByAgent',
        name: 'ads-list-by-agent',
        component: AdsListByAgent
      },
      {
        path: '/adsListByUser',
        name: 'ads-list-by-user',
        component: AdsListByUser
      },
      {
        path: '/makeReport',
        name: 'make-riport',
        component: MakeReport
      },
      {
        path: '/OpenedAdByAgent/:id',
        name: 'opened-ad-by-agent',
        component: OpenedAdByAgent
      },
      {
        path: '/OpenedAdByUser/:id',
        name: 'opened-ad-by-user',
        component: OpenedAdByUser
      },
      {
        path: '/agentRegistration',
        name: 'agent-registration',
        component: AgentRegistrationForm
      },
      {
        path: '/userRegistrationRequest',
        name: 'user-registration-request',
        component: UserRegistrationRequest
      },
      // lists
      {
        path: '/userList',
        name: 'user-list',
        component: UserList
      },
      {
        path: '/registrationRequests',
        name: 'registration-requests',
        component: RegistrationRequestList
      },
      {
        path: '/carBrandList',
        name: 'car-brand-list',
        component: CarBrandList
      },
      {
        path: '/carClassList',
        name: 'car-class-list',
        component: CarClassList
      },
      {
        path: '/carModelList',
        name: 'car-model-list',
        component: CarModelList
      },
      {
        path: '/fuelTypeList',
        name: 'fuel-type-list',
        component: FuelTypeList
      },
      {
        path: '/gearshiftTypeList',
        name: 'gearshift-type-list',
        component: GearshiftTypeList
      },
      {
        path: '/commentList/:id',
        name: 'comment-list',
        component: CommentList
      },
      {
        path: '/commentRequestList',
        name: 'comment-request-list',
        component: CommentRequestList
      },

      // add
      {
        path: '/addCarBrand',
        name: 'add-car-brand',
        component: AddCarBrand
      },
      {
        path: '/addCarClass',
        name: 'add-car-class',
        component: AddCarClass
      },
      {
        path: '/addCarModel',
        name: 'add-car-model',
        component: AddCarModel
      },
      {
        path: '/addTypeOfFuel',
        name: 'add-type-of-fuel',
        component: AddTypeOfFuel
      },
      {
        path: '/addTypeOfGearshift',
        name: 'add-type-of-gearshift',
        component: AddTypeOfGearshift
      },
      // update
      {
        path: '/updateCarBrand/:id',
        name: 'update-car-brand',
        component: UpdateCarBrand
      },
      {
        path: '/updateCarClass/:id',
        name: 'update-car-class',
        component: UpdateCarClass
      },
      {
        path: '/updateCarModel/:id',
        name: 'update-car-model',
        component: UpdateCarModel
      },
      {
        path: '/updateTypeOfFuel/:id',
        name: 'update-type-of-fuel',
        component: UpdateTypeOfFuel
      },
      {
        path: '/updateTypeOfGearshift/:id',
        name: 'update-type-of-gearshift',
        component: UpdateTypeOfGearshift
      },
]

const router = new VueRouter({

    routes

})

export default router