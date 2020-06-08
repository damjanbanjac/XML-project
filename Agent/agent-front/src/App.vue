<template>
  <div id="app">
    <navbar></navbar>

   <router-view />
  </div>
</template>

<script>
import Navbar from  './components/Navbar.vue'


export default {
  name: 'App',
  components: {
 
    "navbar" : Navbar
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
    background-image: url('https://scontent.fbeg2-1.fna.fbcdn.net/v/t1.15752-9/s2048x2048/100515875_881490369020792_4518760818975703040_n.jpg?_nc_cat=107&_nc_sid=b96e70&_nc_eui2=AeGnhsfbpMDeEEeIz0Yx4K5e_341XRcPUa7_fjVdFw9RrsyTVLUM5NwB3uTLNdD-vs8&_nc_ohc=JqfGBin3MQEAX_eG0NR&_nc_ht=scontent.fbeg2-1.fna&_nc_tp=7&oh=f0f305a21997a2033deb614dad0df1fe&oe=5EF2CF03');
    background-repeat: no-repeat;
}
</style>
