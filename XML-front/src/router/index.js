import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginForm from '../components/LoginForm.vue'
import AgentRegistrationForm from '../components/AgentRegistrationForm.vue'
import ClientRegistrationForm from '../components/ClientRegistrationForm.vue'
import HomePage from '../components/HomePage.vue'
import PriceList from '../components/PriceList.vue'

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
    path: '/homePage',
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