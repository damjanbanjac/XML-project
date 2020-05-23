<template>
<div>
    <b-jumbotron bg-variant="light" text-variant="dark" style="width: 510px;
    height: 740px;
    margin-top: 2%;
    margin-left: 3%;">
        <template>
            <h2 style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-bottom: 2rem;
            margin-left: 6%">Create pricelist</h2>
        </template>

        <template>
            <b-form bg-variant="light" @submit="onSubmit">

                <b-form-group id="input-group-3" label="Ads:" label-for="input-3">
                    <div class="row">
                        <div>
                            <div style="margin-left: 6%; margin-top:-8%; width:315px">
                                <br>
                                <ejs-multiselect :dataSource='oglasi'
                                :fields='localFields' placeholder="Select an ad" v-model="form.ads">
                                </ejs-multiselect>
                            </div>
                        </div>
                    </div>
                </b-form-group>
                <b-form-group
                    id="input-group-1"
                    label="Workdays price:"
                    label-for="input-1"
                >
                    <b-form-input
                    id="input-1"
                    v-model="form.workdaysPrice"
                    type="number"
                    required
                    placeholder="Enter workday price"
                    ></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Weekend price:" label-for="input-2">
                    <b-form-input
                    id="input-2"
                    v-model="form.weekendPrice"
                    required
                    type="number"
                    placeholder="Enter weekend price"
                    ></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label-for="input-4" v-for="oglas in oglasi" :value="oglas.id" :key="oglas.id">
                    <div v-if="oglas.kmLimit && form.ads.includes(oglas.id)">    
                        <div class="lbl">Price per kilometer for {{ oglas.name }}:</div>
                        <b-form-input
                        id="input-4"
                        v-model="form.pricePerKm"
                        required
                        placeholder="Enter price per kilometer"
                        type="number"
                        v-if="oglas.kmLimit"
                        ></b-form-input>
                    </div>
                </b-form-group>

                <b-form-group id="input-group-5" label-for="input-5" v-for="oglas in oglasi" :value="oglas.id" :key="oglas.id">
                    <div v-if="oglas.CollisionDamageWaiver && form.ads.includes(oglas.id)">
                        <div class="lbl">Collision Damage Waiver price for {{ oglas.name }}:</div>
                        <b-form-input
                        id="input-5"
                        v-model="form.priceCDW"
                        required
                        placeholder="Enter Collision Damage Waiver price"
                        type="number"
                        v-if="oglas.CollisionDamageWaiver"
                        ></b-form-input>
                    </div>
                </b-form-group>

                <b-form-group>
                    <b-button type="submit" variant="primary" @click="onSubmit()">Create pricelist</b-button>
                </b-form-group>

            </b-form>

        </template>
    </b-jumbotron>
</div>
</template>

<script>
import Vue from 'vue';
import { MultiSelectPlugin } from '@syncfusion/ej2-vue-dropdowns';
Vue.use(MultiSelectPlugin);
  export default {
    name: 'PriceList',
    data() {
      return {
        form: {
          workdaysPrice: '',
          weekendPrice: '',
          ads: '',
          pricePerKm: '',
          priceCDW: '',
        },
        show: true,
        oglasi: [
            {
                id: 1,
                name: 'PrviOglas',
                kmLimit: true,
                CollisionDamageWaiver: false
            },
            {
                id: 2,
                name: 'DrugiOglas',
                kmLimit: true,
                CollisionDamageWaiver: true
            },
            {
                id: 3,
                name: 'TreciOglas',
                kmLimit: false,
                CollisionDamageWaiver: true
            }

        ],
        arr : ['Gavin', 'Richard', 'Erlich', 'Gilfoyle'],

        localFields: { value: 'id', text: 'name' }
      }
    },
    methods: {
        onSubmit() {}
    }
}
</script>

<style>

 .jumbotron {
    padding: 2rem 2rem;
    margin-bottom: 2rem;
} 

.lbl {
    margin-bottom: 12px;
}

@import url(https://cdn.syncfusion.com/ej2/material.css);

</style>