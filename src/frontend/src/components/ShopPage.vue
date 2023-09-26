<script setup>
import {useColorStore} from "@/stores/colorStore";
import {computed, ref, onMounted} from "vue";

const colorStore = useColorStore();

const colors = computed(() => colorStore.colors);
const colorPrice = computed(() => colorStore.colors.map(color => color.price));
onMounted(() => {
  colorStore.fetchColors();
})

const selectedColor = ref(0);

function changeColor(event) {
  selectedColor.value = event.target.value;
}
</script>

<template>
  <div class="container flex flex-wrap bg-white pt-2">
    <h1 class="w-full text-3xl text-center font-bold text-gray-900">Materialkostenberechnung</h1>
    <hr class="my-8 bg-blue-600 border-2 dark:bg-blue-400"/>
    <div class="w-1/2 ml-auto bg-transparent h-12">
      <form class="w-full max-w-sm">
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-2/3">
            <label for="color" class="block mb-2 text-sm font-medium text-gray-900">Farbe wählen</label>
            <select id="color" v-model="selectedColor" @change="changeColor($event)">
              <option v-for="color in colors" :key="color.id" :value="color.id">{{ color.name }}</option>
            </select>
            <span> {{ selectedColor.price }} €</span>
          </div>
          <div class="md:w-1/3">
            <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-full-name">
              Höhe
            </label>
          </div>
          <div class="md:w-2/3">
            <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-full-name" type="text" value="Jane Doe">
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
              Breite
            </label>
          </div>
          <div class="md:w-2/3">
            <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-password" type="password" placeholder="******************">
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3"></div>
        </div>
        <div class="md:flex md:items-center">
          <div class="md:w-1/3"></div>
          <div class="md:w-2/3">
            <button class="shadow bg-blue-600 hover:bg-blue-500 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded" type="button">
              Hinzufügen
            </button>
          </div>
        </div>
      </form>
    </div>
    <div class="w-1/3 mr-auto bg-transparent h-12">

    </div>
  </div>
</template>

<style scoped>
.container {
  height: 75vh;
}
</style>