<script lang="ts" setup>
import Def from "./layouts/Def.vue";

console.log(import.meta.env); // "123"
console.log(process.env);
</script>

<template>
  <v-app>
    <v-main>
      <Def />
    </v-main>
  </v-app>
</template>
