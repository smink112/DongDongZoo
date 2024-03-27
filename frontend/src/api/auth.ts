import { axiosInstance } from "@/utils/http-commons";
import { Authentication } from "@/types";
const instance = axiosInstance();

const API_URL = "/auth";

function requestLogin(auth: Authentication, success: any, error: any) {
  instance.post(`${API_URL}/login`, auth).then(success).catch(error);
}

function requestLogout(auth: Authentication, success: any, error: any) {
  instance.post(`${API_URL}/logout`, auth).then(success).catch(error);
}

function requestSignUp(auth: Authentication, success: any, error: any) {
  instance.post(`${API_URL}/signup`, auth).then(success).catch(error);
}

export { requestLogin, requestLogout, requestSignUp };
