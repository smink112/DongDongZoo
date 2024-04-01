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
const storyBookImageUrlList = ref<string[]>();

const fullImageUrl = ref<string>("");
const songDetail = ref<RefSongDetail>(null);
const pageNumber = ref(1);

storyBookImageUrlList[0] = "/assets/song/bear/";

songStore.createSong(
  songId as string,
  (res) => {
    if (res.status == HttpStatusCode.Ok) {
      console.log(res.data);
      storyBookImageUrlList.value = res.data;
    }
  },
  (err) => {}
);

// StoryBook

const getFullImageUrl = (imageUrl: string) => {
  songDetail.value.songImageUrl = storyBookImageUrlList[0]; // 일단 생성된 이미지 url 가져옴
  // 이미지의 경로를 조합하여 전체 이미지 URL을 반환
  console.log(imageUrl + "0.png");
  // 서버용 이미지
  return imageUrl + "0.png";
  // 로컬용 이미지
  // return '/src' + imageUrl + '0.png';
};

watch(songDetail, () => {
  fullImageUrl.value = getFullImageUrl(songDetail.value.songImageUrl);
  pageNumber.value = songDetail.value.lyricsList.length;
  console.log(pageNumber.value);
});

// 컴포넌트가 마운트된 후 실행되는 동작 정의
onMounted(() => {
  // songId를 사용하여 songDetail을 가져오고 fullImageUrl 값을 설정
  songStore.getSong(
    songId as string,
    (res) => {
      if (res.status == HttpStatusCode.Ok) {
        console.log(res.data);
        songDetail.value = res.data;
      }
    },
    (err) => {
      console.error(err);
    }
  );
});
</script>
<template>
  <!-- <CreateLoadingView></CreateLoadingView> -->

  <v-container>
    <StoryBook :songDetail="songDetail" :pageNumber="pageNumber" />
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
