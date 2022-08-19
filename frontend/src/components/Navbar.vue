<template>
    <div class="navbar">
        <img class="logo" src="../assets/logo.png" />
        <div class="links">
            <a class="link" href="">Home</a>
            <a class="link" href="">Admin Portal</a>
            <a class="link" href="">Signout</a>
        </div>
    </div>
</template>

<script>
</script>

<style>
.navbar {
    height: 90px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.logo {
    height: 100%;
    margin-left: 50px;
}

.links {}

.link {
    margin-left: 10px;
    margin-right: 10px;
}

a:link, a:visited {
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: green;
  color: white;
}
</style>