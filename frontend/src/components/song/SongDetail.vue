<script setup lang="ts">
import StoryBook from "./StoryBook.vue";
import { ref } from "vue";

const message =
  "퐁당 퐁당 돌을 던지자 누나 몰래 돌을 던지자 냇물아 퍼져라 멀리멀리 퍼져라 건너편에 앉아서 나물을 씻는 우리누나 손등을 간질어 주어라";

let isBlue = false;

function toggleThumb() {
  isBlue = !isBlue;
}

const show = ref(false);
</script>

<template>
  <div class="songTitle">
    <h1 style="">동요 제목</h1>
  </div>
  <div class="imgcontent">
    <v-img class="leftcontent" src="@/assets/song.png"></v-img>
    <div class="rightcontent">
      <h2>가사</h2>
      <textarea
        class="textarea"
        v-model="message"
        placeholder="여러줄을 입력해보세요"
      ></textarea>
      <div class="likeHeart">
        <Transition>
          <button class="likebtn" @click="show = !show">
            <!-- 좋아요 눌렀을 경우 -->
            <p v-if="show">
              <v-btn
                @click="toggleThumb()"
                class="white-background"
                color="blue-2"
                icon="mdi-heart"
                variant="text"
                :class="{ blue: !isBlue }"
              ></v-btn>
            </p>
            <!-- 좋아요 안눌렀을때 -->
            <p v-else>
              <v-btn
                @click="toggleThumb()"
                class="thumbupwhite"
                color="white-2"
                icon="mdi-heart-outline"
                variant="text"
                :class="{ blue: !isBlue }"
              ></v-btn>
            </p>
          </button>
        </Transition>

        <h2 class="liketext">좋아요</h2>
      </div>
    </div>
  </div>
  <div class="songbutton">
    <v-btn size="large" rounded class="inner-btn"> 동요 미리듣기 </v-btn>
    <v-btn size="large" rounded class="inner-btn"> 동화 제작하기 </v-btn>
  </div>
  <v-container>
    <StoryBook />
  </v-container>
</template>

<style>
.leftcontent {
  width: 50%;
  height: 200px;
}

.rightcontent {
  width: 50%;
}

.textarea {
  width: 300px;
  height: 300px;
}

.songTitle {
  text-align: center;
}

.imgcontent {
  display: flex;
}

.songbutton {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.inner-btn {
  background-color: skyblue;
  margin: 30px;
}

.thumbupblue {
  color: skyblue;
}

.thumbupwhite {
}
.blue {
  color: skyblue;
}

.likeHeart {
  display: flex;
}

.likebtn {
}

.liketext {
  margin-top: 5px;
  align-items: center;
}
</style>
