<script setup>
import { RouterView } from 'vue-router'
import HeaderBar from "@/components/HeaderBar.vue";
</script>

<template>
  <nav>
    <HeaderBar />
  </nav>
  <RouterView />
</template>

<style scoped>
</style>
