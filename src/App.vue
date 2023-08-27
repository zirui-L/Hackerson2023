<template>
  <div id="app">
    <startLife />
  </div>
</template>

<script>
import startLife from './components/startLife.vue'

export default {
  name: 'App',
  components: {
    startLife
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
