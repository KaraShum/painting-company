<script setup>
import {useColorStore} from "@/stores/colorStore";
import {useWallpaperStore} from "@/stores/wallpaperStore";
import {computed, ref, onMounted, defineProps} from "vue";
import {calcWallpaperRolls} from "@/services/calculator";
import ShopCard from "@/components/ShopCard.vue";
import Output from "@/services/output";

const colorStore = useColorStore();
const wallpaperStore = useWallpaperStore();

const colors = computed(() => colorStore.colors);
const colorPrice = computed(() => colorStore.colors.map(color => color.price));

const wallpapers = computed(() => wallpaperStore.wallpapers);
const selectedColor = ref(0);

onMounted(() => {
  colorStore.fetchColors();
  wallpaperStore.fetchWallpapers();
})

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

const count = ref(0);
const price = ref(0);

const width = ref(0);
const height = ref(0);
const selectedWallpaper = ref();

let outputs = ref([]);
function addToCart() {
  count.value = calcWallpaperRolls(width.value, height.value, selectedWallpaper.value.rollLength, selectedWallpaper.value.rollWidth, 0);
  price.value = selectedWallpaper.value.price * count.value;
  const output = new Output(count.value, price.value, "Tapete");
  outputs.value.push({
    _count: output.count,
    _price: output.price,
    _type: output.type
  });
}
</script>

<template>

  <!-- Links: Eingabefelder -->


  <!-- Rechts: Anzeige/Historie -->


  <div class="flex flex-wrap bg-white pt-2">
    <h1 class="w-full text-3xl text-center font-bold text-gray-900">Materialkostenberechnung</h1>
    <hr class="my-12 h-0.5 border-t-0 bg-neutral-100"/>
    <div class="w-1/2 ml-auto bg-transparent h-12">
      <form class="w-full align-content-center max-w-sm">
        <h2 class="font-semibold mb-2.5">Wandmaße</h2>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-full-name">
              Höhe
            </label>
          </div>
          <div class="md:w-2/3">
            <input
                v-model="height"
                class="appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-blue-600"
                id="inline-full-name" type="text">
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
              Breite
            </label>
          </div>

          <div class="md:w-2/3">
            <input
                v-model="width"
                class="appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-blue-600"
                type="text">
          </div>
        </div>
        <div>
          <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
            Fenster/Tür
          </label>
          <input @click="checkBox = !checkBox" type="checkbox">
          <div v-if="checkBox">
            <div class="md:flex md:items-center mb-6">
              <div class="md:w-1/3">
                <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-full-name">
                  Höhe
                </label>
              </div>
              <div class="md:w-2/3">
                <input
                    class="appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-blue-600"
                    id="inline-full-name" type="text">
              </div>
            </div>
            <div class="md:flex md:items-center mb-6">
              <div class="md:w-1/3">
                <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
                  Breite
                </label>
              </div>

              <div class="md:w-2/3">
                <input
                    class="appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-blue-600"
                    type="text">
              </div>
            </div>
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3"></div>
        </div>

        <div class="sm:hidden">
          <select id="tabs"
                  class="active:g-gray-50 border active:border-gray-300 active:text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
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
          <div>
            <select v-model="selectedColor">
              <option v-for="color in colors" :key="color.id" :value="color.id">{{ color.name }} ({{
                  color.price
                }}€)
              </option>
            </select>
          </div>
        </div>
        <div v-if="tab === 1">
          <div>
            <select v-model="selectedWallpaper">
              <option v-for="wallpaper in wallpapers" :key="wallpaper.id" :value="wallpaper">{{ wallpaper.name }}
                ({{ wallpaper.price }}€)
              </option>
            </select>
          </div>
        </div>

        <div class="md:flex md:items-center">
          <div class="md:w-1/3"></div>
          <div class="md:w-2/3">
            <button
                class="shadow bg-blue-600 hover:bg-blue-500 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded"
                type="submit"
                @click.prevent="addToCart">
              Hinzufügen
            </button>
          </div>
        </div>
      </form>
    </div>
    <div class="w-1/3 mr-auto bg-transparent h-12">
      <ShopCard
        :outputs="outputs">
      </ShopCard>
    </div>
  </div>
</template>

<style scoped>

</style>