<template>
  <b-navbar  toggleable="lg" type="light" variant="light">
    <router-link to="/" 
    tag="b-navbar-brand" 
    style="font-size: 1.2rem;
    font-weight: 300;
    line-height: 1.2;">Rent a Car</router-link>

    <div style="border-left:1px solid #000; height:40px; margin-right:1%"></div>

    <b-navbar-nav class="ml-auto" v-if="this.$store.state.user.enabled == true">
      <b-nav-item-dropdown
        text="Pricelist"
        right
       v-if="this.$store.state.user.role.authority == 'USER'"
      >
        <router-link to="/createPriceList" tag="b-dropdown-item">Add pricelist</router-link>
         <div class="dropdown-divider"></div>
        <b-dropdown-item @click="odjavaFun">Log Out</b-dropdown-item>
       
      </b-nav-item-dropdown>
     
    </b-navbar-nav>
  </b-navbar>
</template>

<script>
export default {
 methods: {
    odjavaFun() {
      localStorage.removeItem("jwt");
      this.$store.state.user = {
        role: {
          authority: ''
        }
      };
      this.$router.push("/");
    }
  }
}
</script>

<style>

</style>