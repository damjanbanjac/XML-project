<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    <!--Form with header-->
    <div class="card" style="width: 60%">
      <!--Header-->
      <div class="header pt-3 grey lighten-2">
        <div class="row d-flex justify-content-start">
          <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Ads list</h3>
        </div>
      </div>
      <!--Header-->




<b-container>
         <div>
    <b-table class="mt-2 mb-2" striped hover :items="ads" @row-selected="activateAd" select-mode="single" :fields="fields"   selectable caption-top >
          <!-- <template v-slot:table-caption><h3>Ads list</h3>
          </template> -->
    </b-table>
  </div>
</b-container>
  


    

      
    </div>
    
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      ads: [],
      fields: [
        {
          key: 'id',
        sortable: true},
          {key: 'carBrand_id.name',
        sortable: true},
          {key: 'city',
        sortable: true},
        ],

      idAd: ""
     
    };
  },
  
  

methods: {
  
    activateAd(idAd) {
      
    
        
        this.$router.push("/openedAdByUser/" + idAd[0].id);
        
        
      
    }

   
},
   
  mounted() {
    axios
      .get("/ads")
      .then(ads => {
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