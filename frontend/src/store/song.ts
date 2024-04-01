import { defineStore } from "pinia";
import { requestGetSong, requestGetSongs, requestCreateSong } from "@/api/song";

export const useSongStore = defineStore("song", () => {
  const getSong = (id: string, success: any, error: any) => {
    requestGetSong(id, success, error);
  };
  const getSongs = (success: any, error: any) => {
    requestGetSongs(success, error);
  };
  const createSong = (id: string, success: any, error: any) => {
    requestCreateSong(id, success, error);
  };

  return { getSong, getSongs, createSong };
});
