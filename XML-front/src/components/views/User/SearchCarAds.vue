<template>
     <div>
    <b-container v-if="error">
      <b-alert show variant="danger" class="d-flex justify-content-center">{{errormessage}}</b-alert>
    </b-container>

     <b-container v-if="success">
      <b-alert show variant="success" class="d-flex justify-content-center">{{successmessages}}</b-alert>
    </b-container>

    <div class="container d-flex justify-content-center" style="margin-top: 20px">
      <!--Form with header-->
      <div class="card" style="width: 60%">
        <!--Header-->
        <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-2 pb-1 mx-5" 
            style="font-size: 2rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Search cars</h3>
          </div>
        </div>
        <!--Header-->

        <div class="form-group">
          <div class="card-body mx-4 mt-4">
            <div v-if="newAd" class="row">
              <div class="col">
                <div class="md-form">

                  <label for="Form-City">City</label>
                  <input type="text" id="Form-carCity" class="form-control" v-model="form.city" />

                  <label for="Form-KidsSeats">Kids Seats</label>
                  <input type="text" id="Form-kidsSeats" class="form-control" v-model="form.kidsSeats" />

                  <label for="Form-Grade">Grade</label>
                  <input type="text" id="Form-grade" class="form-control" v-model="form.grade" />

                  <label for="Form-Price">Price</label>
                  <input type="text" id="Form-price" class="form-control" v-model="form.price" />

                  <label for="Form-KmRestricted">KM restricted</label>
                  <input type="text" id="Form-restriction" class="form-control" v-model="form.kmRestriction" />

                  <label for="Form-KmTraveled">KM traveled</label>
                  <input type="text" id="Form-traveled" class="form-control" v-model="form.kmTraveled" />

                  <label for="Form-CDW">CDW</label>
                  <input type="checkbox" id="Form-cdw" class="form-control" v-model="form.cdw" />

                  

                  
                </div>
              </div>
              <div class="col">
                <div class="md-form pb-3">

                  <label for="Form-DateFrom">Pickup date</label>
                  <input type="date" id="Form-availableFrom" class="form-control" v-model="form.availableFrom" />
                   <label for="Form-DateTo">Leaving date</label>
                  <input type="date" id="Form-availableTo" class="form-control" v-model="form.availableTo" />

                  <label for="Form-carBrand">Car Brand</label>
                  <b-form-select v-model="selectedBrand">
                    <option
                      v-for="brand in brands"
                      :value="brand.id"
                      :key="brand.id"
                    >{{brand.name}}</option>
                  </b-form-select>

                  <label for="Form-CarClass">Car Class</label>
                  <b-form-select v-model="selectedClass">
                    <option
                      v-for="clas in classes"
                      :value="clas.id"
                      :key="clas.id"
                    >{{clas.car_class}}</option>
                  </b-form-select>

                  <label for="Form-CarModel">Car Model</label>
                   <b-form-select v-model="selectedModel">
                    <option
                      v-for="model in models"
                      :value="model.id"
                      :key="model.id"
                    >{{model.model}}</option>
                  </b-form-select>

                  <label for="Form-TypeOfFuel">Type of fuel</label>
                   <b-form-select v-model="selectedFuel">
                    <option
                      v-for="fuel in fuels"
                      :value="fuel.id"
                      :key="fuel.id"
                    >{{fuel.type}}</option>
                  </b-form-select>

                  <label for="Form-TypeOfGearShift">Type of gearshift</label>
                   <b-form-select v-model="selectedGear">
                    <option
                      v-for="gear in gears"
                      :value="gear.id"
                      :key="gear.id"
                    >{{gear.type}}</option>
                  </b-form-select>
           
                </div>
              </div>
            </div>
            <!--Body-->

            <div class="text-center mb-4">
              <br/>
              <button
                type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="searchCars()"
              >Search cars</button>
            </div>


            <!-- <div v-if="newAd" class="text-center mb-4">
              <br/>
              <button
                type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="pretraga()"
              >Proba</button>
            </div> -->

          </div>
        </div>





      
      <div class="header pt-3 grey lighten-2">
        <div class="row d-flex justify-content-start">
          <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Cars</h3>
        </div>
      </div>
      
  


    <div class="form-group" v-for="ad in ads" :key="ad.id">
        <div class="card-body mx-4 mt-4">
          <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Car</h3>
          <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Kids seats</label>
                <label id="Form-ime" class="form-control">{{ad.kidsSeats}}</label>               
              </div>
            </div>
            <!-- </div> -->

            <!-- <div class="row"> -->
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">City</label>
                <label id="Form-ime" class="form-control">{{ad.city}}</label>               
              </div>
            </div>
            </div>

            <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Km restricted</label>
                <label id="Form-ime" class="form-control">{{ad.kmRestriction}}</label>               
              </div>
            </div>
            <!-- </div> -->

            <!-- <div class="row"> -->
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Km traveled</label>
                <label id="Form-ime" class="form-control">{{ad.kmTraveled}}</label>               
              </div>
            </div> 
            </div>

            <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Available from</label>
                <label id="Form-ime" class="form-control">{{ad.showTimeFrom}}</label>               
              </div>
            </div>
            <!-- </div> -->

            <!-- <div class="row"> -->
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Available to</label>
                <label id="Form-ime" class="form-control">{{ad.showTimeTo}}</label>               
              </div>
            </div>
            </div>

            <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">CDW</label>
                <label id="Form-ime" class="form-control">{{ad.cdw}}</label>               
              </div>
            </div>
            <!-- </div> -->

            <!-- <div class="row"> -->
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Car Brand</label>
                <label id="Form-ime" class="form-control">{{ad.carBrand.name}}</label>               
              </div>
            </div>
            </div>

            <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Car Model</label>
                <label id="Form-ime" class="form-control">{{ad.carModel.model}}</label>               
              </div>
            </div>
            <!-- </div> -->
          

          <!-- <div class="row"> -->
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Car Class</label>
                <label id="Form-ime" class="form-control">{{ad.carClass.car_class}}</label>               
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Fuel type</label>
                <label id="Form-ime" class="form-control">{{ad.fuelType.type}}</label>               
              </div>
            </div>
          <!-- </div> -->

          <!-- <div class="row"> -->
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Gear shift type</label>
                <label id="Form-ime" class="form-control">{{ad.gearShiftType.type}}</label>               
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Grade</label>
                <label id="Form-ime" class="form-control">{{ad.grade}}</label>               
              </div>
            </div>
          <!-- </div> -->

          <!-- <div class="row"> -->
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Price</label>
                <label id="Form-ime" class="form-control">{{ad.price}}</label>               
              </div>
            </div>
          </div>
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
        form: {
          carClass: '',
          carBrand: '',
          carModel: '',
          fuelType: '',
          gearShiftType: '',
          cdw: null,
          kidsSeats: '',
          grade: '',
          price: '',
          availableFrom: '',
          availableTo: '',
          city: '',
          kmRestriction: '',
          kmTraveled: ''

        },
        selectedFile: null,
        show: true,
          error: false,
      errormessage: "",
      success: false,
      successmessages: "",
      newAd: true,
      changeButton: false,
      selectedBrand: "",
       brands: [],
      selectedClass: "",
       classes: [],
      selectedModel: "",
       models: [],
      selectedFuel: "",
       fuels: [],
       selectedGear: "",
       gears: [],
       idAd: null,
       ads: [],
       showTimeFrom : "",
       showTimeTo : "",
       brandNull: {
         name : "Null",
         label : "labela"
       },
       classNull : {
         car_class : "Null"
       },
       modelNull: {
         model : "Null"
       },
       fuelTypeNull : {
         type : "Null"
       },
       gearShiftTypeNull : {
         type : "Null"
       },
       loggedUser: ""
      
      }
    },
    methods: {
        
        
        searchCars() {
          this.error = false;
          this.error = "";

          if(this.form.city === "" || this.form.availableFrom === "" || this.form.availableTo === "") {
            this.error = true;
            this.errormessage = "You have to fill at least the city and the dates!"
            return;
          }



          this.brands.forEach(brand => {
          if (brand.id === this.selectedBrand) {
          console.log("baki homos")
          this.form.carBrand = brand;
          }
          if(this.form.carBrand === "") {
            this.form.carBrand = this.brandNull;
          }
          });

          this.classes.forEach(clas => {
          if (clas.id === this.selectedClass) {
          this.form.carClass = clas;
          }
          if(this.form.carClass === "") {
            this.form.carClass = this.classNull;
          }
          });
          this.models.forEach(model => {
          if (model.id === this.selectedModel) {
          this.form.carModel = model;
          }
          if(this.form.carModel === "") {
            this.form.carModel = this.modelNull;
          }
          });
          this.fuels.forEach(fuel => {
          if (fuel.id === this.selectedFuel) {
          this.form.fuelType = fuel;
          }
          if(this.form.fuelType === "") {
            this.form.fuelType = this.fuelTypeNull;
          }
          });
          this.gears.forEach(gear => {
          if (gear.id === this.selectedGear) {
          this.form.gearShiftType = gear;
          }
          if(this.form.gearShiftType === "") {
            this.form.gearShiftType = this.gearShiftTypeNull;
          }
          });


      axios
      .post("/search/ad",this.form)
      .then(ads => {
        this.ads = ads.data
        //this.error = false;
        this.ads.forEach(ad => {
          this.showTimeFrom = new String(new Date(ad.availableFrom - 86400000).getDate() + "/" + new Date(ad.availableFrom + 2592000000).getMonth() + "/" + new Date(ad.availableFrom).getFullYear());
          ad.showTimeFrom = this.showTimeFrom;
          this.showTimeTo = new String(new Date(ad.availableTo - 86400000).getDate() + "/" + new Date(ad.availableTo + 2592000000).getMonth() + "/" + new Date(ad.availableTo).getFullYear());
          ad.showTimeTo = this.showTimeTo;
        })

      })
      .catch(error => {
        console.log(error);
        //this.errormessage = "Mail vec postoji";
        //this.error = true;
      });

        },

        // pretraga() {

        // axios
        // .post("/search/addad" , this.form)
        // .then(form => {
        //   this.error = form,
        //   this.idAd = form.data.id,
        //   console.log(this.idAd);
        //   this.form.kidsSeats = "",
        //    this.success = true,
        //     this.successmessages = "You have succesfully added a new car ad. Now you can upload images for the car."
        //     this.changeButton = true;
        //     this.newAd = false;

        //   this.error = false;
          
        // })
        // .catch(error => {
        //   console.log(error);
        //   this.errormessage = "Mail vec postoji";
        //   this.error = true;
        // });

           
        // }

    }
    ,
    mounted() {
    axios
      .get("/search/brands")
      .then(brands => {
        this.brands = brands.data;
      })
      .catch(error => {
        console.log(error);
      });

        axios
        .get("/search/classes")
        .then(classes => {
          this.classes = classes.data;
        })
        .catch(error => {
          console.log(error);
        });

      axios
      .get("/search/models")
      .then(models => {
        this.models = models.data;
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .get("/search/fuel-types")
      .then(fuels => {
        this.fuels = fuels.data;
      })
      .catch(error => {
        console.log(error);
      });

       axios
      .get("/search/gearshift-types")
      .then(gears => {
        this.gears = gears.data;
      })
      .catch(error => {
        console.log(error);
      });
      
  }
}
</script>

<style>

</style>