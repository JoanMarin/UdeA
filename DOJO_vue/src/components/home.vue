<template>
  <div>
    <input type="text" v-model="nuevoMensaje">
    <input type="button" value="Agregar Mensaje" v-on:click="agregarTarea">
    <h1>{{ mensaje }}</h1>
  </div>

</template>

<script>
export default{
  data (){
    return{
      mensaje: null,
      nuevoMensaje: null,
    }
  },
  methods:{
    agregarTarea(){
      this.mensaje = this.nuevoMensaje;
      this.nuevoMensaje=null;
    }
  }


}
</script>

<style lang="scss">

</style>
