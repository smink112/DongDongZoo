// Utilities
import { defineStore } from "pinia";
import { Authentication, User, Dongyo } from "@/types";
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

export const DongyoStore = defineStore("dongyo",{
  state: () => ({
     dongyo: null as Dongyo,
  }),
  actions:{
    async fetchDummyList() {
      const dongyo = {
        id : 1,
        title: "퐁당퐁당",
        content: "퐁당퐁당 돌을 던지자"
      };
      this.dongyo = dongyo;
    },

    async fetchList() {
      const res = await fetch("https://localhost:3000/songs");

      const dongyo = await res.json();
      this.dongyo = dongyo;
    },
  }
});