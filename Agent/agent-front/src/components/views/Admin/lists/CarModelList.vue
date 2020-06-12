<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 60%">
      
        <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Car models</h3>
            </div>
        </div>

        <div class="form-group" v-for="carmodel in carmodels" :key="carmodel.id">
            <div class="card-body mx-4 mt-4">
                <div class="row">
                    <div class="col">
                        <div class="md-form">
                            <label for="Form-model">Car class</label>
                            <label id="Form-model" class="form-control">{{carmodel.model}}</label>
                            <div class="text-center mb-4">
                                <router-link :to="'/updateCarModel/'+ carmodel.id"
                                tag="button"
                                class="btn btn-info mt-2 btn-block z-depth-2" >Update</router-link>
                            </div>
                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-success btn-block z-depth-2"
                                @click="deleteCarModel(carmodel.id)"
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
      carmodels: []           
    };
  },
  methods: {

    deleteCarClass(id) {
        axios
        .delete("/models/" + id + "/model")
    },

    mounted() {
        console.log("usao");
        axios
        .get("/models")
        .then(carmodels => {
            console.log("usao u listu")
            this.carmodels = carmodels.data;
        })
        .catch(error => {
            console.log(error);
        });
    }
  }
};
</script>

<style>

</style>