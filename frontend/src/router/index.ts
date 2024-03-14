import { createRouter, createWebHistory } from "vue-router";
import index from "@/pages/index.vue";
import Login from "@/pages/Login.vue";
import SignUp from "@/pages/SignUp.vue";
import { useUserStore } from "@/store/app";
import { useLoadingStore } from "@/store/loading";
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
  const loadingStore = useLoadingStore();
  loadingStore.contentLoading();

  if (to.meta.requiresAuth !== undefined) {
    const userStore = useUserStore();
    if (to.matched.some((record) => record.meta.requiresAuth)) {
      if (userStore.user == null) {
        next({
          path: "/login",
          query: { redirect: to.fullPath },
          component: Login,
        });
      } else {
        next();
      }
    } else {
      next();
    }
  }
});

export default router;
