/**
 * router/index.ts
 *
 * Automatic routes for `./src/pages/*.vue`
 */

// Composables
import { createRouter, createWebHistory } from "vue-router/auto";
import { setupLayouts } from "virtual:generated-layouts";
import index from "@/pages/index.vue";
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  extendRoutes: setupLayouts,
  routes: [
    {
      path: "/",
      name: "home",
      component: index,
    },
    {
      path: "/login",
      name: "login",
      component: index,
    },
    {
      path: "/signup",
      name: "signup",
      component: index,
    },
    {
      path: "/mypage",
      name: "mypage",
      component: index,
    },
  ],
});

export default router;
