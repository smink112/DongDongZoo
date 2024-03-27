<script setup lang="ts">
import { onMounted, onUnmounted } from "vue";

let currentPage = 1;
const pageNumber = 6;
let interval: any;
onMounted(() => {
  (<any>$("#book")).turn({
    gradients: true,
    acceleration: true,
    pages: pageNumber,
  });
  interval = setInterval(() => {
    if (currentPage === pageNumber) clearInterval(interval);
    (<any>$("#book")).turn("page", currentPage++);
  }, 1500);
});
onUnmounted(() => {
  if (interval !== undefined) clearInterval(interval);
});
</script>

<template>
  <div class="container">
    <div id="book">
      <div>
        <v-img src="@/assets/sample/bear1.png" />
      </div>
      <div>
        <v-img src="@/assets/sample/bear2.png" />
      </div>
      <div>
        <v-img src="@/assets/sample/bear3.png" />
      </div>
      <div>
        <v-img src="@/assets/sample/bear4.png" />
      </div>
      <div>
        <v-img src="@/assets/sample/bear5.png" />
      </div>
      <div>
        <v-img src="@/assets/sample/bear6.png" />
      </div>
    </div>
  </div>
</template>
<style scoped>
.container {
  overflow: hidden;
}
#book {
  margin: 5% auto;
  width: 800px;
  height: 400px;
}

#book .turn-page {
  -webkit-background-size: 100% 100%;
  background-size: 100% 100%;
}

#book div {
  -webkit-background-size: cover;
  background-size: cover;
  background-position: center center;
}
</style>
