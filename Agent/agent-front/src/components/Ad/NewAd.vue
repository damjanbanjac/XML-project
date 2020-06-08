<template>
 <div>
     <b-container class="d-flex justify-content-center">
         <b-card class="card"
            border-variant="primary"
            header="Create ad"
            header-bg-variant="primary"
            header-text-variant="white"
            align="center"
        >
        <div class="form-group">
          <div class="card-body">

            <b-container class="form" fluid>

              <b-row class="my-3">
                <b-col sm="12">
                  <label>Brand of car</label>
                  <b-form-input placeholder="Enter brand" type="text"></b-form-input>
                </b-col>
              </b-row>

              <b-row class="my-3">
                <b-col sm="12">
                  <label class="left">Car model</label>
                  <b-form-input placeholder="Enter model" type="email"></b-form-input>
                </b-col>
              </b-row>

              <b-row class="my-3">
                <b-col sm="12">
                    <label>Fuel</label>
                    <div>
                        <b-form-select style="margin-left:1%">
                        <option v-for="gorivo in goriva" :value="gorivo.name"
                        :key="gorivo.name">{{gorivo.name}}
                    </option>
                    </b-form-select>
                    </div>
                </b-col>
              </b-row>

              <b-row class="my-3">
                <b-col sm="12">
                    <label>Type of gearbox</label>
                    <div>
                        <b-form-select style="margin-left:1%">
                        <option v-for="menjac in menjaci" :value="menjac.name"
                        :key="menjac.name">{{menjac.name}}
                    </option>
                    </b-form-select>
                    </div>
                </b-col>
              </b-row>

              <b-row class="my-3">
                <b-col sm="12">
                    <label>Car class</label>
                    <div>
                        <b-form-select style="margin-left:1%">
                        <option v-for="menjac in menjaci" :value="menjac.name"
                        :key="menjac.name">{{menjac.name}}
                    </option>
                    </b-form-select>
                    </div>
                </b-col>
              </b-row>

              <b-row class="my-3">
                <b-col sm="12">
                  <label class="center">Price</label>
                  <b-form-input placeholder="Enter a price" type="text"></b-form-input>
                </b-col>
              </b-row>

              <b-row class="my-3">
                <b-col sm="12">
                  <label class="center">Mileage allowed</label>
                  <b-form-input placeholder="Enter the allowable mileage" type="text"></b-form-input>
                </b-col>
              </b-row>

              <b-row class="my-3">
                <b-col sm="12">
                  <label class="typo__label">Collision Damage Waiver?</label>
                    <input type="checkbox" v-model="check" style="mx-4; margin-left: 1%">
                </b-col>
              </b-row>

              <b-row class="my-3">
                <b-col sm="12">
                  <label class="center">Number of seats for children</label>
                  <b-form-input placeholder="Enter the number of seats for children" type="text"></b-form-input>
                </b-col>
              </b-row>

                <b-row class="my-3">
                <b-col sm="12">
                  <div>
                    <b-img src="https://picsum.photos/1024/400/?image=41" fluid alt="Responsive image"></b-img>
                    </div>
                </b-col>
              </b-row>
            
              <br/>

              <div>
                <button type="submit" class="btn btn-primary">Create</button>
              </div>
              </b-container>
            </div>
        </div>
         </b-card>
     </b-container>


 </div>
</template>

<script>
export default {
    data () {
    return {
        check: false,
        goriva: [
        {name: 'Petrol'},
        {name: 'Diesel'},
        {name: 'Electric'},
    ],
    menjaci: [
        {name: 'Automatic'},
        {name: 'Manual'},
        {name: 'Semi automatic '},
    ],
    klase: [
        {name: 'Hatchback'},
        {name: 'Sedan'},
        {name: 'SUV'},
    ],
        }
    }

}
</script>

<style>

.card {
  margin: auto;
  width: 60%;
}

.form {
  width: 500px;
}

</style>