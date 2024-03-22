import { defineStore } from "pinia";
import { Authentication, User, Song, RefSong } from "@/types";

export const SongStore = defineStore("song", {
  state: () => ({
    song: null as RefSong,
  }),
  actions: {
    async fetchDummyList() {
      const song = {
        id: 1,
        title: "퐁당퐁당",
        content: "퐁당퐁당 돌을 던지자 누나 몰래 던져",
      };
      this.song = song;
    },

    async fetchList() {
      const res = await fetch("https://localhost:3000/songs");

      const song = await res.json();
      this.song = song;
    },
  },
});
