import Vue from 'vue'
import App from './App.vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import router from './router'
import store from './store'
import axios from "axios";

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

axios.defaults.baseURL = "http://localhost:8083"

axios.interceptors.request.use(config => {
  config.headers['Authorization'] = "Bearer " + localStorage.getItem("jwt");
  return config;
})

Vue.config.productionTip = false

Vue.use(BootstrapVue);
Vue.use(IconsPlugin)

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
