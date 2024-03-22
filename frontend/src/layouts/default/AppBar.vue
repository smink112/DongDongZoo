<script lang="ts" setup>
import { RouterLink } from "vue-router";
import { ref, watch, onMounted } from "vue";
import { useUserStore } from "@/store/user";
import Auth from "@/components/appbar/Auth.vue";
import NotAuth from "@/components/appbar/NotAuth.vue";
const store = useUserStore();
store.fetchDummyUser();

const user = ref(store.user);
</script>
<template>
  <v-app-bar :elevation="0">
    <RouterLink to="/">
      <v-img
        class="logo"
        width="48px"
        height="48px"
        position="left"
        src="@/assets/logo-1.svg"
      />
    </RouterLink>
    <v-spacer />
    <RouterLink to="/songList">
      <v-btn text="서비스 사용하기"></v-btn>
    </RouterLink>
    <Auth v-if="user" :user="user" />
    <NotAuth v-else />
  </v-app-bar>
</template>
<style>
.logo {
  margin: 50px;
}
</style>
