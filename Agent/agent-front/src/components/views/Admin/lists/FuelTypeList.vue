<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 40%">
      
        <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5"
                style="font-size: 3rem;
                font-weight: 300;
                line-height: 1.2;
                margin-top: -12%;">Types of fuel</h3>
            </div>
        </div>

        <div class="form-group" v-for="fueltype in fueltypes" :key="fueltype.id">
            <div class="card-body mx-4 mt-4">
                <div class="row">
                    <div class="col">
                        <div class="md-form">
                            <label for="Form-type">Type of fuel</label>
                            <label id="Form-type" class="form-control">{{fueltype.type}}</label>

                            <br/>
                            
                            <div class="text-center mb-4">
                                <router-link :to="'/updateTypeOfFuel/'+ fueltype.id"
                                tag="button"
                                class="btn btn-info mt-2 btn-block z-depth-2" >Update</router-link>
                            </div>
                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-danger btn-block z-depth-2"
                                @click="deleteFuelType(fueltype.id)"
                                >Delete</button>
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
      fueltypes: []           
    };
  },
  methods: {

    deleteFuelType(id) {
        axios
        .delete("/fuel-types/" + id + "/fuel-type")
        .then(() => {
          axios
          .get("/fuel-types")
          .then(fueltypes => {
              this.fueltypes = fueltypes.data;
          })
          .catch(error => {
              console.log(error);
          });
        })
        .catch(error => {
          console.log(error);
        });
    },
  },

    mounted() {
        console.log("usao");
        axios
        .get("/fuel-types")
        .then(fueltypes => {
            console.log("usao u listu")
            this.fueltypes = fueltypes.data;
        })
        .catch(error => {
            console.log(error);
        });
    }
  }

</script>

<style>

</style>