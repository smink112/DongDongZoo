<script setup lang="ts">
import { onMounted, onUnmounted } from "vue";
import AudioPlayer from "vue3-audio-player";
import "vue3-audio-player/dist/style.css";

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
  <v-col class="col" cols="12">
    <h1 class="title">샘플 동화 읽어보기</h1>
    <div class="container">
      <div id="book">
        <div class="page">
          <v-img src="@/assets/sample/bear1.png" />
        </div>
        <div class="page">
          <v-img src="@/assets/sample/bear2.png" />
        </div>
        <div class="page">
          <v-img src="@/assets/sample/bear3.png" />
        </div>
        <div class="page">
          <v-img src="@/assets/sample/bear4.png" />
        </div>
        <div class="page">
          <v-img src="@/assets/sample/bear5.png" />
        </div>
        <div class="page">
          <v-img src="@/assets/sample/bear6.png" />
        </div>
      </div>
      <v-col align="center" justify="center">
        <v-col cols="8">
          <AudioPlayer
            :option="{
              src: 'https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3',
              title: '곰 세마리',
            }"
          />
        </v-col>
      </v-col>
    </div>
  </v-col>
</template>
<style scoped>
.col {
  margin: 24px;
  padding: 24px;
  border-radius: 24px;
  background-color: rgb(239, 239, 239);
}
.title {
  margin-left: 24px;
}

.container {
  overflow: hidden;
  #book {
    margin: 5% auto;
    width: 800px;
    height: 400px;
  }
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
