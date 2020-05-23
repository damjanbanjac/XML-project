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
            margin-left: 6%">Client Registration</h2>
        </template>

        <template>
            <b-form bg-variant="light" @submit="onSubmit">
            <b-form-group
                id="input-group-1"
                label="Email address:"
                label-for="input-1"
            >
                <b-form-input
                id="input-1"
                v-model="form.email"
                type="email"
                required
                placeholder="Enter email"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Name:" label-for="input-2">
                <b-form-input
                id="input-2"
                v-model="form.name"
                required
                placeholder="Enter name"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-3" label="Surname:" label-for="input-3">
                <b-form-input
                id="input-3"
                v-model="form.surname"
                required
                placeholder="Enter surname"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-4" label="Address:" label-for="input-4">
                <b-form-input
                id="input-4"
                v-model="form.address"
                required
                placeholder="Enter address"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Password:" label-for="input-5">
                <b-form-input
                id="input-5"
                v-model="form.password"
                required
                placeholder="Enter password"
                type="password"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-6" label="Password:" label-for="input-6">
                <b-form-input
                id="input-6"
                v-model="form.repassword"
                required
                placeholder="Re-enter password"
                type="password"
                ></b-form-input>
            </b-form-group>

            <b-form-group>
                <b-button type="submit" variant="primary">Register</b-button>
            </b-form-group>

            </b-form>

        </template>
    </b-jumbotron>
</div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          email: '',
          name: '',
          surname: '',
          address: '',
          password: '',
          repassword: ''
        },
        show: true
      }
    },
    methods: {
    }
}
</script>

<style>

.jumbotron {
    padding: 2rem 2rem;
    margin-bottom: 2rem;
}

</style>