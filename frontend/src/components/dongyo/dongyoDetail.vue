<script setup lang="ts">
const message =
  "퐁당 퐁당 돌을 던지자 누나 몰래 돌을 던지자 냇물아 퍼져라 멀리멀리 퍼져라 건너편에 앉아서 나물을 씻는 우리누나 손등을 간질어 주어라";

const isBlue = false;

function toggleThumb() {
  this.isBlue = !this.isBlue;
  console.log(this.isBlue);
}
</script>

<template>
  <div class="dongyoTitle">
    <h1 style="">동요 제목</h1>
  </div>
  <div class="imgcontent">
    <v-img class="leftcontent" src="@/assets/dongyo1.png"></v-img>
    <div class="rightcontent">
      <h2>가사</h2>
      <textarea
        class="textarea"
        v-model="message"
        placeholder="여러줄을 입력해보세요"
      ></textarea>
      <div>
        <v-btn
          class="thumbupblue"
          :class="{ blue: isBlue }"
          icon="mdi-thumb-up"
          variant="text"
        ></v-btn>
        <v-btn
          @click="toggleThumb()"
          class="thumbupwhite"
          color="white-2"
          icon="mdi-thumb-up"
          variant="text"
          :class="{ blue: !isBlue }"
        ></v-btn>
        <div :class="{ blue: isBlue }">{{ isBlue }}</div>
        <h2>좋아요</h2>
      </div>
    </div>
  </div>
  <div class="dongyobutton">
    <v-btn size="large" rounded class="inner-btn"> 동요 미리듣기 </v-btn>
    <v-btn size="large" rounded class="inner-btn"> 동화 제작하기 </v-btn>
  </div>
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

.dongyoTitle {
  text-align: center;
}

.imgcontent {
  display: flex;
}

.dongyobutton {
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
</style>
