<template>
  <b-navbar  toggleable="lg" type="light" variant="light">
    <router-link to="/" 
    tag="b-navbar-brand" 
    style="font-size: 1.2rem;
    font-weight: 300;
    line-height: 1.2;">Rent A Car</router-link>

    <div style="border-left:1px solid #000; height:40px; margin-right:1%"></div>

    <b-navbar-nav>
      <router-link to="/login" tag="b-nav-item" v-if="this.$store.state.user.role.authority == ''" left>Log in</router-link>
      <b-nav-item-dropdown
        text="Sidebar"
        left
       v-if="this.$store.state.user.role.authority == 'USER'"
      >
        <router-link to="/messages" tag="b-dropdown-item">Messages</router-link>
        <div class="dropdown-divider"></div>
        <router-link to="/bag" tag="b-dropdown-item">Bag</router-link>
        <router-link to="/searchCarAds" tag="b-dropdown-item">Search cars</router-link>
        <!-- <router-link to="/adCarListOrder" tag="b-dropdown-item">Car ads</router-link> -->
        <router-link to="/allAdList" tag="b-dropdown-item">All car ads</router-link>
        <div class="dropdown-divider"></div>
        <router-link to="/userRequests" tag="b-dropdown-item">My requests</router-link>
        <router-link to="/userAdList" tag="b-dropdown-item">My car ads</router-link>
        <div class="dropdown-divider"></div>
        <router-link  to="/addCarAd" tag="b-dropdown-item">Add car ad</router-link>
        <router-link to="/createPriceList" tag="b-dropdown-item">Add pricelist</router-link>
        <div class="dropdown-divider"></div>
         <router-link to="/makeReportUser" tag="b-dropdown-item">Issue Report</router-link>
          <div class="dropdown-divider"></div>
        <b-dropdown-item @click="odjavaFun">Log Out</b-dropdown-item>
        
      </b-nav-item-dropdown>

       <b-nav-item-dropdown
        text="Sidebar"
        left
       v-if="this.$store.state.user.role.authority == 'AGENT'"
      >
        <router-link to="/agentRequests" tag="b-dropdown-item">Owner requests</router-link>
        <router-link to="/reservePayGo" tag="b-dropdown-item">Reserve-Pay-Go</router-link>
        <div class="dropdown-divider"></div>
        <router-link to="/agentAdList" tag="b-dropdown-item">My car ads</router-link>
        <router-link  to="/newAd" tag="b-dropdown-item">Add car ad</router-link>
        <router-link  to="/addPricelist" tag="b-dropdown-item">Add pricelist</router-link>
        <div class="dropdown-divider"></div>
        <router-link to="/makeReport" tag="b-dropdown-item">Issue Report</router-link>

        <div class="dropdown-divider"></div>

        <b-dropdown-item @click="odjavaFun">Log Out</b-dropdown-item>

        </b-nav-item-dropdown>

      <b-nav-item-dropdown left v-if="this.$store.state.user.role.authority == 'ADMIN'" text="Sidebar">

                    <router-link to="/agentRegistration" tag="b-dropdown-item">Agent registration</router-link>
                    <router-link to="/registrationRequests" tag="b-dropdown-item">Registration requests</router-link>
                    <router-link to="/userList" tag="b-dropdown-item">Client profiles</router-link>

                    <div class="dropdown-divider"></div>

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