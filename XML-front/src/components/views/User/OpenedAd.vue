<template>
    <div class="container d-flex justify-content-left" style="margin-top: 20px">
      <!--Form with header-->
      <div class="row">
        <div class="col" style="margin-right:20%">
      <div class="card" style="width: 150%">
        <!--Header-->
        <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
            style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Car</h3>
          </div>
        </div>
        <!--Header-->

        <div class="form-group">
          <div class="card-body mx-4 mt-4">
            <div  class="row">
              <div class="col">
                <div class="md-form">
                  <label for="Form-carBrand">Car Brand</label>
                   <input type="text" id="Form-carCity" class="form-control" v-model="form.carBrand_id.name" />

                  <label for="Form-phone">Car Class</label>
                    <input type="text" id="Form-carCity" class="form-control" v-model="form.carClass_id.car_class" />

                  <label for="Form-email">Car Model</label>
                    <input type="text" id="Form-carCity" class="form-control" v-model="form.carModel_id.model" />

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
                    <input type="text" id="Form-carCity" class="form-control" v-model="form.fuelType_id.type" />
                  

                  <label for="Form-država">Type of gearshift</label>
                    <input type="text" id="Form-carCity" class="form-control" v-model="form.gearShift_id.type" />

                  <label for="Form-br">Kids Seats</label>
                  <input type="text" id="Form-kidsSeats" class="form-control" v-model="form.kidsSeats" />

                  <label for="Form-radnoOd">KM restricted</label>
                  <input type="text" id="Form-restriction" class="form-control" v-model="form.kmRestriction" />

                  <label for="Form-radnoOd">KM traveled</label>
                  <input type="text" id="Form-traveled" class="form-control" v-model="form.kmTraveled" />

                   <label for="Form-radnoOd">CDW</label>
                  <input type="checkbox" id="Form-cdw" class="form-control" v-model="form.cdw" />

            <!--      <button
          type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="getImage()">prikazi sliku
          </button> 
          <div>
           
          <img   :src="retrievedImage">           
          </div> -->
           
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
      <div class="col">
        <b-container v-if="success">
      <b-alert show variant="success" class="d-flex justify-content-center">{{successmessages}}</b-alert>
    </b-container>
        <div class="card" style="width: 120%">
        <!--Header-->
        <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
            style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Galary</h3>
          </div>
        </div>
        <div class="card-body mx-4 mt-4">
           <button
          type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="getImage()">gallary
          </button> 
            <input style="display:none" ref="fileInput" type="file" @change="onFileSelected($event)"/>
              <button type="button"
                class="btn btn-info btn-block z-depth-2 mt-2" @click="$refs.fileInput.click()">Choose image</button>
              <button type="button"
                class="btn btn-outline-info btn-block z-depth-2"  @click="uploadImages()">Upload Image</button>
          <div>
           <!-- <input type="image" v-model="retrivedImage"/> -->
          <b-img  width="300" height="180" v-for="res in retriveResponse" :key="res.id" :src=" 'data:image/jpeg;base64,' + res.pic">  </b-img>         
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
      form: {
        carClass_id: {},
          carBrand_id: {},
          carModel_id: {},
          fuelType_id: {},
          gearShift_id: {},
          cdw: false,
          kidsSeats: '',
          availableFrom: '',
          availableTo: '',
          city: '',
          kmRestriction: '',
          kmTraveled: null
      },
      retrievedImage: null,
      retriveResponse: [],
      base64Data: null,
        selectedFile: null,
        error: '',
         success: false,
      successmessages: "",
   
 
            
    };
  },
   
  methods: {
      getImage() {
        axios
      .get("ads/ads/" + this.$route.params.id + "/image")
      .then(res => {
        console.log("usao uvrati sliku");
        //this.retriveResponse = res;
        console.log(res)
        this.retriveResponse =res.data;
      //  this.base64Data = this.retriveResponse.data.pic;
       // this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        //console.log(this.base64Data)
      })
      .catch(error => {
        console.log(error);
      });

  },
   onFileSelected(event){
            console.log(event);
            this.selectedFile = event.target.files[0];
            this.success = true;
            this.successmessages = "your image is succesfully added";
        },
        uploadImages() {
          console.log("u uploadu");
          const uploadImageData = new FormData();
          uploadImageData.append('imageFile', this.selectedFile,this.selectedFile.name);
         // var idAdCar = 5;
        axios
        .post("ads/images/" + this.$route.params.id + "/Ad",uploadImageData)
        .then(form => {
          this.error = form;
         this.success = false;
         this.success = true;
            this.successmessages = "your image is succesfully upload, reload the gallary";
            
         
        })
        .catch(error => {
          console.log(error);
         


          
        });

          
        },
  },
  mounted() {
    console.log("usao");
    axios
      .get("ads/ads/" + this.$route.params.id + "/ad")
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