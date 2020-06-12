<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 40%">
      
        <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Types of gearshift</h3>
            </div>
        </div>

        <div class="form-group" v-for="gearshifttype in gearshifttypes" :key="gearshifttype.id">
            <div class="card-body mx-4 mt-4">
                <div class="row">
                    <div class="col">
                        <div class="md-form">
                            <label for="Form-type">Type of gearshift</label>
                            <label id="Form-type" class="form-control">{{gearshifttype.type}}</label>

                            <br/>
                            
                            <div class="text-center mb-4">
                                <router-link :to="'/updateTypeOfGearshift/'+ gearshifttype.id"
                                tag="button"
                                class="btn btn-info mt-2 btn-block z-depth-2" >Update</router-link>
                            </div>
                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-danger btn-block z-depth-2"
                                @click="deleteGearshiftType(gearshifttype.id)"
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
      gearshifttypes: []           
    };
  },
  methods: {

    deleteGearshiftType(id) {
        axios
        .delete("/gearshift-types/" + id + "/gearshift-type")
        axios
        .get("/gearshift-types")
        .then(gearshifttypes => {
            console.log("usao u listu")
            this.gearshifttypes = gearshifttypes.data;
        })
        .catch(error => {
            console.log(error);
        });
        // location.reload();
    },
  },

    mounted() {
        console.log("usao");
        axios
        .get("/gearshift-types")
        .then(gearshifttypes => {
            console.log("usao u listu")
            this.gearshifttypes = gearshifttypes.data;
        })
        .catch(error => {
            console.log(error);
        });
    }
  }

</script>

<style>

</style>