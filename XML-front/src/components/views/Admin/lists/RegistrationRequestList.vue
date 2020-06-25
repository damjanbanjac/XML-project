<template>
    <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 40%">
      
        <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5"
                style="font-size: 3rem;
                font-weight: 300;
                line-height: 1.2;
                margin-top: -12%;">User registration requests</h3>
            </div>
        </div>

        <div class="form-group" v-for="request in requests" :key="request.id">
            <div class="card-body mx-4 mt-4">
                <div class="row">
                    <div class="col">
                        <div class="md-form">
                            <label for="Form-email">Email</label>
                            <label id="Form-email" class="form-control">{{request.email}}</label>

                            <label for="Form-name">Name</label>
                            <label id="Form-name" class="form-control">{{request.name}}</label>

                            <label for="Form-surname">Surname</label>
                            <label id="Form-surname" class="form-control">{{request.surname}}</label>

                            <br/>

                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-success btn-block z-depth-2"
                                @click="approve(request.id)"
                                >Approve</button>
                            </div>
                            
                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-danger btn-block z-depth-2"
                                @click="deny(request.id)"
                                >Deny</button>
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
        requests: []
      }
    },
    methods: {

      approve(id) {

        const body = {
            id: id
        }

        axios
        .post("auth/admins/approve-registration", body)
        .then(()=>{
            window.location.reload();
        })
        .catch(error => {
          console.log(error);
        }); 
    },

    deny(id) {

        const body = {
            id: id
        }

        axios
        .post("auth/admins/deny-registration", body)
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
      .get("auth/admins/pending-registrations")
      .then(requests => {
        this.requests = requests.data;
        
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