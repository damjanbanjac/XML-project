<template>
    <div>
        <b-table table-variant="light" head-variant="dark" small="true" bordered="true" responsive="sm" stickyHeader="1000px" hover :items="items" :fields="fields">
            <template v-slot:cell(actions1)="row">
                <b-button variant="success" size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1">
                Approve
                </b-button>
                <b-button variant="danger" size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1">
                Deny
                </b-button>
            </template>
        </b-table>
    <div>
      <b-form>
        <label>name</label>
        <input v-model="brand.name"/>
        <button @click="dodajBrand()">dodaj brand</button>
      </b-form>
       <b-form>
        <label>class</label>
        <input v-model="clas.car_class"/>
        <button @click="dodajClass()"> dodaj class</button>
      </b-form>
       <b-form>
        <label>model</label>
        <input v-model="model.model"/>
        <button @click="dodajModel()">dodaj model</button>
      </b-form>
       <b-form>
        <label>fuel</label>
        <input v-model="fuel.type"/>
        <button @click="dodajFuel()">dodaj fuel</button>
      </b-form>
       <b-form>
        <label>Gearshift</label>
        <input v-model="gear.type"/>
        <button @click="dodajGearshift()">dodaj gear</button>
      </b-form>

    </div>
    </div>
</template>

<script>
import axios from "axios";
  export default {
    data() {
      return {
        brand: {
          name: ""
        },
         clas: {
          car_class: ""
        },
         model: {
          model: ""
        },
         fuel: {
          type: ""
        },
         gear: {
          type: ""
        },
        fields: [
          {
            key: 'Firstname',
            sortable: true
          },
          {
            key: 'Lastname',
            sortable: true
          },
          { key: 'actions1', label: 'Activation' }
        ],
        items: [
            { Firstname: 'Lara', Lastname: 'Mimica'},
            
        ],
        error: ""
      }
    },
    methods: {

      dodajBrand() {
        axios
        .post(
          "/brands" ,
          this.brand
        )

        .then(error => {
          this.error = error;
         
        })
        
    },
    dodajClass() {
        axios
        .post(
          "/classes" ,
          this.clas
        )

        .then(error => {
          this.error = error;
         
        })
        
    },
    dodajModel() {
        axios
        .post(
          "/models" ,
          this.model
        )

        .then(error => {
          this.error = error;
         
        })
        
    },
    dodajFuel() {
        axios
        .post(
          "/fuel-types" ,
          this.fuel
        )

        .then(error => {
          this.error = error;
         
        })
        
    },
    dodajGearshift() {
        axios
        .post(
          "/gearshift-types" ,
          this.gear
        )

        .then(error => {
          this.error = error;
         
        })
        
    }
    }
    
  }
</script>

<style>
    .table {
        width: 40%;
        margin-top: 2%;
    }
</style>