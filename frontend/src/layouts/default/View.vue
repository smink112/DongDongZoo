<script lang="ts" setup></script>

<template>
  <v-main class="background">
    <router-view> </router-view>
  </v-main>
</template>

<style scoped>
.background {
  background: url("../../assets/background.gif");
  background-size: cover;
}
</style>
