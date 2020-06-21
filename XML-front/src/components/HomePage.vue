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

                </b-nav-item-dropdown>
                <b-nav-item-dropdown
                    id="my-nav-dropdown"
                    text="Admin"
                    toggle-class="nav-link-custom"
                    right
                    >
                    <router-link to="/agentRegistration" tag="b-dropdown-item">Register agent/company</router-link>
                    <router-link to="/registrationRequests" tag="b-dropdown-item">Registration requests</router-link>
                    <router-link to="/userList" tag="b-dropdown-item">Users</router-link>

                </b-nav-item-dropdown>
            
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