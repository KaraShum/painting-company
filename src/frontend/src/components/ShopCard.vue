<script setup>
import {defineProps} from "vue";
import Output from "@/services/output";

const props = defineProps({
  outputs: [],
})

</script>

<template>
  <div class="md:w-full">
    <div class="md:flex md:items-center mb-6">
      <div class="md:w-1/3">
        <div v-for="(output) in props.outputs" :key="index">
          <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4">
            {{ output._count }} - {{ output._price }} - {{ output._type }}
          </label>
        </div>
<!--        <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-full-name">-->
<!--          Anzahl: {{ count }} Rollen-->
<!--        </label>-->
<!--      </div>-->
<!--    </div>-->
<!--    <div class="md:flex md:items-center mb-6">-->
<!--      <div class="md:w-1/3">-->
<!--        <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-full-name">-->
<!--          Preis: {{ price }} €-->
<!--        </label>-->
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>