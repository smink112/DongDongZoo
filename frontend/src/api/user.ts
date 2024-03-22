import { axiosInstance } from "@/utils/http-commons";
import { Authentication } from "@/types";
const instance = axiosInstance();

const API_URL = "/user";

function requestLogin(
  auth: Authentication,
  success: Function,
  error: Function
) {
  instance.post(`${API_URL}`, auth).then(success).catch(error);
}

export { requestLogin };
