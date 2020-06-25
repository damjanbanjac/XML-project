<template>
<div>
    <b-jumbotron bg-variant="light" text-variant="dark" style="width: 510px;
    height: 750px;
    margin-top: 0.6%;
    margin-left: 3%;">
        <template>
            <h2 style="font-size: 2rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;
            margin-bottom: -1rem;">Company Registration</h2>
        </template>

        <template>
            <b-form bg-variant="light" @click="submit()">
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

            <b-form-group id="input-group-4" label="Company ID:" label-for="input-4">
                <b-form-input
                id="input-4"
                v-model="form.companyId"
                required
                placeholder="Enter company id"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Address:" label-for="input-5">
                <b-form-input
                id="input-5"
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
                <b-button type="submit" variant="info">Register</b-button>
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
          companyId: '',
          address: '',
          password: '',
          repassword: ''
        },
        show: true
      }
    },
    methods: {
        submit() {
        if (this.form.email === "" || 
        this.form.name === "" ||
        this.form.surname === "" ||
        this.form.companyId === "" ||
        this.form.address === "" ||
        this.form.password === "" ||
        this.form.repassword === "") {
          this.errorMessage = "Please fill all fields";
          this.error = true;
          return;
        }
        if(this.form.password != this.form.repassword) {
          this.errorMessage = "Passwords must match";
          this.error = true;
          return;
        }
        // axios
        // .post("/brands", this.form)
        // .then(() => {
        //   this.form.name = "";
        //   this.form.label = "";
        // })
        // .catch(error => {
        //   console.log(error);
        // });

        }
    }
}
</script>

<style>

.jumbotron {
    padding: 2rem 2rem;
    margin-bottom: 2rem;
}

</style>