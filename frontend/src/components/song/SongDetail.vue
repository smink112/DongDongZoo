<script setup lang="ts">
import StoryBook from "./StoryBook.vue";
import { ref, onMounted, watch } from "vue";
import { useSongStore } from "@/store/song";
import { useRoute, useRouter } from "vue-router";
import { HttpStatusCode } from "axios";
import { RefSongDetail } from "@/types";
const songStore = useSongStore();
const route = useRoute();
const router = useRouter();
const songId = route.params.songId;

console.log(songId);
const fullImageUrl = ref<string>('');
const songDetail = ref<RefSongDetail>(null);

// songStore.getSong(
//   songId as string,
//   (res) => {
//     if (res.status == HttpStatusCode.Ok) {
//       console.log(res.data);
//       songDetail.value = res.data;
//     }
//   },
//   (err) => {}
// );

const isBlue = ref(false);

const toggleHeart = () => {
  if (isBlue.value) {
    songDetail.value.likeCount--;
  } else {
    songDetail.value.likeCount++;
  }
  isBlue.value = !isBlue.value;
};

const goBack = () => {
  console.log("call goback");
  router.go(-1);
};

const getFullImageUrl = (imageUrl: string) => {
  // 이미지의 경로를 조합하여 전체 이미지 URL을 반환
  console.log(imageUrl+"1.png");
  return imageUrl + '1.png'; // 추가적인 문자열을 덧붙임
};

watch(songDetail, () => {
  if (songDetail.value) {
    fullImageUrl.value = getFullImageUrl(songDetail.value.songImageUrl);
  }
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
  <v-row>
    <v-container>
      <v-row rows="12" class="ma-2 mt-2 pa-0">
        <v-col rows="3"
          ><v-btn @click="goBack" style="background: none" elevation="0"
            ><h3>< 뒤로가기</h3></v-btn
          ></v-col
        >
        <v-col></v-col>
        <v-col></v-col>
        <v-col></v-col>
        <v-col></v-col>
        <v-col rows="3" class="info-container">
          <v-row rows="12" class="ms-3">
            <v-col cols="auto" class="ma-0 mt-1">
              <div
                class="rounded-circle ma-0"
                style="cursor: pointer"
                @click="toggleHeart"
              >
                <font-awesome-icon
                  v-if="isBlue"
                  :icon="['fas', 'heart']"
                  style="color: skyblue"
                />
                <font-awesome-icon
                  v-else
                  :icon="['fas', 'heart']"
                  style="opacity: 50%; color: black"
                />
              </div>
            </v-col>
            <v-col cols="auto" class="ma-0">{{ songDetail?.likeCount }}</v-col>
            <v-col cols="auto" class="ma-0 mt-1">
              <font-awesome-icon :icon="['fas', 'eye']" style="opacity: 50%"
            /></v-col>
            <v-col cols="auto" class="ma-0">{{ songDetail?.views }}</v-col>
          </v-row>
        </v-col>
      </v-row>
      <v-row rows="12" class="detail-container" style="height: 400px">
        <v-row rows="5" class="pa-4 ma-0">
          <v-img class="imgcontent" :src="fullImageUrl"></v-img>
        </v-row>
        <v-row rows="7">
          <v-col cols="4" align="end">
            <v-row>
              <v-col cols="12" class="ma-2"></v-col>
              <v-col cols="12" class="ma-1"><h2>동요 제목</h2></v-col>
              <v-col cols="12" class="ma-1"><h2>동요 가사</h2></v-col>
            </v-row>
          </v-col>
          <v-col cols="7">
            <v-row>
              <v-col cols="12" class="ma-2"></v-col>
              <v-col cols="12" class="info-container ma-2">
                <h3>{{ songDetail?.songName }}</h3></v-col
              >
              <v-col
                cols="auto"
                class="ma-2 info-container"
                style="width: 100%"
              >
                <div v-for="lyrics in songDetail?.lyricsList">
                  {{ lyrics }}
                </div>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-row>
    </v-container>
  </v-row>
  <v-row>
    <v-container align="center" justify="center">
      <v-row rows="12" class="ma-0 mt-2 pa-0">
        <v-row rows="12" class="detail-container" style="height: 250px">
          <v-col cols="6">
            <v-btn width="100%" height="100%" class="radius-12 song-preview">
              <h1 class="mb-12" style="color: white; font-size: 48px">
                동요 미리듣기
              </h1></v-btn
            >
          </v-col>

          <v-col cols="6" align="center" justify="center">
            <v-btn width="100%" height="100%" class="radius-12 create-story">
              <h1 class="mb-12" style="color: white; font-size: 48px">
                동화 생성하기
              </h1></v-btn
            >
          </v-col>
        </v-row>
      </v-row>
    </v-container>
  </v-row>
  <v-container>
    <StoryBook />
  </v-container>
</template>

<style>
.info-container {
  background-color: rgb(255, 215, 254);
  border-radius: 16px;
}
.detail-container {
  background-color: rgb(253, 253, 253);
  border-radius: 24px;
  margin-left: 24px;
}
.radius-12 {
  border-radius: 12px;
}

.imgcontent {
  border-radius: 24px;
}

.song-preview {
  background: url("@/assets/character_2.png");
  background-size: cover;
  transition: transform 0.3s ease;
}
.song-preview:hover {
  transform: scale(1.1); /* 호버 시 이미지를 1.1배 확대 */
}
.create-story {
  background: url("../../assets/character_3.png");
  background-size: cover;
  transition: transform 0.3s ease;
}
.create-story:hover {
  transform: scale(1.1); /* 호버 시 이미지를 1.1배 확대 */
}
</style>
