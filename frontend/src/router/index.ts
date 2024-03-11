/**
 * router/index.ts
 *
 * Automatic routes for `./src/pages/*.vue`
 */

// Composables
import { createRouter, createWebHistory } from "vue-router/auto";
import { setupLayouts } from "virtual:generated-layouts";
import index from "@/pages/index.vue";
import Login from "@/pages/Login.vue";
import SignUp from "@/pages/SignUp.vue";
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
      component: Login,
    },
    {
      path: "/signup",
      name: "signup",
      component: SignUp,
    },
    {
      path: "/mypage",
      name: "mypage",
      component: index,
    },
  ],
});

export default router;
