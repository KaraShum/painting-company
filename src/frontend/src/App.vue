<script setup>
import {RouterView} from 'vue-router'
import HeaderBar from "@/components/HeaderBar.vue";
import { useAuthStore } from '@/stores/authStore';
import { onMounted } from 'vue';

const authStore = useAuthStore();

const loginAsAdmin = () => {
  const fakeAdminUser = {
    id: 1,
    username: 'admin',
    role: 'user',
  };
  authStore.setUser(fakeAdminUser);
};

onMounted(() => {
  loginAsAdmin();
});
</script>

<template>
  <HeaderBar/>
  <main>
    <RouterView/>
  </main>
</template>

<style scoped>
</style>
