<template>
  <div>
  <b-navbar type="dark" variant="dark">
    <router-link to="/" 
    tag="b-navbar-brand" 
    style="font-size: 1.2rem;
    font-weight: 300;
    line-height: 1.2;
    color: #6c757d">Rent A Car</router-link>

    <div style="border-left:1px solid #6c757d; height:40px; margin-right:1%"></div>

    <b-navbar-nav>

      <!-- Navbar dropdowns -->

      <!-- Login/Reg -->
      <router-link to="/login" v-if="this.$store.state.user.role.authority == ''" tag="b-nav-item">Login</router-link>
      <!-- <router-link to="/userRegistrationRequest" v-if="this.$store.state.user.role.authority == ''" tag="b-nav-item">Client registration</router-link> -->

      <!-- Agent -->
      <b-nav-item-dropdown v-if="this.$store.state.user.role.authority == 'AGENT'" text="Sidebar" left>
        <router-link to="/adsListByAgent" tag="b-dropdown-item">Car ads</router-link>
        <router-link to="/newAd" tag="b-dropdown-item">Add Car</router-link>
        <div class="dropdown-divider"></div>
        <router-link to="/makeReport" tag="b-dropdown-item">Issue Report</router-link>
        <div class="dropdown-divider"></div>
        <b-dropdown-item @click="odjavaFun">Log Out</b-dropdown-item>
      </b-nav-item-dropdown>

      <!-- Admin -->
      <b-nav-item-dropdown  v-if="this.$store.state.user.role.authority == 'ADMIN'" text="Sidebar" left>

        <router-link to="/userList" tag="b-dropdown-item">Client profiles</router-link>

        <div class="dropdown-divider"></div>
        
        <router-link to="/registrationRequests" tag="b-dropdown-item">Registration requests</router-link>
        <router-link to="/commentRequestList" tag="b-dropdown-item">Comment requests</router-link>
        
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

        <div class="dropdown-divider"></div>
      
        <b-dropdown-item @click="odjavaFun">Log Out</b-dropdown-item>

      </b-nav-item-dropdown>

      <!-- User -->
      <b-nav-item-dropdown text="Sidebar"   v-if="this.$store.state.user.role.authority == 'USER'" left>
        <router-link to="/adsListByUser" tag="b-dropdown-item">Car ads</router-link>
        <router-link to="/newAd" tag="b-dropdown-item">Add Car</router-link>
        <div class="dropdown-divider"></div>
         <b-dropdown-item @click="odjavaFun">Log Out</b-dropdown-item>
      </b-nav-item-dropdown>
     
    </b-navbar-nav>
  </b-navbar>
</div>
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