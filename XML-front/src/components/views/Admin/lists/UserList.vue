<template>
    <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 40%">
      
        <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5"
                style="font-size: 3rem;
                font-weight: 300;
                line-height: 1.2;
                margin-top: -12%;">Clients</h3>
            </div>
        </div>

        <div class="form-group" v-for="client in clients" :key="client.id">
            <div class="card-body mx-4 mt-4">
                <div class="row">
                    <div class="col">
                        <div class="md-form">
                            <label for="Form-email">Email</label>
                            <label id="Form-email" class="form-control">{{client.email}}</label>

                            <label for="Form-name">Name</label>
                            <label id="Form-name" class="form-control">{{client.name}}</label>

                            <label for="Form-surname">Surname</label>
                            <label id="Form-surname" class="form-control">{{client.surname}}</label>

                            <label for="Form-surname">Current status</label>
                            <div v-if="client.blocked">
                              <label>Blocked</label>
                            </div>
                            <div v-else>
                              <label>Active</label>
                            </div>

                            <br/>

                            <div v-if="!client.blocked" class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-danger btn-block z-depth-2"
                                @click="block(client.id)"
                                >Block</button>
                            </div>
                            
                            <div v-if="client.blocked" class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-secondary btn-block z-depth-2"
                                @click="unblock(client.id)"
                                >Unblock</button>
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
        clients: []
      }
    },
    methods: {

      block(id) {

        axios
        .put("auth/admins/block/" + id + "/user")
        .then(()=>{
            window.location.reload();
        })
        .catch(error => {
          console.log(error);
        }); 
    },

    unblock(id) {

        axios
        .put("auth/admins/unblock/" + id + "/user")
        .then(()=>{
            window.location.reload();
        })
        .catch(error => {
          console.log(error);
        }); 
    },

    },
    mounted() {
    axios
      .get("auth/admins/approved-registrations")
      .then(clients => {
        this.clients = clients.data;
        
      })
      .catch(error => {
        console.log(error);
      });
  }
    
  }
</script>

<style>
    .table {
        width: 40%;
        margin-top: 2%;
    }
</style>