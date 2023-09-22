<script setup>
import {computed, onMounted} from "vue";
import {useColorStore} from "@/stores/colorStore";

const colorStore = useColorStore();

const colors = computed(() => {
  return colorStore.colors;
});
onMounted(() => {
  colorStore.fetchColors();
});


</script>

<template>
  <div>
    <h1>{{ colors }} </h1>
  </div>
</template>

<style scoped>
</style>
