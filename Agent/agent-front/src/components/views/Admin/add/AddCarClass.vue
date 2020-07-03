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
            <h3 class="deep-grey-text mt-3 mb-2 pb-1 mx-5" 
            style="font-size: 2rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Add car class</h3>
          </div>
        </div>
        <!--Header-->

        <div class="form-group">
          <div class="card-body mx-4 mt-4">
            <div class="row">
              
              <div class="col">
                <div class="md-form pb-3">

                  <label for="Form-car_class">Car class</label>
                  <input type="text" placeholder="Enter car class" id="Form-car_class" class="form-control" v-model="form.car_class" />
           
                </div>
              </div>
            </div>
            <!--Body-->

            <div class="text-center mb-4">
              <br/>
              <button
                type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="addCarClass()"
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
          car_class: ''
        },
        error: false,
        errormessage: "",
        success: false,
        successmessage: ""
      }
    },
    methods: {
        addCarClass() {
        if (this.form.car_class === ""){
          this.errormessage = "Please fill all fields";
          this.error = true;
          return;
        }
        var rexx = /^[a-zA-Z\-0-9\s]+$/;
        if (!rexx.test(String(this.form.car_class.trim()))) {
        this.errormessage = "Car class must not contain unacceptable characters";
        this.error = true;
        return;
      }
        axios
        .post("/classes", this.form)
        .then(() => {
          this.form.car_class = "";
          this.success = true;
          this.error = false;
          this.successmessage = "You have successfully added a new car class."
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