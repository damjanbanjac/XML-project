<template>
  <div>
  <b-navbar type="dark" variant="dark">
    <b-navbar-nav>
      <b-nav-item href="/">Home</b-nav-item>

      <!-- Navbar dropdowns -->
      <b-nav-item-dropdown text="Agent" left>
        <router-link to="/newAd" tag="b-dropdown-item">New Ad</router-link>
        <router-link to="/adsListByAgent" tag="b-dropdown-item">AdsList</router-link>
         <router-link to="/makeReport" tag="b-dropdown-item">Make Report</router-link>
        <!--<router-link to="/openedAd" tag="b-dropdown-item">Ad profile</router-link>-->
      </b-nav-item-dropdown>

      <b-nav-item-dropdown text="Admin" left>
        <router-link to="/userList" tag="b-dropdown-item">Users</router-link>
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
      
      </b-nav-item-dropdown>

      <router-link to="/agentRegistration" tag="b-nav-item">Agent registration</router-link>

      <b-nav-item-dropdown text="User" left>
        <router-link to="/adsListByUser" tag="b-dropdown-item">AdsList</router-link>
        <b-dropdown-item href="#">Logout</b-dropdown-item>
      </b-nav-item-dropdown>

    </b-navbar-nav>
  </b-navbar>
</div>
</template>

<script>
export default {

}
</script>

<style>

</style>