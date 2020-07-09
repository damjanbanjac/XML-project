<template>
<div>
    <b-jumbotron bg-variant="light" text-variant="dark" style="width: 510px;
    height: 680px;
    margin-top: 2%;
    margin-left:32%">
        <template>
            <h2 style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-bottom: 2rem;
            margin-left: 13%">Create pricelist</h2>
        </template>

        <template>
            <b-form bg-variant="light" @submit="onSubmit">

               
                <b-form-group
                    id="input-group-1"
                    label="Pricelist name:"
                    label-for="input-1"
                >
                    <b-form-input
                    id="input-1"
                    v-model="form.name"
                    required
                    placeholder="Enter pricelist name"
                    ></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Weekend price:" label-for="input-2">
                    <b-form-input
                    id="input-2"
                    v-model="form.priceForWeekend"
                    required
                    type="number"
                    placeholder="Enter weekend price"
                    ></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-3" label="Workdays price:" label-for="input-3">
                    <b-form-input
                    id="input-3"
                    v-model="form.priceForWorkDay"
                    required
                    type="number"
                    placeholder="Enter workday price"
                    ></b-form-input>
                </b-form-group>

                 <b-form-group id="input-group-4" label="CDW price:" label-for="input-4">
                    <b-form-input
                    id="input-4"
                    v-model="form.priceForCDW"
                    required
                    type="number"
                    placeholder="Enter cdw price"
                    ></b-form-input>
                </b-form-group>

                 <b-form-group id="input-group-5" label="KM restriction price:" label-for="input-5">
                    <b-form-input
                    id="input-5"
                    v-model="form.priceForKmRestriction"
                    required
                    type="number"
                    placeholder="Enter km restriction price"
                    ></b-form-input>
                </b-form-group>

              

              

                <b-form-group>
                    <b-button  variant="info" @click="onSubmit()">Create pricelist</b-button>
                </b-form-group>

            </b-form>

        </template>
    </b-jumbotron>
</div>
</template>

<script>
import axios from "axios";
import Vue from 'vue';
import { MultiSelectPlugin } from '@syncfusion/ej2-vue-dropdowns';
Vue.use(MultiSelectPlugin);
  export default {
    name: 'PriceList',
    data() {
      return {
        form: {
          name: '',
          priceForWorkend: '',
          priceForWeekday: '',
          priceForKmRestriction: '',
          priceForCDW: ''
        },
        show: true,
      }
    },
    methods: {
          onSubmit() {

        
       
        axios
        .post("ads/pricelist/" + this.$store.state.user.id + "/user", this.form)
        .then(response => {
            this.form = response;
          this.form.name = "";
          this.form.priceForWorkDay = "";
          this.form.priceForWeekday = "";
          this.form.priceForKmRestriction = "";
          this.form.priceForCdw = "";
          // console.log("usao");
         
        
        })
        .catch(error => {
          // console.log(show);
          console.log(error);
          this.errorMessage = "Bad credentials."
          this.error = true;
        
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

.lbl {
    margin-bottom: 12px;
}

@import url(https://cdn.syncfusion.com/ej2/material.css);

</style>