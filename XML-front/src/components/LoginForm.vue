<template>
<div>
    <b-jumbotron bg-variant="light" text-variant="dark" style="margin-top: 3%;
    margin-left: 4%;
    width: 465px;
    height: 460px;">
      <h2 style="font-size: 4rem;
    font-weight: 300;
    line-height: 1.2;
    margin-left: 25%;">Log In</h2>

      <template>
        <b-form @submit="onSubmit">
          
          <b-form-group id="input-group-1">
            <b-form-input
              id="input-1"
              v-model="form.email"
              type="email"
              required
              placeholder="Enter email"
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-2">
            <b-form-input
              id="input-2"
              v-model="form.password"
              type="password"
              required
              placeholder="Enter password"
            ></b-form-input>
          </b-form-group>

          <b-form-group>
            <b-button type="submit" variant="primary" style="width: 320px">Log In</b-button>
          </b-form-group>

          <hr>

        </b-form>
      </template>

      <b-form-group style="margin-left: 10%;">
        <label style="margin-right: 2%">Don't have an account?</label>
        <router-link to="#foo">Sign Up!</router-link>
        <br/>
        <label style="margin-right: 2%">or</label>
        <b-link href="#foo">Skip!</b-link>
      </b-form-group>

    </b-jumbotron>
</div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          email: '',
          password: ''
        },
        show: true
      }
    },
    methods: {
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