<template>
<div>
    <div>
        <b-container v-if="error">
        <b-alert show variant="danger" class="d-flex justify-content-center">{{errorMessage}}</b-alert>
        </b-container>
    </div>
    <b-jumbotron bg-variant="light" text-variant="dark" style="width: 510px;
    height: 910px;
    margin-top: 0.6%;
    margin-left: 3%;"> 
        <template>
            <h2 style="font-size: 2rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;
            margin-bottom: -1rem;">Client Registration</h2>
        </template>

        <template>
            <b-form bg-variant="light">
            <b-form-group
                id="input-group-1"
                label="Email address:"
                label-for="input-1"
            >
                <b-form-input
                id="input-1"
                v-model="form.email"
                type="email"
                required
                placeholder="Enter email"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Name:" label-for="input-2">
                <b-form-input
                id="input-2"
                v-model="form.name"
                required
                placeholder="Enter name"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-3" label="Surname:" label-for="input-3">
                <b-form-input
                id="input-3"
                v-model="form.surname"
                required
                placeholder="Enter surname"
                ></b-form-input>
            </b-form-group>

             <b-form-group id="input-group-7" label="Phone Number:" label-for="input-7">
                <b-form-input
                id="input-7"
                v-model="form.phoneNumber"
                required
                placeholder="Enter phone number"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-4" label="Address:" label-for="input-4">
                <b-form-input
                id="input-4"
                v-model="form.address"
                required
                placeholder="Enter address"
                ></b-form-input>
            </b-form-group>

             <b-form-group id="input-group-8" label="Town:" label-for="input-8">
                <b-form-input
                id="input-8"
                v-model="form.town"
                required
                placeholder="Enter town"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-9" label="Country:" label-for="input-9">
                <b-form-input
                id="input-9"
                v-model="form.country"
                required
                placeholder="Enter country"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Password:" label-for="input-5">
                <b-form-input
                id="input-5"
                v-model="form.password"
                required
                type="password"
                placeholder="Enter password"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-6" label="Password:" label-for="input-6">
                <b-form-input
                id="input-6"
                v-model="form.repassword"
                required
                type="password"
                placeholder="Re-enter password"
                ></b-form-input>
            </b-form-group>

            <b-form-group>
                <b-button type="submit" variant="info" @click="regist">Register</b-button>
            </b-form-group>

            </b-form>

        </template>
    </b-jumbotron>
</div>
</template>

<script>
import axios from "axios";
  export default {
    data() {
      return {
        form: {
          email: '',
          name: '',
          surname: '',
          phoneNumber: '',
          address: '',
          town: '',
          country: '',
          password: '',
          repassword: ''
        },
        error: false,
        errorMessage: "",
        show: true
      }
    },
    methods: {
      regist(){
            this.error = false;
      if (
        this.form.email == "" ||
        this.form.name == "" ||
        this.form.surname == "" ||
        this.form.phoneNumber == "" ||
        this.form.address == "" ||
        this.form.town == "" ||
        this.form.country == "" ||
        this.form.password == "" ||
        this.form.repassword == ""
      ) {
        this.errorMessage = "Please fill all fields";
        this.error = true;
        return;
      }
      // var pass = /(?=.*[!@#\$%\^&\*])(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.{8,})/;
      // if (!pass.test(String(this.form.password.trim()))) {
      //   this.errorMessage = "Password too weak.";
      //   this.error = true;
      //   return;
      // }
      let lowercase = this.form.password.match((/[a-z]+/g));
      let uppercase = this.form.password.match((/[A-Z]+/g));
      let digits = this.form.password.match((/[\d]+/g));
      let special = this.form.password.match((/[!@#$%^&*_]+/g));
      let lenght = this.form.password.match((/[A-Za-z\d!@#$%^&*_]{8,}/g));
      
      if(lowercase == null){
        this.errorMessage = "Lowercase necessary.";
        this.error = true;
        return;
      }
      if(uppercase == null){
        this.errorMessage = "Uppercase necessary.";
        this.error = true;
        return;
      }
      
      if(digits == null){
        this.errorMessage = "Digits necessary.";
        this.error = true;
        return;
      }
      if(special == null){
        this.errorMessage = "Special character necessary.";
        this.error = true;
        return;
      }
      if(lenght == null){
        this.errorMessage = "At least 8 characters necessary.";
        this.error = true;
        return;
      }
      if (this.form.password !== this.form.repassword) {
        this.errorMessage = "Entered passwords do not match";
        this.error = true;
        return;
      }
      var rexx = /^[a-zA-Z\-0-9\s]+$/;
        if (!rexx.test(String(this.form.name.trim()))) {
        this.errorMessage = "Name must not contain unacceptable characters";
        this.error = true;
        return;
      }
      if (!rexx.test(String(this.form.surname.trim()))) {
        this.errorMessage = "Surname must not contain unacceptable characters";
        this.error = true;
        return;
      }
      if (!rexx.test(String(this.form.address.trim()))) {
          this.errorMessage = "Address must not contain unacceptable characters";
          this.error = true;
          return;
      }
      if (!rexx.test(String(this.form.town.trim()))) {
        this.errorMessage = "Town must not contain unacceptable characters";
        this.error = true;
        return;
      }
        if (!rexx.test(String(this.form.country.trim()))) {
        this.errorMessage = "Country must not contain unacceptable characters";
        this.error = true;
        return;
      }
      
      var rex = /^\+38[0-9]\/6[0-9]-?[0-9]+(-[0-9]+)?$/;
      if (!rex.test(String(this.form.phoneNumber.trim()))) {
        this.errorMessage = "Phone number should be entered in +381/65-504205 format";
        this.error = true;
        return;
      }
    axios
        .post("auth/register/",this.form)
        .then(form=>{
            this.form=form.data;
            this.error = false;
        })
        .catch(error => {
        console.log(error);
        });
      }
    }
}
</script>

<style>
.jumbotron {
    padding: 2rem 2rem;
    margin-bottom: 2rem;
}
</style>