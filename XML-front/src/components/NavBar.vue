<template>
  <b-navbar  toggleable="lg" type="light" variant="light">
    <router-link to="/" 
    tag="b-navbar-brand" 
    style="font-size: 1.2rem;
    font-weight: 300;
    line-height: 1.2;">Rent a Car</router-link>

    <div style="border-left:1px solid #000; height:40px; margin-right:1%"></div>

    <b-navbar-nav class="ml-auto">
      <b-nav-item-dropdown
        text="Sidebar"
        right
       v-if="this.$store.state.user.role.authority == 'USER'"
      >
        <router-link to="/createPriceList" tag="b-dropdown-item">Add pricelist</router-link>
         <div class="dropdown-divider"></div>
          <router-link to="/carBrandList" tag="b-dropdown-item">Car brands</router-link>
          <router-link to="/addCarBrand" tag="b-dropdown-item">Add car brand</router-link>
        <b-dropdown-item @click="odjavaFun">Log Out</b-dropdown-item>
        
      </b-nav-item-dropdown>

       <b-nav-item-dropdown
        text="Sidebar"
        right
       v-if="this.$store.state.user.role.authority == 'AGENT'"
      >
        <router-link  to="/addCarAd" tag="b-dropdown-item">Add Car</router-link>
                     <router-link to="/adsList" tag="b-dropdown-item">AdsList</router-link>
                       <b-dropdown-item @click="odjavaFun">Log Out</b-dropdown-item>
      </b-nav-item-dropdown>

      <b-nav-item-dropdown  v-if="this.$store.state.user.role.authority == 'ADMIN'" text="Admin maintenance" left>
                    <router-link to="/userList" tag="b-dropdown-item">Users</router-link>
                    <router-link to="/registrationRequests" tag="b-dropdown-item">Registration requests</router-link>

                    <div class="dropdown-divider"></div>
                    
                    <router-link to="/carBrandList" tag="b-dropdown-item">Car brands</router-link>
                    <router-link to="/addCarBrand" tag="b-dropdown-item">Add car brand</router-link>
                    
                    <div class="dropdown-divider"></div>
                    
                    <router-link to="/carClassList" tag="b-dropdown-item">Car classes</router-link>
                    <router-link to="/addCarClass" tag="b-dropdown-item">Add car class</router-link>
                    
                    <div class="dropdown-divider"></div>
                    
                    <router-link to="/carModelList" tag="b-dropdown-item">Car models</router-link>
                    <router-link to="/addCarModel" tag="b-dropdown-item">Add car model</router-link>
                    
                    <div class="dropdown-divider"></div>
                    
                    <router-link to="/fuelTypeList" tag="b-dropdown-item">Types of fuel</router-link>
                    <router-link to="/addTypeOfFuel" tag="b-dropdown-item">Add type of fuel</router-link>
                    
                    <div class="dropdown-divider"></div>
                    
                    <router-link to="/gearshiftTypeList" tag="b-dropdown-item">Types of gearshift</router-link>
                    <router-link to="/addTypeOfGearshift" tag="b-dropdown-item">Add type of gearshift</router-link>
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