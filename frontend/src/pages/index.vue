<script lang="ts" setup>
import Main from "@/components/main/Main.vue";
import { ref } from "vue";
import { useLoadingStore } from "@/store/loading";

const loadingStore = useLoadingStore();
loadingStore.contentLoaded();
</script>
<template>
  <Main></Main>
</template>
<style></style>
