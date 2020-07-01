<template>
  <div id="app">

    <div>

      <nav-bar></nav-bar>
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
import NavBar from "@/components/NavBar.vue";
import VueJwtDecode from "vue-jwt-decode";
export default {
  components: {
    // "login" : LoginForm,
    // "agent-registration" : AgentRegistrationForm,
    // "client-registration" : ClientRegistrationForm
    "nav-bar" : NavBar
  } ,

 

data() {

    return {
    };
  },

   mounted() {
    if (localStorage.getItem("jwt") != undefined) {
      this.$store.state.user = VueJwtDecode.decode(localStorage.getItem("jwt"));
      console.log(localStorage.getItem("jwt"));
    }
  }


}

</script>

<style>

 body {
    background-image: url('https://scontent.fbeg2-1.fna.fbcdn.net/v/t1.15752-9/s2048x2048/100515875_881490369020792_4518760818975703040_n.jpg?_nc_cat=107&_nc_sid=b96e70&_nc_eui2=AeGnhsfbpMDeEEeIz0Yx4K5e_341XRcPUa7_fjVdFw9RrsyTVLUM5NwB3uTLNdD-vs8&_nc_ohc=JqfGBin3MQEAX_eG0NR&_nc_ht=scontent.fbeg2-1.fna&_nc_tp=7&oh=f0f305a21997a2033deb614dad0df1fe&oe=5EF2CF03');
    background-repeat: no-repeat;

    /* background-color: #ECE0BD; */
    
} 

</style>
