<script setup>
import {useColorStore} from "@/stores/colorStore";
import {useWallpaperStore} from "@/stores/wallpaperStore";
import {computed, onMounted, ref} from "vue";
import {calcDeepground, calcPaintBuckets, calcWallpaperRolls} from "@/services/calculator";
import ShopCard from "@/components/ShopCard.vue";
import Output from "@/services/output";

const colorStore = useColorStore();
const wallpaperStore = useWallpaperStore();
const isActive = ref(false);
const tab = ref(0);
const colors = computed(() => colorStore.colors);
const wallpapers = computed(() => wallpaperStore.wallpapers);
const selectedColor = ref();

onMounted(() => {
  colorStore.fetchColors();
  wallpaperStore.fetchWallpapers();
})

const validateNumber = (event, prop) => {
  const value = event.target.value;
  if (!/^\d*\.?\d*$/.test(value)) {
    event.target.value = value.replace(/[^\d.]/g, '');
  }
}

function changeColor(event) {
  selectedColor.value = event.target.value;
}

const checkBox = ref(false);

function changeTab() {
  if (tab.value === 0) {
    tab.value = 1;
    isActive.value = !isActive.value;
    selectedColor.value = null;
  } else {
    tab.value = 0;
    isActive.value = !isActive.value;
    selectedWallpaper.value = null;
  }
}

const count = ref(0);
const price = ref(0);

const width = ref(0);
const height = ref(0);
const windowHeigth = ref(0);
const windowWidth = ref(0);
const selectedWallpaper = ref(null);
const area = computed(() => width.value * height.value);
const windowArea = computed(() => windowHeigth.value * windowWidth.value);
const totalArea = computed(() => area.value - windowArea.value);

let outputs = ref([]);

const isDeepground = ref(false);

function addToCart() {
  const category = ref("");
  const type = ref("");
  const deepgroundPrice = ref(0);
  console.log(selectedWallpaper.value);
  if (selectedWallpaper.value !== null) {
    if (isDeepground.value) {
      deepgroundPrice.value = calcDeepground(width.value, height.value) * 2;
    }
    category.value = "Tapete";
    type.value = selectedWallpaper.value.name;
    count.value = calcWallpaperRolls(width.value, height.value, selectedWallpaper.value.rollLength, selectedWallpaper.value.rollWidth, selectedWallpaper.value.rapport);
    price.value = selectedWallpaper.value.price * count.value;
  } else {
    if (isDeepground.value) {
      deepgroundPrice.value = calcDeepground(width.value, height.value) * 2;
    }
    category.value = "Farbe";
    type.value = selectedColor.value.name;
    count.value = calcPaintBuckets(totalArea.value, selectedColor.value.areaPerContainer);
    price.value = count.value * selectedColor.value.price
  }

  const output = new Output(category.value ,count.value, price.value, type.value);
  outputs.value.push({
    _category: output.category,
    _count: output.count,
    _price: output.price,
    _type: output.type,
    _deepgroundPrice: deepgroundPrice.value
  });
}
</script>

<template>
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
                @input="validateNumber($event, height)"
                class="appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-blue-600"
                id="height-input"
                type="text"
                placeholder="Höhe eingeben">
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
                @input="validateNumber($event, width)"
                class="appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-blue-600"
                id="width-input"
                type="text"
                placeholder="Breite eingeben">
          </div>
        </div>
        <div>
          <label class="text-gray-500 font-bold my-2 pr-4" for="window">
            Fenster/Tür
          </label>
          <input @click="checkBox = !checkBox" type="checkbox" id="window">
          <div v-if="checkBox">
            <div class="md:flex md:items-center mb-6">
              <div class="md:w-1/3">
                <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-full-name">
                  Höhe
                </label>
              </div>
              <div class="md:w-2/3">
                <input
                    v-model="windowHeigth"
                    @input="validateNumber($event, height)"
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
                    v-model="windowWidth"
                    @input="validateNumber($event, width)"
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
                :disabled="!isActive"
                class="inline-block w-full p-4 text-gray-900 bg-gray-100 rounded-l-lg focus:ring-4 focus:ring-blue-300 active focus:outline-none"
                aria-current="page">Farbe
            </button>
          </li>
          <li class="w-full">
            <button
                @click.prevent="changeTab"
                :disabled="isActive"
                class="inline-block w-full p-4 text-gray-900 bg-gray-100 rounded-r-lg focus:ring-4 focus:ring-blue-300 active focus:outline-none">
              Tapete
            </button>
          </li>
        </ul>
        <div v-if="tab === 0">
          <div>
            <select v-model="selectedColor">
              <option v-for="color in colors" :key="color.id" :value="color">{{ color.name }} ({{
                  color.price
                }}€)
              </option>
            </select>
            <label for="deepGround">Tiefgrund hinzufügen</label>
            <input @click="isDeepground = !isDeepground" type="checkbox" id="deepGround">
          </div>
        </div>
        <div v-if="tab === 1">
          <div>
            <select v-model="selectedWallpaper">
              <option v-for="wallpaper in wallpapers" :key="wallpaper.id" :value="wallpaper">{{ wallpaper.name }}
                ({{ wallpaper.price }}€)
              </option>
            </select>
            <label for="deepGround">Tiefgrund hinzufügen</label>
            <input @click="isDeepground = !isDeepground" type="checkbox" id="deepGround">
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