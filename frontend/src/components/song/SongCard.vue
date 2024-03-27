<script setup lang="ts">
import { ref, watch, onMounted } from "vue";
import { SongStore } from "@/store/app";
import { useStoryStore } from "@/store/story";
const storyStore = useStoryStore();

storyStore.getStories(
  (res) => {
    console.log(res.data);
  },
  (error) => {
    console.log(error);
  }
);

const store = SongStore();
store.fetchDummyList();

const song = ref(store.song);

console.log(song);
</script>

<template>
  <div>
    <v-card class="songcard" @click="$router.push('/songDetail')">
      <v-img class="white--text" height="200px" src="@/assets/song.png">
        <v-container fill-height fluid>
          <v-layout fill-height>
            <v-flex xs12 align-end flexbox>
              <span class="headline"></span>
            </v-flex>
          </v-layout>
        </v-container>
      </v-img>
      <v-card-title>
        <div>
          <span class="grey--text"> {{ song!.title }} </span><br />
          <span class="song_content"
            ><div></div>
            {{ song!.content }}</span
          ><br />
          <span>Last updated 5mins ago</span>
        </div>
      </v-card-title>
      <!-- <v-card-actions>
                  <v-btn flat color="orange">Share</v-btn>
                  <v-btn flat color="orange">Explore</v-btn>
                </v-card-actions> -->
    </v-card>
  </div>
</template>

<style scoped>
.songcard {
  width: 300px;
  height: 300px;
  margin: 20px;
}
</style>
