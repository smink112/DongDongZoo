// Utilities
import { defineStore } from "pinia";
import { Authentication, User, Song, RefSong } from "@/types";
export const useAppStore = defineStore("app", {
  state: () => ({
    //
  }),
});

export const useUserStore = defineStore("user", {
  state: () => ({
    user: null as User,
  }),
  actions: {
    async fetchDummyUser() {
      const user = {
        id: 1,
        nickName: "동동이",
        profile: "1234",
      };
      this.user = user;
    },

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
