<template>
  <div id="app">
    <navbar></navbar>
    <router-view />

  </div>
</template>

<script>
import Home from  './components/Navbar.vue'

import VueJwtDecode from "vue-jwt-decode";
export default {
  name: 'App',
  components: {
 
    "navbar" : Home
  },
   mounted() {
    if (localStorage.getItem("jwt") != undefined) {
      this.$store.state.user = VueJwtDecode.decode(localStorage.getItem("jwt"));
    }
  }
}
</script>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body {
    background-image: url('https://scontent.fbeg2-1.fna.fbcdn.net/v/t1.15752-9/103881952_261397135081687_2774286197962572060_n.jpg?_nc_cat=104&_nc_sid=b96e70&_nc_eui2=AeG0zS1zc4uQEvkVZHt6qEFHSnw4ORzmjRRKfDg5HOaNFP7U6NSHG0qKynEQNMVwlys&_nc_ohc=MkenpKOVPxUAX_VZL9f&_nc_ht=scontent.fbeg2-1.fna&oh=a7f1c0b6b1fd6bebc753a19f62cdf8c8&oe=5F2FE707');
    background-repeat: no-repeat;
}
</style>
