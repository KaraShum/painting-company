<script setup>
import {computed, defineProps, onMounted, ref} from "vue";

const props = defineProps({
  outputs: [],
})

const finalPrice = computed(() => {
  let price = 0;
  for (let i = 0; i < props.outputs.length; i++) {
    price += props.outputs[i]._price;
    price += props.outputs[i]._deepgroundPrice;
  }
  return price;
})

function removeWallItem(index) {
  props.outputs.splice(index, 1);
}
</script>

<template>
  <div class="flex flex-wrap md:w-full">
    <div class="mb-6">
      <div class="md:w-full">
        <div class="flex" v-for="(output, index) in props.outputs" :key="index">
          <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4 row-cols-1">
            Wand {{ index+1 }}: {{ output._count }}
            <span v-if="output._category === 'Tapete'">Rollen</span>
            <span v-else>Farbeimer</span>
            {{ output._type }} {{ output._price }} €
          </label>
          <label v-if="output._deepgroundPrice > 0" class="block text-gray-500md:text-right mb-1 md:mb-0 pr-4 row-cols-1">
            Tiefgrund: {{ output._deepgroundPrice }} €
          </label>
          <button @click="removeWallItem(index)">X</button>
        </div>
      </div>
      <div class="md:w-full"></div>
      <div class="md:w-full my-2">
        <span class="block text-gray-500 font-bold">Der Gesamtpreis beträgt {{ finalPrice }} €</span>
      </div>
    </div>
  </div>
</template>


<style scoped>
</style>