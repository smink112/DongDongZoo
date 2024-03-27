import { createRouter, createWebHistory, useRoute } from "vue-router";
import index from "@/pages/index.vue";
import SongList from "@/pages/SongList.vue";
import SongDetail from "@/pages/SongDetail.vue";

import Login from "@/pages/Login.vue";
import SignUp from "@/pages/SignUp.vue";
import { useUserStore } from "@/store/app";
import { RouteRecordRaw } from "vue-router";

const routes = [
  {
    path: "/",
    name: "home",
    component: index,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/login",
    name: "login",
    component: Login,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/signup",
    name: "signup",
    component: SignUp,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/songList",
    name: "songList",
    component: SongList,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/songDetail",
    name: "songDetail",
    component: SongDetail,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/mypage",
    name: "mypage",
    component: index,
    meta: {
      requiresAuth: false,
    },
  },
] as RouteRecordRaw[];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  const route = useRoute();

  if (to.meta.requiresAuth !== undefined) {
    const userStore = useUserStore();
    if (to.matched.some((record) => record.meta.requiresAuth)) {
      if (userStore.user == null) {
        next("/login");
      } else {
        next();
      }
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router;
