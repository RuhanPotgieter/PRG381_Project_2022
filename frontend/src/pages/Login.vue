<template class="background">
  <div class="LG-body">
    <h1>Login</h1>
    <FormKit type="form" submit-label="Login" @submit="login">
      <FormKit name="email" label="Email address" validation="required|email" />
      <FormKit type="password" name="password" label="Password" validation="required" />
    </FormKit>
  </div>

</template>

<script>
//import { FormKit } from '@formkit/vue'
//import { FormKitSchema } from '@formkit/vue'
import Login_data from '../config/Login.json'
export default {
  name: 'StudentEdit',
  data() {
    return {
      Login_data
    }
  },
  methods: {
    
  },
}
</script>

<style>
.LG-body {
  position: absolute;
  top: 30%;
  left: 38%;
  width: 20%;
  height: 20%;
}
</style>
