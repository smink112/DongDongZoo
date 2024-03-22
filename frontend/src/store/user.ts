import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { Authentication, User } from "@/types";
import { requestLogin } from "@/api/user";
export const useUserStore = defineStore("user", () => {
  const user = ref<User>(null);

  const fetchDummyUser = async () => {
    const dummyUser = {
      id: 1,
      nickName: "동동이",
      profile: "1234",
    };
    user.value = dummyUser;
  };

  const fetchLogin = async (auth: Authentication) => {
    requestLogin(
      auth,
      (res: any) => {
        // process login
      },
      (error: any) => {
        // process error
      }
    );
  };
  return {
    fetchDummyUser,
    fetchLogin,
    user,
  };
});
