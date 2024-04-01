<script setup lang="ts">
import { defineProps, ref, onMounted, onUnmounted, watch } from "vue";
import AudioPlayer from "vue3-audio-player";
import "vue3-audio-player/dist/style.css";
import { useRoute, useRouter } from "vue-router";
import { useSongStore } from "@/store/song";
import { HttpStatusCode } from "axios";
import CreateLoadingView from "@/components/common/CreateLoadingView.vue";
import { RefStoryImageRes, RefSongDetail } from "@/types/";

const route = useRoute();
const songId = route.params.songId;
const tag = route.params.tag;
const songStore = useSongStore();

// 새롭게 생성된 이미지 url 리스트
const List = ref<RefStoryImageRes>();

songStore.createSong(
  songId as string,
  tag as string,
  (res) => {
    if (res.status == HttpStatusCode.Ok) {
      console.log(res.data);
      List.value = res.data;
      console.log(List.value);
    }
  },
  (err) => {}
);

// StoryBook
</script>
<template>
  <!-- <CreateLoadingView></CreateLoadingView> -->

  <v-container>
    <StoryBook />
  </v-container>
</template>

<style scopeds>
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
