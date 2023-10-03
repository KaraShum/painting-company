<script setup>
import { useAuthStore } from '@/stores/authStore';

const authStore = useAuthStore();
const isAdmin = authStore.isAdmin;
</script>

<template>
  <header class="bg-transparent">
    <nav class="mx-auto flex max-w-7xl items-center justify-between p-6 px-8" aria-label="Global">
      <div class="flex flex-1">
        <router-link to="/" class="flex items-center -m-1.5 p-1.5">
          <img class="h-8 w-auto pr-1.5" src="../assets/logoipsum-296.svg" alt="">
          <span class="font-bold text-2xl">Malerei Kunterbunt</span>
        </router-link>
      </div>
      <div class="hidden lg:flex lg:gap-x-12">
        <router-link to="/" class="text-sm font-semibold hover:underline decoration-blue-500 decoration-4 leading-6 text-gray-900">Home</router-link>
        <router-link to="/shop" class="text-sm font-semibold hover:underline decoration-blue-500 decoration-4 leading-6 text-gray-900">Shop</router-link>
        <router-link to="/company" v-if="isAdmin" class="text-sm font-semibold hover:underline decoration-blue-500 decoration-4 hover:transition-transform leading-6 text-gray-900">Company</router-link>
      </div>
      <div class="hidden lg:flex lg:flex-1 lg:justify-end">
        <router-link to="login" class="text-sm font-semibold hover:underline leading-6 text-gray-900">Log in <span aria-hidden="true">&rarr;</span>
        </router-link>
      </div>
    </nav>
  </header>
</template>

<style scoped>
.hover\underline:hover {
  text-decoration: underline;

}
</style>