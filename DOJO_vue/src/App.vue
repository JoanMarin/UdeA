<template>
  <section>
    <h1>Rutas con Vue Router</h1>
    <router-link to="/">Home</router-link>
    <router-link to="/contacto">Contacto</router-link>
    <router-view></router-view>
  </section>
</template>

<script>
export default {
  name: "App"
}
</script>

<style>

</style>
