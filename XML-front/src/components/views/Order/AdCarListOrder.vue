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
        <div class="card-body mx-8 mt-4">
          <div class="row">
            <b-col>
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Id</label>
                <label id="Form-ime" class="form-control">{{oglas.id}}</label>
                
                
              </div>
            </div>
            <div class="col">
              <div class="md-form pb-3">
                <label for="Form-ime">Agent issued</label>
                <label id="Form-ime" class="form-control">{{oglas.agentIzdaoAd.id}}</label>
            
                <div class="text-center mb-4">
                  <button
                    type="button"
                    class="btn btn-danger btn-block z-depth-2"
                  @click="priprema(oglas)">Prepare</button>
                </div>
              </div>
            </div>
            </b-col>
            <b-col v-if="prepare">
                <div class="col">
              <div class="md-form">
                <!--<label for="Form-ime">Id</label>
                <label id="Form-ime" class="form-control">{{order.adCar.id}}</label>
                
                <label for="Form-ime">Agent issued</label>
                <input
                      type="text"
                      id="Form-username"
                      class="form-control"
                      v-model="order.adCar.agentIzdaoAd.id"
                      disabled
                    />-->
                <label for="Form-ime">Start date</label>
                <input
                      type="text"
                      id="Form-start"
                      class="form-control"
                      v-model="order.availableFrom"
                    />
                <label for="Form-ime">End date</label>
                <input
                      type="text"
                      id="Form-end"
                      class="form-control"
                      v-model="order.availableTo"
                    />
                <div class="text-center mb-4">
                  <button
                    type="button"
                    class="btn btn-danger btn-block z-depth-2"
                  @click="naruci()">Add to bag</button>
                </div>
              </div>
            </div>
            </b-col>
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
      prepare: false,
      order:{
        adCar:{
          id: "",
          userIzdavaoAd: "",
          agentIzdaoAd: "",
        },
      availableFrom: "",
      availableTo: "",
      }
    };
  },
  methods: {
    priprema(oglas){
      this.prepare = true;
      this.order.adCar = oglas;
      console.log(this.order.adCar)
      
    },
    naruci(){
      console.log(this.order)
      axios
          .post("/order/orders", this.order)
          .then(response => {
            this.order= response.data;
            this.prepare = false;
          })
          .catch(error => {
            console.log(error);
          });
    },
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