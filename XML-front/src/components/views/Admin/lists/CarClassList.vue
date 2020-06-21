<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 40%">
      
        <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5"
                style="font-size: 3rem;
                font-weight: 300;
                line-height: 1.2;
                margin-top: -12%;">Car classes</h3>
            </div>
        </div>

        <div class="form-group" v-for="carclass in carclasses" :key="carclass.id">
            <div class="card-body mx-4 mt-4">
                <div class="row">
                    <div class="col">
                        <div class="md-form">
                            <label for="Form-car_class">Car class</label>
                            <label id="Form-car_class" class="form-control">{{carclass.car_class}}</label>

                            <br/>

                            <div class="text-center mb-4">
                                <router-link :to="'/updateCarClass/'+ carclass.id"
                                tag="button"
                                class="btn btn-info mt-2 btn-block z-depth-2" >Update</router-link>
                            </div>
                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-danger btn-block z-depth-2"
                                @click="deleteCarClass(carclass.id)"
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
      carclasses: []           
    };
  },
  methods: {

    deleteCarClass(id) {
        axios
        .delete("/maintenance/classes/" + id + "/class")
        axios
        .get("/maintenance/classes")
        .then(carclasses => {
            console.log("usao u listu")
            this.carclasses = carclasses.data;
        })
        .catch(error => {
            console.log(error);
        });
    },

  },

    mounted() {
        console.log("usao");
        axios
        .get("/maintenance/classes")
        .then(carclasses => {
            console.log("usao u listu")
            this.carclasses = carclasses.data;
        })
        .catch(error => {
            console.log(error);
        });
    }
  }

</script>

<style>

</style>