<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 40%">
      
        <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
                style="font-size: 3rem;
                font-weight: 300;
                line-height: 1.2;
                margin-top: -12%;">Car brands</h3>
            </div>
        </div>

        <div class="form-group" v-for="carbrand in carbrands" :key="carbrand.id">
            <div class="card-body mx-4 mt-4">
                <div class="row">
                    <div class="col">
                        <div class="md-form">
                            <label for="Form-name">Car brand</label>
                            <label id="Form-name" class="form-control">{{carbrand.name}}</label>
                            <label for="Form-name">Car label</label>
                            <label id="Form-name" class="form-control">{{carbrand.label}}</label>

                            <br/>

                            <div class="text-center mb-4">
                                <router-link :to="'/updateCarBrand/'+ carbrand.id"
                                tag="button"
                                class="btn btn-info mt-2 btn-block z-depth-2" >Update</router-link>
                            </div>
                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-danger btn-block z-depth-2"
                                @click="deleteCarBrand(carbrand.id)"
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
      carbrands: []           
    };
  },
  methods: {

    deleteCarBrand(id) {
        axios
        .delete("/maintenance/brands/" + id + "/brand")
        .then(carbrands => {
          this.carbrands = carbrands.data;
        })
        .catch(error => {
          console.log(error);
        });
        axios
        .get("/maintenance/brands")
        .then(carbrands => {
            this.carbrands = carbrands.data;
            console.log(carbrands.data)
        })
        .catch(error => {
            console.log(error);
        });
    },
  },

    mounted() {
        console.log("usao");
        axios
        .get("/maintenance/brands")
        .then(carbrands => {
            this.carbrands = carbrands.data;
            console.log(carbrands.data)
        })
        .catch(error => {
            console.log(error);
        });
    }
  }


</script>

<style>

</style>