<script setup>
</script>

<template>
  <header>
    <nav>
      <router-link v-bind:to="{name:'home'}"> </router-link>
      <router-link v-bind:to="{name:'datadisplay'}"></router-link>

    </nav>
  </header>

  <RouterView />
</template>

<style scoped>

</style>
