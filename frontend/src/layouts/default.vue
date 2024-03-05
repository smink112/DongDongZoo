<template>
  <v-app>
    <DefaultBar />

    <DefaultView />
  </v-app>
  <Footer />
</template>

<script lang="ts" setup>
import DefaultBar from "./default/AppBar.vue";
import DefaultView from "./default/View.vue";
import Footer from "./default/Footer.vue";
</script>
