import { axiosInstance } from "@/utils/http-commons";

const instance = axiosInstance();

const API_URL = "/songs";

function requestGetSongs(success: any, error: any) {
  instance.get(`${API_URL}`).then(success).catch(error);
}

function requestGetSong(id: number, success: any, error: any) {
  instance.get(`${API_URL}/${id}`).then(success).catch(error);
}

export { requestGetSong, requestGetSongs };
