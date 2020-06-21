<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    
    <div class="card" style="width: 40%">
      
        <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
                <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5"
                style="font-size: 3rem;
                font-weight: 300;
                line-height: 1.2;
                margin-top: -12%;">Comment requests</h3>
            </div>
        </div>

        <div class="form-group" v-for="comment in comments" :key="comment.commId">
            <div class="card-body mx-4 mt-4">
                <div class="row">
                    <div class="col">
                        <div class="md-form">
                            <label for="Form-name">Comment</label>
                            <label id="Form-name" class="form-control">{{comment.comment}}</label>

                            <br/>

                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-success btn-block z-depth-2"
                                @click="approveComment(comment.commId)"
                                >Approve</button>
                            </div>
                            
                            <div class="text-center mb-4">
                                <button
                                type="button"
                                class="btn btn-danger btn-block z-depth-2"
                                @click="denyComment(comment.commId)"
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
      comments: []
    };
  },
  methods: {

    approveComment(commId) {

        axios
        .put("/admins/approve/"+ commId +"/comment")
        .then(()=>{
            window.location.reload();
        })
        .catch(error => {
          console.log(error);
        }); 
    },

    denyComment(id) {

        const body = {
            id: id
        }

        axios
        .put("/admins/deny/comment", body)
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
      .get("/admins/pending-comments")
      .then(comments => {
        this.comments = comments.data;
        console.log(comments)
      })
      .catch(error => {
        console.log(error);
      });
  }
}


</script>

<style>

</style>