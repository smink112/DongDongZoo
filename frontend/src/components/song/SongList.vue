<script setup lang="ts">
import SongCard from "./SongCard.vue";
</script>

<template>
  <div class="songTitle">
    <h1 style="">동요 리스트</h1>
  </div>

  <v-container class="list">
    <div class="songlist">
      <a v-for="song in 10">
        <v-flex xs12 sm6 offset-sm3>
          <SongCard></SongCard>
        </v-flex>
      </a>
    </div>
  </v-container>
</template>

<style scoped>
.songTitle {
  text-align: center;
}

.list {
  justify-content: center;
}

.songlist {
  display: grid;
  justify-content: center;
  grid-template-columns: repeat(4, 1fr);
}

.song_content {
  width: 50px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.songcard {
  width: 300px;
  height: 300px;
  margin: 20px;
}
</style>
