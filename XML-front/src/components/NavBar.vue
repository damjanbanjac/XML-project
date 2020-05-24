<template>
  <b-navbar  toggleable="lg" type="light" variant="light">
    <router-link to="/" tag="b-navbar-brand">Rent a Car</router-link>

    <b-navbar-nav class="ml-auto" v-if="this.$store.state.user.enabled == true">
      <b-nav-item-dropdown
        text="PriceList"
        right
       v-if="this.$store.state.user.role.authority == 'USER'"
      >
        <router-link to="/createPriceList" tag="b-dropdown-item">Add price list</router-link>
         <div class="dropdown-divider"></div>
        <b-dropdown-item @click="odjavaFun">Odjava</b-dropdown-item>
       
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