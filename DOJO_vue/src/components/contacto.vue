<template>
  <div>
    <h2>Contacto</h2>
    <ul><li v-for="tarea in tareas">{{tarea}}</li></ul>
  </div>

</template>

<script>
export default{
  data (){
    return{
      tareas: ['Aprender Vue', 'Pasar el semestre', 'Hacer algo']
    }
  }
}
</script>

<style>

</style>
