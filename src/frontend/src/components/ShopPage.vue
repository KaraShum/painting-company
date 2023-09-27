<script setup>
import {useColorStore} from "@/stores/colorStore";
import {useWallpaperStore} from "@/stores/wallpaperStore";
import {computed, ref, onMounted, defineProps} from "vue";
import {calcWallpaperRolls} from "@/services/calculator";
import ValueForm from "@/components/ValueForm.vue";
import WallpaperForm from "@/components/WallpaperForm.vue";
import PaintForm from "@/components/PaintForm.vue";

const colorStore = useColorStore();
const wallpaperStore = useWallpaperStore();

const colors = computed(() => colorStore.colors);
const colorPrice = computed(() => colorStore.colors.map(color => color.price));
onMounted(() => {
  colorStore.fetchColors();
  wallpaperStore.fetchWallpapers();
})

const selectedColor = ref(0);
console.log(wallpaperStore.getAll);

function changeColor(event) {
  selectedColor.value = event.target.value;
}

console.log(calcWallpaperRolls(5, 2.65, 10.05, 0.53, 0.72));

const checkBox = ref(false);
const tab = ref(0);

function changeTab() {
  if (tab.value === 0) {
    tab.value = 1;
  } else {
    tab.value = 0;
  }
}
</script>

<template>

  <!-- Links: Eingabefelder -->


  <!-- Rechts: Anzeige/Historie -->


  <div class="flex flex-wrap bg-white pt-2">
    <h1 class="w-full text-3xl text-center font-bold text-gray-900">Materialkostenberechnung</h1>
    <!--    <hr class="my-12 h-0.5 border-t-0 bg-neutral-100 opacity-100 dark:opacity-50"/>-->
    <div class="w-1/2 ml-auto bg-transparent h-12">
      <form class="w-full max-w-sm">
        <h2 class="font-semibold">Wandmaße</h2>
        <ValueForm/>
        <div>
          <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
            Fenster/Tür
          </label>
          <input @click="checkBox = !checkBox" type="checkbox">
          <div v-if="checkBox">
            <ValueForm/>
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3"></div>
        </div>

        <div class="sm:hidden">
          <select id="tabs"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
            <option>Farbe</option>
            <option>Tapete</option>
          </select>
        </div>
        <ul class="hidden text-sm font-medium text-center text-gray-500 divide-x divide-gray-200 rounded-lg shadow sm:flex dark:divide-gray-700 dark:text-gray-400">
          <li class="w-full">
            <button
                @click.prevent="changeTab"
                class="inline-block w-full p-4 text-gray-900 bg-gray-100 rounded-l-lg focus:ring-4 focus:ring-blue-300 active focus:outline-none"
                aria-current="page">Farbe
            </button>
          </li>
          <li class="w-full">
            <button
                @click.prevent="changeTab"
                class="inline-block w-full p-4 bg-white rounded-r-lg hover:text-gray-700 hover:bg-gray-50 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:hover:text-white">
              Tapete
            </button>
          </li>
        </ul>
        <div v-if="tab === 0">
          <PaintForm/>
        </div>
        <div v-if="tab === 1">
          <WallpaperForm/>
        </div>


        <div class="md:flex md:items-center">
          <div class="md:w-1/3"></div>
          <div class="md:w-2/3">
            <button
                class="shadow bg-blue-600 hover:bg-blue-500 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded"
                type="button"
                @click="addToCart">
              Berechnen
            </button>
          </div>
        </div>
      </form>
    </div>
    <div class="w-1/3 mr-auto bg-transparent h-12">
      <p>HALLO HALLO</p>
    </div>
  </div>
</template>

<style scoped>

</style>