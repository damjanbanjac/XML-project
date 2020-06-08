<template>
  <div>
  <b-navbar type="dark" variant="dark">
    <b-navbar-nav>
      <b-nav-item href="/">Home</b-nav-item>

      <!-- Navbar dropdowns -->
      <b-nav-item-dropdown text="Ad" left>
        <router-link to="/newAd" tag="b-dropdown-item">New Ad</router-link>
        <router-link to="/openedAd" tag="b-dropdown-item">Ad profile</router-link>
      </b-nav-item-dropdown>

      <b-nav-item-dropdown text="Lists" left>
        <router-link to="/userList" tag="b-dropdown-item">Users</router-link>
        <router-link to="/registrationRequests" tag="b-dropdown-item">Registration requests</router-link>
      </b-nav-item-dropdown>

      <router-link to="/agentRegistration" tag="b-nav-item">Agent registration</router-link>

      <b-nav-item-dropdown text="User" left>
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