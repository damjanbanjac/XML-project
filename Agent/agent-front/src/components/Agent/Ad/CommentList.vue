<template>
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    <!--Form with header-->
    <div class="card" style="width: 60%">
      <!--Header-->
      <div class="header pt-3 grey lighten-2">
        <div class="row d-flex justify-content-start">
          <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Comments</h3>
        </div>
      </div>

      <!-- Table -->
      <b-container>
              <div>
          <b-table class="mt-2 mb-2" striped hover :items="comments" select-mode="single" :fields="fields" caption-top >
          </b-table>
        </div>
      </b-container>
    </div>

    <!-- Comment -->
    <div class="col">

        <b-container v-if="success">
          <b-alert style="width: 100%;" show variant="success" class="d-flex justify-content-center">{{successmessages}}</b-alert>
        </b-container>

        <div class="card" style="width: 96%;">
          <!--Header-->
          <div class="header pt-3 grey lighten-2">
            <div class="row d-flex justify-content-start">
              <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
              style="font-size: 2rem;
              font-weight: 300;
              line-height: 1.2;
              margin-top: -12%;">Send feedback</h3>
            </div>
          </div>

          <div class="card-body mx-4 mt-4">
            <label for="Form-text">Comment</label>
            <input type="text" id="Form-text" class="form-control" v-model="comm" />
            <br/>
            <button
            type="button"
                  class="btn btn-info btn-block z-depth-2"
                  @click="comment()">Comment
            </button> 
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
      comments: [],
      fields: [
        {key: 'comment',
        label: 'Comment'},
      ],
      comm: '',
      error: '',
      success: false,
      successmessages: "",
    };
  },

  methods: {
    comment() {
      const body = {
        comment: this.comm,
        adCarId: this.$route.params.id
      }
      axios
        .post("/comments", body)
        .then(() => {
          this.comm = "";
          this.success = true;
          this.successmessages = "You have successfully commented this car ad.";
        })
        .catch(error => {
          console.log(error);
          this.error = true;
        });
    }
  },
   
  mounted() {
    axios
      .get("/comments/" + this.$route.params.id + "/ad-car")
      .then(comments => {
        this.comments = comments.data;
        console.log(comments)
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

<style>
</style>