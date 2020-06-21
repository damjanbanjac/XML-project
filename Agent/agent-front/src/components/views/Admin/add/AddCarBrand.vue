<template>
     <div>
    <b-container v-if="error">
      <b-alert show variant="danger" class="d-flex justify-content-center">{{errormessage}}</b-alert>
    </b-container>

     <b-container v-if="success">
      <b-alert show variant="success" class="d-flex justify-content-center">{{successmessage}}</b-alert>
    </b-container>

    <div class="container d-flex justify-content-center" style="margin-top: 20px">
      <!--Form with header-->
      <div class="card" style="width: 40%">
        <!--Header-->
        <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
            style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Add car brand</h3>
          </div>
        </div>
        <!--Header-->

        <div class="form-group">
          <div class="card-body mx-4 mt-4">
            <div class="row">
              
              <div class="col">
                <div class="md-form pb-3">

                  <label for="Form-name">Name</label>
                  <input type="text" id="Form-name" class="form-control" v-model="form.name" />

                  <br/>

                  <label for="Form-label">Label</label>
                  <input type="text" id="Form-label" class="form-control" v-model="form.label" />
           
                </div>
              </div>
            </div>
            <!--Body-->

            <div class="text-center mb-4">
              <br/>
              <button
                type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="addCarBrand()"
              >Add</button>
            </div>
          </div>
        </div>
      </div>
      <!--/Form with header-->
    </div>
  </div>
</template>

<script>
import axios from "axios";
 export default {
    data() {
      return {
        form: {
          name: '',
          label: ''
        },
        error: false,
        errormessage: "",
        success: false,
        successmessage: ""
      }
    },
    methods: {
        addCarBrand() {
        if (this.form.name === "" || this.form.label === ""){
          this.errormessage = "Please fill all fields";
          this.error = true;
          return;
        }
        axios
        .post("/brands", this.form)
        .then(() => {
          this.form.name = "";
          this.form.label = "";
          this.success = true;
          this.successmessage = "You have successfully added a new car brand."
        })
        .catch(error => {
          console.log(error);
          this.error = true;
        });
        }
    }
 }
</script>

<style>

</style>