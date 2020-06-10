import Vue from 'vue'
import VueRouter from 'vue-router'
import NewAd from '../components/Ad/NewAd.vue'
import OpenedAd from '../components/Ad/OpenedAd.vue'
import AgentRegistrationForm from '../components/views/Admin/AgentRegistrationForm.vue'
import RegistrationRequestList from '../components/views/Admin/RegistrationRequestList.vue'
import UserList from '../components/views/Admin/UserList.vue'
import AdsList from '../components/Ad/AdsList.vue'

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

]

const router = new VueRouter({

    routes

})

export default router