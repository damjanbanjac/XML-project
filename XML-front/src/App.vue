<template>
  <div id="app">

    <div>

      <home-page></home-page>
      <!-- <login></login> -->
      <!-- <agent-registration></agent-registration> -->
      <!-- <client-registration></client-registration> -->
      
      <router-view />

    </div>

  </div>

</template>

<script>

// import LoginForm from "@/components/LoginForm.vue"
// import AgentRegistrationForm from "@/components/AgentRegistrationForm.vue"
// import ClientRegistrationForm from "@/components/ClientRegistrationForm.vue"
import HomePage from "@/components/HomePage.vue"

export default {
  components: {
    // "login" : LoginForm,
    // "agent-registration" : AgentRegistrationForm,
    // "client-registration" : ClientRegistrationForm
    "home-page" : HomePage
  } ,

data() {

    return {
    };
  },


}

</script>

<style>

body {
    background-image: url('https://scontent.fbeg3-1.fna.fbcdn.net/v/t1.15752-9/s2048x2048/95128562_2496483293999445_6954627335941259264_n.jpg?_nc_cat=110&_nc_sid=b96e70&_nc_eui2=AeHjiGhPQZnFxMvGVnAfpJOwFbohUj9Lh9oVuiFSP0uH2hgx1XgRnwpjRCSxZs8FILg&_nc_ohc=NP0OMrvCMIIAX87brWQ&_nc_ht=scontent.fbeg3-1.fna&_nc_tp=7&oh=143d7cf76e8012b9f082de4cb6719a6f&oe=5EC88FA8');
    background-repeat: no-repeat;
}

</style>
