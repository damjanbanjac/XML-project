import Vue from 'vue'
import VueRouter from 'vue-router'

import NewAd from '../components/Ad/NewAd.vue'
import OpenedAd from '../components/Ad/OpenedAd.vue'

import AdsList from '../components/Ad/AdsList.vue'

import AgentRegistrationForm from '../components/views/Admin/AgentRegistrationForm.vue'

import AddCarBrand from '../components/views/Admin/add/AddCarBrand.vue'
import AddCarClass from '../components/views/Admin/add/AddCarClass.vue'
import AddCarModel from '../components/views/Admin/add/AddCarModel.vue'
import AddTypeOfFuel from '../components/views/Admin/add/AddTypeOfFuel.vue'
import AddTypeOfGearshift from '../components/views/Admin/add/AddTypeOfGearshift.vue'

import RegistrationRequestList from '../components/views/Admin/lists/RegistrationRequestList.vue'
import UserList from '../components/views/Admin/lists/UserList.vue'
import CarBrandList from '../components/views/Admin/lists/CarBrandList.vue'
import CarClassList from '../components/views/Admin/lists/CarClassList.vue'
import CarModelList from '../components/views/Admin/lists/CarModelList.vue'
import FuelTypeList from '../components/views/Admin/lists/FuelTypeList.vue'
import GearshiftTypeList from '../components/views/Admin/lists/GearshiftTypeList.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/newAd',
        name: 'new-ad',
        component: NewAd
      },
      {
        path: '/adsList',
        name: 'ads-list',
        component: AdsList
      },
      {
        path: '/openedAd/:id',
        name: 'opened-ad',
        component: OpenedAd
      },
      {
        path: '/agentRegistration',
        name: 'agent-registration',
        component: AgentRegistrationForm
      },
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


]

const router = new VueRouter({

    routes

})

export default router