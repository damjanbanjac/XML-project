<template>
<div>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    <!--Form with header-->
    <div class="card" style="width: 60%">
      <!--Header-->
      <div class="header pt-3 grey lighten-2">
         <div class="row d-flex justify-content-start">
          <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Ads</h3>
        </div>
      </div>
      <!--Header-->

      <div class="form-group" v-for="oglas in oglasi" :key="oglas.id">
        <div class="card-body mx-4 mt-4">
          <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Id</label>
                <label id="Form-ime" class="form-control">{{oglas.id}}</label>
                
              </div>
            </div>
            <div class="col">
              <div class="md-form pb-3">
                <label for="Form-ime">Agent izdao</label>
                <label id="Form-ime" class="form-control">{{oglas.agentIzdaoAd}}</label>
            
                <div class="text-center mb-4">
                  <button
                    type="button"
                    class="btn btn-danger btn-block z-depth-2"
                  >Obriši</button>
                </div>
              </div>
            </div>
          </div>
          <!--Body-->
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
      oglasi: [],
    };
  },
   mounted() {
    axios
      .get("/order/orders/oglasi")
      .then(oglasi => {
        this.oglasi = oglasi.data;
        
      })
      .catch(error => {
        console.log(error);
      });
   }
};
</script>

<style>

</style>