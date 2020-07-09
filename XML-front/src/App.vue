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
    background-image: url('https://scontent.fbeg2-1.fna.fbcdn.net/v/t1.15752-9/s2048x2048/107593978_325262128876200_527235236672401728_n.jpg?_nc_cat=104&_nc_sid=b96e70&_nc_eui2=AeHxJrXxJQNLcortDLRD-8kaluMZN0z9w6CW4xk3TP3DoNvbTIXXcWJrFJsXftR7fsY&_nc_ohc=49sZEDIbDE0AX9bXNj7&_nc_ht=scontent.fbeg2-1.fna&_nc_tp=7&oh=38c4b9e5a11a24d8f9fbb990683b32bf&oe=5F2DDFB3');
    background-repeat: no-repeat;

    /* background-color: #ECE0BD; */
    
} 

</style>
