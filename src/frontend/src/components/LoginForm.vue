<script setup>
// import AuthService from "@/services/AuthService";
import {reactive} from "vue";

const user = reactive({
  username: "",
  password: "",
});
//
// function login() {
//   AuthService.login(this.user).then((response) => {
//     if (response.data.accessToken) {
//       window.localStorage.clear();
//       window.localStorage.setItem("jwtToken", response.data.accessToken);
//     }
//     window.location.href = "/";
//   })
// }

</script>

<template>
  <div class="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
    <div class="sm:mx-auto sm:w-full sm:max-w-sm">
      <svg class="mx-auto h-10 w-auto" src="../assets/logo.svg"/>
      <h2 class="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">Sign in to your
        account</h2>
    </div>
    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
      <form class="space-y-6" action="#" method="POST">
        <div>
          <label for="email" class="block text-sm font-medium leading-6 text-gray-900">Email address</label>
          <div class="mt-2">
            <input id="email" name="email" type="text" v-model="user.username" placeholder="Benutzername"
                   class="block w-full rounded-md border-0 py-1.5 text-gray-900 text shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"/>
          </div>
        </div>

        <div>
          <div class="flex items-center justify-between">
            <label for="password" class="block text-sm font-medium leading-6 text-gray-900">Password</label>
            <div class="text-sm">
              <router-link to="/recover" class="font-semibold text-indigo-600 hover:text-indigo-500">Forgot password?
              </router-link>
            </div>
          </div>
          <div class="mt-2">
            <input id="password" name="password" type="password" v-model="user.password"
                   class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"/>
          </div>
        </div>

        <div>
          <button type="submit"
                  @click="login"
                  class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semisbold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
            Anmelden
          </button>
        </div>
      </form>
      <p class="mt-10 text-center text-sm text-gray-500">
        Not a member?
        {{ ' ' }}
        <router-link to="/register" class="font-semibold leading-6 text-indigo-600 hover:text-indigo-500">Join now!
        </router-link>
      </p>
    </div>
  </div>
</template>

<style scoped>

</style>