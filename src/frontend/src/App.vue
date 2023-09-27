<script setup>
import {RouterView} from 'vue-router'
import HeaderBar from "@/components/HeaderBar.vue";
import FooterBar from "@/components/FooterBar.vue";
</script>

<template>
  <HeaderBar/>
  <main>
    <RouterView/>
  </main>
</template>

<style scoped>
</style>
