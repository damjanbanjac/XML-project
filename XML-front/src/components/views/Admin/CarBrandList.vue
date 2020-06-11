<template>
    <div>
        <b-table table-variant="light" head-variant="dark" responsive="sm" stickyHeader="1000px" hover :fields="fields">
            <template v-slot:cell(actions1)="row">
                <b-button variant="info" size="sm" @click="updateBrand(row.item.id)" class="mr-1">
                Update
                </b-button>
                <b-button variant="danger" size="sm" @click="deleteBrand(row.item.id)" class="mr-1">
                Delete
                </b-button>
            </template>
        </b-table>
    </div>
</template>

<script>
import axios from "axios";
  export default {
    data() {
      return {
        fields: [
          {
            key: 'Name',
            sortable: true
          },
          {
            key: 'Label',
            sortable: true
          }, 
          { key: 'actions1', label: 'Actions' }
        ],
        listOfData: []
      }
    },
    methods: {
        updateBrand(id) {
            axios
            .put("/maintenance/brands/" + id + "/brand")
        },
        deleteBrand(id) {
            axios
            .delete("/maintenance/brands/" + id + "/brand")
        }
    },
    mounted() {
       axios
      .get("/maintenance/brands")
      .then(listOfData => {
        this.listOfData = listOfData.data;
      })
    }
  }
</script>

<style>
    .table {
        width: 40%;
        margin-top: 2%;
    }
</style>