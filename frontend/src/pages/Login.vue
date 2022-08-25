<template class="background">
  <div class="LG-body">
    <h1>Login</h1>
    <FormKit type="form" submit-label="Login" @submit="login">
      <FormKitSchema :schema="Login_data" />
      
    </FormKit>
  </div>

</template>

<script>
//import { FormKit } from '@formkit/vue'
import { FormKitSchema } from '@formkit/vue'
import Login_data from '../config/LoginSchema.json'

export default {
  name: 'Login',
  components: {
    FormKitSchema
  },
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
