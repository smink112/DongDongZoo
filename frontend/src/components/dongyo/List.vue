<script setup lang="ts">
import DongyoCard from "./DongyoCard.vue";
</script>

<template>
  <div class="dongyoTitle">
    <h1 style="">동요 리스트</h1>
  </div>

  <v-container class="list">
    <div class="dongyolist">
      <a v-for="dongyo in 10">
        <v-flex xs12 sm6 offset-sm3>
          <DongyoCard></DongyoCard>
        </v-flex>
      </a>
    </div>
  </v-container>
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
./DongyoCard.vue
