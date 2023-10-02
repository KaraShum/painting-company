<script setup>
import {useColorStore} from "@/stores/colorStore";
import {onMounted} from "vue";

const colorStore = useColorStore();

onMounted(() => {
  colorStore.fetchColors();
})

const colors = colorStore.colors;
</script>

<template>
<div>
  <select>
    <option v-for="color in colors" :key="color.id" :value="color.id">{{ color.name }} ({{ color.price }}€)</option>
  </select>
</div>
</template>

<style scoped>

</style>