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
            margin-top: -12%;">Update type of gearshift</h3>
          </div>
        </div>
        <!--Header-->

        <div class="form-group">
          <div class="card-body mx-4 mt-4">
            <div class="row">
              
              <div class="col">
                <div class="md-form pb-3">

                  <label for="Form-type">Type of gearshift</label>
                  <input type="text" id="Form-type" class="form-control" v-model="form.type" :disabled="!change" />
           
                </div>
              </div>
            </div>
            <!--Body-->

            <div class="text-center mb-4 mt-4">
            <template v-if="!change">
            <button type="button" class="btn btn-info btn-block z-depth-2" @click="changeClick()">Change</button>
            </template>
            <template v-else>
            <button type="button" class="btn btn-success btn-block z-depth-2" @click="saveClick()">Save</button>
            <button type="button" class="btn btn-secondary btn-block z-depth-2" @click="cancelClick()">Cancel</button>
            </template>

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
        form: {},
        error: false,
        errormessage: "",
        success: false,
        successmessage: "",
        change: false
      }
    },
    methods: {
      changeClick() {
          this.change = true;
      },
      cancelClick() {
        this.error = false;
        this.errormessage = "";
        this.change = false;
        axios
        .get("/gearshift-types/" + this.$route.params.id + "/gearshift-type")
        .then(type => {
          this.form = type.data;
        })
        .catch(error => {
          console.log(error);
        });
      },
      saveClick() {
        if (this.form.type=="") {
          this.error = true;
          this.errormessage = "Please fill all fields";
          return;
        }
        axios
        .put("/gearshift-types/" + this.$route.params.id + "/gearshift-type", this.form)
        .then(type => {
        this.form = type.data;
        this.change = false;
        this.success = true;
        this.successmessage = "You have successfully updated a gearshift type."
        })
        .catch(error => {
          console.log(error);
        });
      }
    },
    mounted() {
      axios
        .get("/gearshift-types/" + this.$route.params.id + "/gearshift-type")
        .then(type => {
          this.form = type.data;
          this.change = false;
        })
        .catch(error => {
          console.log(error);
        });
    }
}
</script>

<style>

</style>