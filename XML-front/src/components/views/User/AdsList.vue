<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 60%">
      
      <div class="header pt-3 grey lighten-2">
        <div class="row d-flex justify-content-start">
          <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Ads</h3>
        </div>
      </div>
      
  


    <div class="form-group" v-for="ad in ads" :key="ad.id">
        <div class="card-body mx-4 mt-4">
          <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Brand</label>
                <label id="Form-ime" class="form-control">{{ad.carBrand_id.name}}</label>
              

                <div class="text-center mb-4">
                  <router-link :to="'/openedAdByUser/'+ ad.id"
                      tag="button"
                      class="btn btn-info mt-2 btn-block z-depth-2" >Open ad</router-link>
                </div>
               
              </div>
            </div>
           
            </div>
          </div>
           </div>
    </div>

  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      ads: [],
            
    };
  },
   

  mounted() {
      console.log("usao");
    axios
      .get("ads/ads")
      .then(ads => {
          console.log("usao u listu")
        this.ads = ads.data;
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

<style>

</style>