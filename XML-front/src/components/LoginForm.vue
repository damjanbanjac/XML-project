<template>
<div>
  <div>
      <b-container v-if="error">
      <b-alert show variant="danger" class="d-flex justify-content-center">{{errorMessage}}</b-alert>
      </b-container>
  </div>
    <b-jumbotron bg-variant="light" text-variant="dark" style="margin-top: 3%;
    margin-left: 4%;
    width: 465px;
    height: 460px;">
      <h2 style="font-size: 4rem;
        font-weight: 300;
        line-height: 1.2;
        margin-left: 26%;">
        Log In
      </h2>

      <template>
        <b-form >
          
          <b-form-group id="input-group-1">
            <b-form-input
              id="input-1"
              v-model="user.email"
              type="email"
              required
              placeholder="Enter email"
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-2">
            <b-form-input
              id="input-2"
              v-model="user.password"
              type="password"
              required
              placeholder="Enter password"
            ></b-form-input>
          </b-form-group>

          <b-form-group>
            <b-button type="submit"  @click="loginFun" variant="primary" style="width: 320px">Log In</b-button>
          </b-form-group>

          <hr>

        </b-form>
      </template>

      <b-form-group style="margin-left: 18%;">
        <label style="margin-right: 2%">Don't have an account?</label>
        <router-link to="/clientRegistration">Sign Up!</router-link>
        <br/>
      </b-form-group>

    </b-jumbotron>
</div>
</template>

<script>
import axios from "axios";
import VueJwtDecode from "vue-jwt-decode";
  export default {
    data() {
      return {
        user: {
          email: '',
          password: ''
        },
        error: false,
        errorMessage: "",
        show: true
      }
    },
    methods: {
      loginFun() {
        this.error = false;
        console.log(this.user.email + "" + this.user.password)

        axios
        .post("/auth/login", this.user)
        .then(response => {
          this.user.email = "";
          this.user.password = "";
          // console.log("usao");
          localStorage.setItem("jwt", response.data.accessToken);
          this.$store.state.user = VueJwtDecode.decode(
            localStorage.getItem("jwt")
          );
          
          this.$router.push("/");
        })
        .catch(show => {
          console.log(show);
          
        });

      }
    }
}
</script>

<style>

form {
    display: block;
    margin-top: 10%;
    margin-left: 10%;
    width: 320px;
}

.jumbotron {
    padding: 2rem 2rem;
    margin-bottom: 2rem;
}

</style>