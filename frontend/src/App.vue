<template>
  <div>
    <Navbar/>
    <router-view/>

  </div>
</template>



<script>
import Admin from "./pages/Admin.vue"
import Navbar from "./components/Navbar.vue"
export default {
  name: 'App',
  components: {
    Admin,
    Navbar
}
}
</script>

<style>

.page-header{
  display: flex;
  justify-content: flex-end;
}

.page-header>.actions{
}

.page-header>h1{
  margin: auto
}

</style>
