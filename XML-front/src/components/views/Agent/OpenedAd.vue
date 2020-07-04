<template>
    <div class="container d-flex justify-content-left" style="margin-top: 20px">
      <!--Form with header-->
      <div class="row">
        <div class="col" style="margin-right:30%">
      <div class="card" style="width: 190%">
        <!--Header-->
        <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-2 pb-1 mx-5" 
            style="font-size: 2rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Car</h3>
          </div>
        </div>
        <!--Header-->

        <div class="form-group">
          <div class="card-body mx-4 mt-2">
            <div  class="row">
              <div class="col">
                <div class="md-form">
                  <label for="Form-carBrand">Car Brand</label>
                   <input type="text" id="Form-carBrand" class="form-control" v-model="form.carBrand_id.name" disabled />

                  <label for="Form-phone">Car Class</label>
                    <input type="text" id="Form-carClass" class="form-control" v-model="form.carClass_id.car_class" disabled />

                  <label for="Form-email">Car Model</label>
                    <input type="text" id="Form-carModel" class="form-control" v-model="form.carModel_id.model" disabled />

                  <label for="Form-adresa">City</label>
                  <input type="text" id="Form-carCity" class="form-control" v-model="form.city" disabled />

                  <label for="Form-radnoDo">Available From</label>
                  <input type="date" id="Form-availableFrom" class="form-control" v-model="form.availableFrom" :disabled="!change" />
                   <label for="Form-radnoDo">Available To</label>
                  <input type="date" id="Form-availableTo" class="form-control" v-model="form.availableTo" :disabled="!change" >

                  <label>Average grade</label>
            <br/>
            <input type="text" id="Form-grade" class="form-control" v-model="avg.avgGrade" disabled/>

                  <button type="button" class="btn btn-info mt-4 btn-block z-depth-2" @click="showPricelist" >Pricelist</button>
                    
                     <template v-if="pricelist">
                    <label for="">Price for workdays</label>
                  <input type="text" id="Form-availableFrom" class="form-control" v-model="price.priceForWorkDay" disabled />
                   <label for="">Price for weekday</label>
                  <input type="text" id="Form-availableFrom" class="form-control" v-model="price.priceForWeekend" disabled />
                    </template>
                
                 
            <br/>
            
                </div>  
              </div>
              <div class="col">
                <div class="md-form pb-3">
                  <label for="Form-grad">Type of fuel</label>
                    <input type="text" id="Form-carFuelType" class="form-control" v-model="form.fuelType_id.type" disabled />
                  

                  <label for="Form-država">Type of gearshift</label>
                    <input type="text" id="Form-carGearshiftType" class="form-control" v-model="form.gearShift_id.type" disabled />

                  <label for="Form-br">Kids Seats</label>
                  <input type="text" id="Form-kidsSeats" class="form-control" v-model="form.kidsSeats" :disabled="!change" />

                  <label for="Form-radnoOd">KM restricted</label>
                  <input type="text" id="Form-restriction" class="form-control" v-model="form.kmRestriction" :disabled="!change" />

                  <label for="Form-radnoOd">KM traveled</label>
                  <input type="text" id="Form-traveled" class="form-control" v-model="form.kmTraveled" :disabled="!change" />

                   <label for="Form-radnoOd">CDW</label>
                  <input type="checkbox" id="Form-cdw" class="form-control" v-model="form.cdw" :disabled="!change" />
                  <br/>

                    <template v-if="!change">
            <button type="button" class="btn btn-danger btn-block z-depth-2" @click="changeClick" >Change data</button>
            </template>
            <template v-else>
            <button type="button" class="btn btn-success btn-block z-depth-2" @click ="saveData" >Save</button>
            
            </template>
               <button
            type="button"
                  class="btn btn-info btn-block mt-4 z-depth-2"
                  @click="seeComments()">See comments
            </button>
             <template v-if="pricelist">
                    <label for="form-radnoOd">Price for workdays</label>
                  <input type="text" id="Form-availableFrom" class="form-control" v-model="price.priceForKmRestriction" disabled />
                   <label for="">Price for weekday</label>
                  <input type="text" id="Form-availableFrom" class="form-control" v-model="price.priceForCDW" disabled />
                    </template>
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
        <div class="card" style="width: 200%">
        <!--Header-->
        <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
            style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Gallery</h3>
          </div>
        </div>

        <div class="card-body mx-4 mt-4">
           <button
          type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="getImage()">Gallery
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

<!-- kom i ocene -->
 <!--     <div class="col">
        <b-container v-if="success">
          <b-alert show variant="success" class="d-flex justify-content-center">{{successmessages}}</b-alert>
        </b-container>
        <div class="card" style="width: 46%; margin: -325px 1px 1px 683px;">
          Header-->
    <!--      <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
              <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
              style="font-size: 3rem;
              font-weight: 300;
              line-height: 1.2;
              margin-top: -12%;">Feedback insight</h3>
            </div>
          </div>

          <div class="card-body mx-4 mt-4">
            
            <br/>
            <button
            type="button"
                  class="btn btn-info btn-block z-depth-2"
                  @click="seeComments()">See comments
            </button>
            <br/>
            <label>Average grade</label>
            <br/>
            <input type="text" id="Form-grade" class="form-control" v-model="avg.avgGrade" disabled/>

          </div>
        </div>
      </div> -->
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
        price: {
          name : '',
          priceForWorkend: '',
          priceForWeekday: '',
          priceForKmRestriction: '',
          priceForCDW: ''
      },
      pricelist: false,
      retrievedImage: null,
      retriveResponse: [],
      base64Data: null,
      selectedFile: null,
      error: '',
      success: false,
      successmessages: "",
      change: false,
      idAd: "",
      avg: null,
    };
  },
   
  methods: {

    seeComments() {

      this.$router.push("/commentList/" + this.$route.params.id);
      
    },

    saveData() {
     
      axios
      .put("ads/ads/" + this.$route.params.id + "/ad" , this.form)
      .then(user =>{
        this.form = user.data;
        this.change = false;
      })
      .catch(error => {
          console.log(error)
      });
    },
    
    changeClick() {
      this.change = true
    },
      
       showPricelist() {
      this.pricelist = true;

        axios
      .get("ads/pricelist/" + this.$route.params.id + "/ad")
      .then(ad => {
        
            console.log("usao u then")
        console.log(ad.data)
        this.price = ad.data;
        
      
      })
      .catch(error => {
        console.log(error);
      });
    },

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
      this.successmessages = "Your image is succesfully added.";
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
      this.successmessages = "Your image has succesfully been uploaded, reload the gallery";
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

        axios
        .get("ads/grades/avg-grade/" + this.$route.params.id + "/ad-car")
        .then(response => {
          this.avg = response.data;
        })
        .catch(error => {
          console.log(error);
          this.error = true;
        });
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

<style>

</style>