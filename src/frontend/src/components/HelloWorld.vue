<script setup>
import {computed, onMounted, ref} from "vue";
import {useColorStore} from "@/stores/colorStore";

const colorStore = useColorStore();
const selectedColor = ref(null);
const colors = computed(() => {
  return colorStore.colors;
});
onMounted(() => {
  colorStore.fetchColors();
});

function addColor() {
  colorStore.addColor(color.value, 2);
}

function getColorNames() {
  return colors.value.map(color => color.name);
}

</script>

<template>
  <v-form>
    <v-select
        v-model="selectedColor"
        :items="getColorNames()"
        label="Select a color"
        variant="outlined"
    ></v-select>
    <v-btn color="primary" block class="mt-2" @click="addColor">Hinzufügen</v-btn>
  </v-form>
  <v-form>
  </v-form>
  <v-sheet width="300" class="mx-auto">
    <v-form fast-fail="" @submit.prevent>
      <v-text-field
          v-model="hoehe"
          label="Höhe"
          :rules="[v => !!v || 'Höhe ist erforderlich']">
      </v-text-field>
      <v-text-field
          v-model="breite"
          label="Breite"
          :rules="[v => !!v || 'Breite ist erforderlich']">
      </v-text-field>
      <v-btn color="primary" block class="mt-2" @click="addColor">Hinzufügen</v-btn>
    </v-form>
  </v-sheet>
  <v-form>
    <v-text-field label="Höhe"></v-text-field>
    <v-text-field label="Breite"></v-text-field>
    <v-checkbox/>
  </v-form>
</template>

<style scoped>
.v-text-field {
  width: 400px;
}
</style>
