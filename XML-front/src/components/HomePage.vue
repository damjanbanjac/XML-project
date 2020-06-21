<template>
    <div>
        
        <b-navbar v-if="this.$store.state.user.role.authority == ''"  toggleable="lg" variant="light" >
             <b-navbar-brand
             style="font-size: 1.2rem;
             font-weight: 300;
             line-height: 1.2;"
             >Welcome</b-navbar-brand>
             
            <div style="border-left:1px solid #000; height:40px; margin-right:1%"></div>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
            
            <router-link to="/login" tag="b-nav-item">Log in</router-link>
                <b-nav-item-dropdown
                    id="my-nav-dropdown"
                    text="User"
                    toggle-class="nav-link-custom"
                    right
                    >
                    <router-link  to="/addCarAd" tag="b-dropdown-item">Add Car</router-link>
                    <router-link to="/searchCarAds" tag="b-dropdown-item">Search cars</router-link>
                    <router-link to="/messages" tag="b-dropdown-item">Messages</router-link>

                     <router-link to="/adsList" tag="b-dropdown-item">Ads List</router-link>
                     
                </b-nav-item-dropdown>
                 <b-nav-item-dropdown
                    id="my-nav-dropdown"
                    text="Agent"
                    toggle-class="nav-link-custom"
                    right
                    >
                    <router-link  to="/newAd" tag="b-dropdown-item">Add Car</router-link>
                    <router-link  to="/agentAdList" tag="b-dropdown-item">Ad List</router-link>
                     <router-link to="/makeReport" tag="b-dropdown-item">Make Report</router-link>
                    
                </b-nav-item-dropdown>
                <b-nav-item-dropdown text="Admin maintenance" left>
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
                
                </b-nav-item-dropdown>


                <b-nav-item-dropdown text="Ordering" left>
                    <router-link to="/adCarListOrder" tag="b-dropdown-item">Ads</router-link>
                    <router-link to="/bag" tag="b-dropdown-item">User bag</router-link>
                    <router-link to="/agentRequests" tag="b-dropdown-item">Owner requests</router-link>
                    <router-link to="/userRequests" tag="b-dropdown-item">User requests</router-link>
                    <router-link to="/reservePayGo" tag="b-dropdown-item">Reserve-Pay-Go</router-link>
                </b-nav-item-dropdown>

                <!--<router-link to="/agentRegistration" tag="b-nav-item">Agent registration</router-link>-->

                <router-link to="/clientRegistration" tag="b-nav-item">Client registration</router-link>

            
        </b-navbar-nav>
        </b-collapse>
        </b-navbar>
    </div>
    
</template>

<script>
export default {
    
}
</script>

<style>

header {
    background: whitesmoke;
    
}

.tabs {
    height: 60px;
    line-height: 40px;
    
    font-size: 20px;
}

</style>