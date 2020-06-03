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
            <b-button type="submit"  @click="loginFun" variant="info" style="width: 320px">Log In</b-button>
          </b-form-group>

          <hr>

        </b-form>
      </template>

      <b-form-group style="margin-left: 18%;">
        <label style="margin-right: 2%">Don't have an account?</label>
        <router-link to="/clientRegistration">Register!</router-link>
        <br/>
      </b-form-group>

    </b-jumbotron>
</div>
</template>

<script>
import axios from "axios";
import VueJwtDecode from "vue-jwt-decode";
  var counter = 0;
  localStorage.setItem('counter', counter)
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
        if(localStorage.getItem('counter') == 3){
          this.errorMessage = "You have reached your logging attempts limit.";
          this.error = true;
          return;
        }
        this.error = false;
        // console.log(this.user.email + "" + this.user.password)

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
        .catch(error => {
          // console.log(show);
          console.log(error);
          this.errorMessage = "Bad credentials."
          this.error = true;
          counter++;
          localStorage.setItem('counter', counter)
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