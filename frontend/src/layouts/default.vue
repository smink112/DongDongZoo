<template>
  <v-app>
    <v-container>
      <DefaultBar />
      <DefaultView />
      <Footer />
    </v-container>
  </v-app>
</template>

<script lang="ts" setup>
import DefaultBar from "./default/AppBar.vue";
import DefaultView from "./default/View.vue";
import Footer from "./default/Footer.vue";
</script>
