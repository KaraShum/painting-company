<script setup>
import {useWallpaperStore} from "@/stores/wallpaperStore";
import {onMounted} from "vue";

const wallpaperStore = useWallpaperStore();

onMounted(() => {
  wallpaperStore.fetchWallpapers();
})
const wallpapers = wallpaperStore.wallpapers;

</script>

<template>
<div>
  <select>
    <option v-for="wallpaper in wallpapers" :key="wallpaper.id" :value="wallpaper.id">{{ wallpaper.name }} ({{ wallpaper.price }}€)</option>
  </select>
</div>
</template>

<style scoped>

</style>