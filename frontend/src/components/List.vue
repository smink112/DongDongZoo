<script setup lang="ts">
import { defineProps, ref, watch, onMounted } from "vue";
import type { Dongyo } from "@/types";
import dongyoDetail from "./dongyoDetail.vue";

// const props = defineProps<Dongyo>();

const dongyo = ref<Dongyo>();

const Lists = ref([
  {
    id: 1,
    title: "섬짓아기동화",
    content: "엄마가 섬그늘에 굴따러가면",
    img: "@/assets/dongyo1.png",
  },
  {
    id: 2,
    title: "퐁당퐁당",
    content: "퐁당퐁당 돌을 던지자 누나에게 돌을 던지자",
    img: "@/assets/dongyo1.png",
  },
  {
    id: 3,
    title: "멋쟁이 토마토",
    content: "울퉁불퉁 멋진 몸매에",
    img: "@/assets/dongyo1.png",
  },
  {
    id: 4,
    title: "섬짓아기동화",
    content: "엄마가 섬그늘에 굴따러가면",
    img: "@/assets/dongyo1.png",
  },
  {
    id: 5,
    title: "퐁당퐁당",
    content: "퐁당퐁당 돌을 던지자 누나에게 돌을 던지자",
    img: "@/assets/dongyo1.png",
  },
  {
    id: 6,
    title: "멋쟁이 토마토",
    content: "울퉁불퉁 멋진 몸매에",
    img: "@/assets/dongyo1.png",
  },
]);
</script>

<template>
  <div class="dongyoTitle">
    <h1 style="">동요 리스트</h1>
  </div>

  <v-layout class="list">
    <div class="dongyolist">
      <a v-for="dongyo in Lists" :key="dongyo.id">
        <v-flex xs12 sm6 offset-sm3>
          <dongyoDetail></dongyoDetail>
        </v-flex>
      </a>
    </div>
  </v-layout>
</template>

<style scoped>
.dongyoTitle {
  text-align: center;
}

.list {
  justify-content: center;
}

.dongyolist {
  display: grid;
  justify-content: center;
  grid-template-columns: repeat(4, 1fr);
}

.dongyo_content {
  width: 50px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.dongyocard {
  width: 300px;
  height: 300px;
  margin: 20px;
}
</style>
