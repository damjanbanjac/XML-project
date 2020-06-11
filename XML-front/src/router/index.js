import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginForm from '../components/LoginForm.vue'
import AgentRegistrationForm from '../components/views/Admin/AgentRegistrationForm.vue'
import ClientRegistrationForm from '../components/ClientRegistrationForm.vue'
import HomePage from '../components/HomePage.vue'
import PriceList from '../components/PriceList.vue'
import UserList from '../components/views/Admin/UserList.vue'
import RegistrationRequestList from '../components/views/Admin/RegistrationRequestList.vue'
import AddCarAd from '../components/views/User/AddCarAd.vue'
import CarBrandList from '../components/views/Admin/CarBrandList.vue'

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
    path: '/addCarAd',
    name: 'add-car-ad',
    component: AddCarAd,
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
    }
  }

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