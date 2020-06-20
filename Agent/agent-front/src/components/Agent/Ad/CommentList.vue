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
      <!--Header-->




<b-container>
         <div>
    <b-table class="mt-2 mb-2" striped hover :items="comments" select-mode="single" :fields="fields" caption-top >
    </b-table>
  </div>
</b-container>
  


    

      
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
        {
          key: 'comment'},
        ]
    };
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