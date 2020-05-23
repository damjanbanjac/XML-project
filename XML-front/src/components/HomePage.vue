<template>
    <div>
        <b-navbar toggleable="lg" variant="light">
            <b-navbar-brand style="font-weight: 300;line-height: 1.2;">Welcome!</b-navbar-brand>
            <div style="border-left:1px solid #000; height:40px; margin-right:1%"></div>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
            <router-link to="/login" tag="b-nav-item">Log In</router-link>
                <b-nav-item-dropdown
                    id="my-nav-dropdown"
                    text="Register "
                    toggle-class="nav-link-custom"
                    right
                    >
                    <router-link to="/clientRegistration" tag="b-dropdown-item">As client</router-link>
                    <router-link to="/agentRegistration" tag="b-dropdown-item">As company</router-link>
                    </b-nav-item-dropdown>
            <router-link to="/createPriceList" tag="b-nav-item">Create price list</router-link>
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