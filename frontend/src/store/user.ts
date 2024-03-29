import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { Authentication, SignUp, User } from "@/types";
import { requestLogin, requestSignUp } from "@/api/auth";
import { HttpStatusCode } from "axios";
export const useUserStore = defineStore(
  "user",
  () => {
    const user = ref<User>(null);
    const getUser = () => {
      return user.value;
    };
    const fetchDummyUser = async () => {
      const dummyUser = {
        id: 1,
        nickName: "동동이",
        profile: "1234",
      };
      user.value = dummyUser;
    };

    const postLogin = async (data: string, success: any, error: any) => {
      requestLogin(data, success, error);
    };
    const postSignUp = async (data: SignUp, success: any, error: any) => {
      requestSignUp(data, success, error);
    };
    const logout = () => {
      user.value = null;
    };
    return {
      fetchDummyUser,
      postLogin,
      postSignUp,
      logout,
      user,
      getUser,
    };
  },
  {
    persist: true,
  }
);
