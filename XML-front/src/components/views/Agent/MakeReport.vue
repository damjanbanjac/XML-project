<template>
<div>

    <b-jumbotron bg-variant="light" text-variant="dark" style="margin-top: 3%;
    margin-left: 4%;
    width: 465px;
    height: 460px;">
      <h2 style="font-size: 3rem;
        font-weight: 300;
        line-height: 1.2;
        margin-left: 20%;">
        Issue report
      </h2>

      <template>
        <b-form >
             <b-form-group id="input-group-1">
           <label for="Form-carBrand">Ad</label>
                  <b-form-select v-model="selectedAd">
                    <option
                      v-for="ad in ads"
                      :value="ad.id"
                      :key="ad.id"
                    >{{ad.id}}</option>
                  </b-form-select>
             </b-form-group>
          <b-form-group id="input-group-1">
            <b-form-input
              id="input-1"
              v-model="report.text"
              type="text"
              required
              placeholder="Description"
            
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-2">
            <b-form-input
              id="input-2"
              v-model="report.km"
              type="text"
              required
              placeholder="Set km"
   
            ></b-form-input>
          </b-form-group>

          <b-form-group>
            <b-button type="submit"  @click="makeReport" variant="info" style="width: 320px">Save</b-button>
          </b-form-group>

          <hr>

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
        report: {
          order: {},
          text: '',
          km: ''
        },
        error: false,
        errorMessage: "",
        show: true,
        ads: [],
        selectedAd: ""
      }
    },
    methods: {
      makeReport() {

         this.ads.forEach(ad => {
            if (ad.id === this.selectedAd) {
            this.report.order = ad;
            }
           });
       
        axios
        .post("ads/reports/", this.report)
        .then(response => {
            this.report = response;
          this.report.km = "";
          this.report.text = "";
          // console.log("usao");
         
        
        })
        .catch(error => {
          // console.log(show);
          console.log(error);
          this.errorMessage = "Bad credentials."
          this.error = true;
        
        });

      }
    },
    mounted() {
    axios
      .get("/ads/reports")
      .then(ads => {
        this.ads = ads.data;
        
      })
      .catch(error => {
        console.log(error);
      });
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