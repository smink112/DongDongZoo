<script setup lang="ts">
import { useLoadingStore } from "@/store/loading";

const loadingStore = useLoadingStore();
loadingStore.contentLoaded();
</script>
<template>
  <div></div>
</template>

<style scoped></style>
