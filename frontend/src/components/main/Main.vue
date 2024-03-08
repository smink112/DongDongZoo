<script setup lang="ts">
import { ref, computed, toRefs, onMounted, onUnmounted } from "vue";

const showBanner1 = ref(false);
const showText1 = ref(false);
const showBanner2 = ref(false);
const showText2 = ref(false);
const showBanner3 = ref(false);
const showText3 = ref(false);
const showButtton = ref(false);

const doScroll = (event: any) => {
  const el = event.target.documentElement;
  const scrollTop = el.scrollTop;
  console.log(scrollTop);
  if (scrollTop > 100 && !showBanner1.value) {
    showBanner1.value = true;
  } else if (scrollTop > 50 && !showText1.value) {
    showText1.value = true;
  } else if (scrollTop > 350 && !showBanner2.value) {
    showBanner2.value = true;
  } else if (scrollTop > 500 && !showText2.value) {
    showText2.value = true;
  } else if (scrollTop > 900 && !showBanner3.value) {
    showBanner3.value = true;
  } else if (scrollTop > 900 && !showText3.value) {
    showText3.value = true;
  } else if (scrollTop > 1800 && !showButtton.value) {
    showButtton.value = true;
  }
};

onMounted(() => {
  window.addEventListener("scroll", doScroll);
  showBanner1.value = true;
});

onUnmounted(() => {
  window.removeEventListener("scroll", doScroll);
});
</script>

<template>
  <div style="flex-direction: column; display: flex; height: 1500px">
    <transition name="slide-fade">
      <div v-if="showBanner1" style="position: relative; opacity: 70%">
        <v-img src="@/assets/character_1.png">
          <transition name="slide-fade">
            <h1 v-if="showText1" class="inner-text">
              동동주 서비스를 활용하여 <br />동요를 동화로 만들어 보세요!
            </h1>
          </transition>
        </v-img>
      </div>
    </transition>
    <transition name="slide-fade">
      <div v-if="showBanner2" style="position: relative; opacity: 70%">
        <v-img src="@/assets/character_2.png">
          <transition name="slide-fade">
            <h1 v-if="showText2" class="inner-text">
              동화를 보며 아이들의 <br />상상력을 자극시켜봐요!
            </h1>
          </transition>
        </v-img>
      </div>
    </transition>
    <transition name="slide-fade">
      <div v-if="showBanner3" style="position: relative; opacity: 70%">
        <v-img src="@/assets/character_3.png">
          <transition name="slide-fade">
            <h1 v-if="showText3" class="inner-text">
              지금바로 서비스를 이용하세요!
            </h1>
          </transition>
          <transition name="slide-fade">
            <v-btn rounded class="inner-btn" v-if="showButtton">
              서비스 이용하기
            </v-btn>
          </transition>
        </v-img>
      </div>
    </transition>
  </div>
</template>

<style scoped>
.inner-text {
  color: white;
  margin-left: 100px;
  margin-top: 120px;
  font-size: 48px;
}
.inner-btn {
  width: 300px;
  height: 200px;
  position: absolute;
  top: 50%;
  margin-left: 100px;
}
.slide-fade-enter-active {
  transition: all 0.8s ease-out;
}

.slide-fade-leave-active {
  transition: all 0.8s cubic-bezier(1, 0.5, 0.8, 1);
}

.slide-fade-enter-from,
.slide-fade-leave-to {
  transform: translateY(20px);
  opacity: 0;
}
</style>
