import { defineStore } from "pinia";
import { requestGetSong, requestGetSongs } from "@/api/song";

export const useSongStore = defineStore("song", () => {
  const getSong = (id: number, success: any, error: any) => {
    requestGetSong(id, success, error);
  };
  const getSongs = (success: any, error: any) => {
    requestGetSongs(success, error);
  };

  return { getSong, getSongs };
});
