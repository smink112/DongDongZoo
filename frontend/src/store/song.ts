import { defineStore } from "pinia";
import { Authentication, User, Song, RefSong } from "@/types";
import { requestGetSongs } from "@/api/song";
import { ref } from "vue";

export const SongStore = defineStore("song", () => {
  const song = ref<Song>(); // null처리 해야하는지? 체크

  const fetchDummyList = async () => {
    const DummySong = {
      songId: 1,
      songName: "퐁당퐁당",
      songImageUrl: "사진 url이요",
      views: 152,
      likeCount: 0,
    };

    song.value = DummySong;
  };

  const fetchSongs = async (song: RefSong) => {
    requestGetSongs(
      (res: any) => {
        // process song data
        song.value = res;
      },
      (error: any) => {
        // process error
      }
    );
  };
  return {
    fetchDummyList,
    fetchSongs,
    song,
  };
});
