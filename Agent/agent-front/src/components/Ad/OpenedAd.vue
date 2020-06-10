<template>
    <div class="container d-flex justify-content-center" style="margin-top: 20px">
      <!--Form with header-->
      <div class="card" style="width: 60%">
        <!--Header-->
        <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
            style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Add Car</h3>
          </div>
        </div>
        <!--Header-->

        <div class="form-group">
          <div class="card-body mx-4 mt-4">
            <div  class="row">
              <div class="col">
                <div class="md-form">
                  <label for="Form-carBrand">Car Brand</label>
                  

                  <label for="Form-phone">Car Class</label>
                  

                  <label for="Form-email">Car Model</label>
                  

                  <label for="Form-adresa">City</label>
                  <input type="text" id="Form-carCity" class="form-control" v-model="form.city" />

                  <label for="Form-radnoDo">Available From</label>
                  <input type="date" id="Form-availableFrom" class="form-control" v-model="form.availableFrom" />
                   <label for="Form-radnoDo">Available To</label>
                  <input type="date" id="Form-availableTo" class="form-control" v-model="form.availableTo" >
                </div>
              </div>
              <div class="col">
                <div class="md-form pb-3">
                  <label for="Form-grad">Type of fuel</label>
                  

                  <label for="Form-država">Type of gearshift</label>
                  

                  <label for="Form-br">Kids Seats</label>
                  <input type="text" id="Form-kidsSeats" class="form-control" v-model="form.kidsSeats" />

                  <label for="Form-radnoOd">KM restricted</label>
                  <input type="text" id="Form-restriction" class="form-control" v-model="form.kmRestriction" />

                  <label for="Form-radnoOd">KM traveled</label>
                  <input type="text" id="Form-traveled" class="form-control" v-model="form.kmTraveled" />

                   <label for="Form-radnoOd">CDW</label>
                  <input type="checkbox" id="Form-cdw" class="form-control" v-model="form.cdw" />

                  <button
          type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="getImage()">prikazi sliku
          </button> 
          <div>
           <!-- <input type="image" v-model="retrivedImage"/> -->
          <img   :src="retrievedImage">           
          </div>
           
                </div>
              </div>
            </div>
          <div class="row">
          
          </div>
            <!--Body-->

          
       
          </div>
        </div>
      </div>
      <!--/Form with header-->
    </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      form: {
        carClass_id: null,
          carBrand_id: null,
          carModel_id: null,
          fuelType_id: null,
          gearShift_id: null,
          cdw: false,
          kidsSeats: '',
          availableFrom: '',
          availableTo: '',
          city: '',
          kmRestriction: '',
          kmTraveled: null
      },
      retrievedImage: null,
      retriveResponse: null,
      base64Data: null
   
 
            
    };
  },
   
  methods: {
      getImage() {
        axios
      .get("/ads/" + this.$route.params.id + "/image")
      .then(res => {
        console.log("usao uvrati sliku");
        //this.retriveResponse = res;
        console.log(res)
        this.retriveResponse =res;
        this.base64Data = this.retriveResponse.data.pic;
        this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        console.log(this.base64Data)
      })
      .catch(error => {
        console.log(error);
      });

  }
  },
  mounted() {
    console.log("usao");
    axios
      .get("/ads/" + this.$route.params.id + "/ad")
      .then(ad => {
        console.log("usao u then")
        this.form = ad.data;
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

<style>

</style>