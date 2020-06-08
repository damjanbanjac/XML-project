import Vue from 'vue'
import VueRouter from 'vue-router'
import NewAd from '../components/Ad/NewAd.vue'
import OpenedAd from '../components/Ad/OpenedAd.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/newAd',
        name: 'new-ad',
        component: NewAd
      },
      {
        path: '/openedAd',
        name: 'opened-ad',
        component: OpenedAd
      }

]

const router = new VueRouter({

    routes

})

export default router