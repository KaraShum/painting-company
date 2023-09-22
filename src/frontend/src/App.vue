<script setup>
import {RouterView} from 'vue-router'
import HeaderBar from "@/components/HeaderBar.vue";
</script>

<template>
  <v-app>
      <HeaderBar/>
    <v-main>
      <RouterView/>
    </v-main>
  </v-app>
</template>

<style scoped>
.html, body {
  margin: 0;
  padding: 0;
  width: 100%;
  box-sizing: border-box;
}

.nav {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>
