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
            <div v-if="newAd" class="row">
              <div class="col">
                <div class="md-form">
                  <label for="Form-carBrand">Car Brand</label>
                  <input type="text" id="Form-carBrand" class="form-control" v-model="form.carBrand" />

                  <label for="Form-phone">Car Class</label>
                  <input type="text" id="Form-carClass" class="form-control" v-model="form.carClass" />

                  <label for="Form-email">Car Model</label>
                  <input type="text" id="Form-carModel" class="form-control" v-model="form.carModel" />

                  <label for="Form-adresa">City</label>
                  <input type="text" id="Form-carCity" class="form-control" v-model="form.city" />

                  <label for="Form-radnoDo">Available From</label>
                  <input type="date" id="Form-availableFrom" class="form-control" v-model="form.availableFrom" />
                   <label for="Form-radnoDo">Available To</label>
                  <input type="date" id="Form-availableTo" class="form-control" v-model="form.availableTo" />
                </div>
              </div>
              <div class="col">
                <div class="md-form pb-3">
                  <label for="Form-grad">Type of fuel</label>
                  <input type="text" id="Form-fuel" class="form-control" v-model="form.fuelType" />

                  <label for="Form-država">Type of gearshift</label>
                  <input type="text" id="Form-gearshift" class="form-control" v-model="form.typeOfGearshift" />

                  <label for="Form-br">Kids Seats</label>
                  <input type="text" id="Form-kidsSeats" class="form-control" v-model="form.kidsSeats" />

                  <label for="Form-radnoOd">KM restricted</label>
                  <input type="text" id="Form-restriction" class="form-control" v-model="form.kmRestriction" />

                  <label for="Form-radnoOd">KM traveled</label>
                  <input type="text" id="Form-traveled" class="form-control" v-model="form.traveled" />

                   <label for="Form-radnoOd">CDW</label>
                  <input type="checkbox" id="Form-cdw" class="form-control" v-model="form.cdw" />

               <!--   <label for="Form-klinika">Tipovi pregleda</label>
                  <b-form-select v-model="selektovaniTip">
                    <option
                      v-for="tip in tipoviPregleda"
                      :value="tip.id"
                      :key="tip.id"
                    >{{tip.naziv}}</option>
                  </b-form-select> -->
                </div>
              </div>
            </div>
            <!--Body-->

            <div v-if="newAd" class="text-center mb-4">
              <br/>
              <button
                type="button"
                class="btn btn-info btn-block z-depth-2"
              
              >Add Car</button>
            </div>
          <div v-if="changeButton" >
              <input style="display:none" ref="fileInput" type="file" @change="onFileSelected()"/>
              <button type="button"
                class="btn btn-info btn-block z-depth-2" @click="$refs.fileInput.click()">Choose image</button>
              <button type="button"
                class="btn btn-outline-info btn-block z-depth-2" @click="uploadImages()">Upload Image</button>
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
          typeOfGearshift: '',
          cdw: false,
          kidsSeats: '',
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
      changeButton: false
      }
    },
    methods: {
        onFileSelected(event){
            this.selectedFile = event.target.files[0];
        },
        uploadImages() {
            this.success = false;
            this.newAd = true;
            this.changeButton = false;
        },
        newCar() {
           axios
        .post("/ads/ads" , this.form)
        .then(form => {
          this.error = form,
          this.idAd = form.data.id,
          console.log(this.idAd);
          this.form.kidsSeats = "",
           this.success = true,
            this.successmessages = "You have succesfully added a new car ad. Now you can upload images for the car."
            this.changeButton = true;
            this.newAd = false;

          this.error = false;
          
        })
        .catch(error => {
          console.log(error);
          this.errormessage = "Mail vec postoji";
          this.error = true;
        });

        }
    }
}
</script>

<style>

</style>