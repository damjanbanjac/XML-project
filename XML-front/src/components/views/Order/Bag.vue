<template>
  <div>

    
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    <!--Form with header-->
    <div class="card" style="width: 40%">
      <!--Header-->
      <div style="margin-left:-1%" class="header pt-3 grey lighten-2">
         <div class="row d-flex justify-content-start">
          <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Bag</h3>
        </div>
      </div>
      <!--Header-->

      <b-container>
      <label style="margin-left:4%">Bundle:</label>
              <input
                      type="checkbox"
                      id="checkbox"
                      class="form-control"
                      v-model="bundle"
                    />
    </b-container>

      <div class="form-group" v-for="oglas in oglasi" :key="oglas.id">
        <div class="card-body mx-8 mt-4">
          <div class="row">
            <b-col>
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Id</label>
                <label id="Form-ime" class="form-control">{{oglas.id}}</label>
                
              </div>
              <div class="md-form">
                <label for="Form-ime">Start data:</label>
                <label id="Form-ime" class="form-control">{{oglas.availableFrom}}</label>
                
              </div>
            </div>
            <div class="col">
              <div class="md-form pb-3">
                <!--label for="Form-ime">Agent issued</label>
                <label id="Form-ime" class="form-control">{{oglas.adCar.agentIzdaoAd.id}}</label-->

                <div class="md-form">
                <label for="Form-ime">End data:</label>
                <label id="Form-ime" class="form-control">{{oglas.availableTo}}</label>
                <br/>
                
              </div>
                <div class="text-center mb-4">
                  <button
                    type="button"
                    class="btn btn-info btn-block z-depth-2"
                  @click="reserve(oglas)">Create request</button>
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
      bundle: false,
      request: {},
    };
  },
  methods: {
    reserve(oglas){
      console.log(oglas)
      axios
          .post("order/requests/"+this.bundle+"/request/user/" + this.$store.state.user.id, oglas)
          .then(response => {
              this.oglasi= response.data
          })
          .catch(error => {
            console.log(error);
          });
    },
  },
   mounted() {
    axios
      .get("/order/orders/"+ this.$store.state.user.id +"/user")
      .then(oglasi => {
        this.oglasi = oglasi.data;
      })
      .catch(error => {
        console.log(error);
      });
   }
}
</script>

<style>

</style>