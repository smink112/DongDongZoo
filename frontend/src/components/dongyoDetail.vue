<script setup lang="ts">
import { ref, watch, onMounted } from "vue";
import { DongyoStore } from "@/store/app";

const store = DongyoStore();
store.fetchDummyList();

const dongyo = ref(store.dongyo);

console.log(dongyo);
</script>

<template>
  <div>
    <v-card class="dongyocard" @click="">
      <v-img class="white--text" height="200px" src="@/assets/dongyo1.png">
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
          <span class="grey--text"> {{ dongyo?.title }} </span><br />
          <span class="dongyo_content"
            ><div></div>
            {{ dongyo?.content }}</span
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
.dongyocard {
  width: 300px;
  height: 300px;
  margin: 20px;
}
</style>
