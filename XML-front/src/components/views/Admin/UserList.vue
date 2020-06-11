<template>
    <div>
        <b-table table-variant="light" head-variant="dark" small=true bordered=true responsive="sm" stickyHeader="1000px" hover :items="items" :fields="fields">
            <template v-slot:cell(actions1)="row">
                <b-button variant="dark" size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1">
                Block
                </b-button>
                <b-button variant="secondary" size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1">
                Unblock
                </b-button>
            </template>
            <template v-slot:cell(actions2)="row">
                <b-button variant="danger" size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1">
                Delete
                </b-button>
            </template>
        </b-table>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        fields: [
          {
            key: 'Firstname',
            sortable: true
          },
          {
            key: 'Lastname',
            sortable: true
          }, 
          { key: 'actions1', label: 'Blocking' },
          { key: 'actions2', label: 'Deleting' }
        ],
        items: [
            { Firstname: 'Lara', Lastname: 'Mimica'},
            
        ]
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