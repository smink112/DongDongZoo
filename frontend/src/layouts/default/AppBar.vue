<script lang="ts" setup>
import { RouterLink } from "vue-router";
import { ref, watch, onMounted } from "vue";
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
    <RouterLink to="/">
      <v-btn text="서비스 사용하기"></v-btn>
    </RouterLink>
    <RouterLink to="/login">
      <v-btn text="로그인"></v-btn>
    </RouterLink>
    <RouterLink to="/signup">
      <v-btn text="회원가입"></v-btn>
    </RouterLink>
  </v-app-bar>
</template>
<style>
.logo {
  margin: 50px;
}
</style>
