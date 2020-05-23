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
    component: LoginForm
  }, 
  {
    path: '/agentRegistration',
    name: 'agent-registration',
    component: AgentRegistrationForm
  },
  {
    path: '/clientRegistration',
    name: 'client-registration',
    component: ClientRegistrationForm
  },
  {
    path: '/homePage',
    name: 'home-page',
    component: HomePage
  },
  {
    path: '/createPriceList',
    name: 'create-price-list',
    component: PriceList
  }
]

const router = new VueRouter({
  
    routes
  
})

export default router