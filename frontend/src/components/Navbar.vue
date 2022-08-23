<template>
    <nav>
        <img class="logo" src="../assets/logo.png" />
        <div class="links">
            <router-link to="/">Login</router-link> | 
            <router-link to="/admin">Admin Portal</router-link> | 
            <router-link to="/">Signout</router-link>
        </div>
    </nav>
</template>

<script>
</script>

<style>
nav {
    height: 90px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.logo {
    height: 100%;
    margin-left: 50px;
}

.navbar a {
    font-weight: bold;
    color: #2c3e50;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.links {
    margin-right: 25px;
}
</style>