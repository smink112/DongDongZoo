// Utilities
import { defineStore } from "pinia";
import { Authentication } from "@/types";
export const useAppStore = defineStore("app", {
  state: () => ({
    //
  }),
});

export const useUserStore = defineStore("user", {
  state: () => ({
    user: null,
  }),

  actions: {
    async fetchUser() {
      const res = await fetch("https://localhost:3000/user");

      const user = await res.json();
      this.user = user;
    },
    async signUp(authentication: Authentication) {
      const res = await fetch("https://localhost:3000/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ authentication }),
      });
      const user = await res.json();
      this.user = user;
    },
    async signIn(authentication: Authentication) {
      const res = await fetch("https://localhost:3000/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ authentication }),
      });
      const user = await res.json();
      this.user = user;
    },
  },
});
