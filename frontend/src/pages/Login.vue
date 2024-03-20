<script setup lang="ts"></script>
<template>
  <v-container class="container">
    <v-col cols="12" align="center" justify="center">
      <v-col>
        <v-img width="20%" src="@/assets/logo-1.svg" />
      </v-col>
      <v-col cols="6" align="center">
        <v-row rows="12">
          <v-col cols="9">
            <v-row align="center"
              ><v-col cols="3"> 아이디 </v-col>
              <v-col cols="9">
                <v-text-field
                  label="아이디를 입력해주세요."
                  variant="solo"
                ></v-text-field> </v-col
            ></v-row>
            <v-row align="center"
              ><v-col cols="3"> 비밀번호 </v-col>
              <v-col cols="9">
                <v-text-field
                  label="비밀번호를 입력해주세요."
                  variant="solo"
                ></v-text-field> </v-col
            ></v-row>
          </v-col>
          <v-col cols="2">
            <v-btn width="100%" height="88%">로그인</v-btn>
          </v-col>
        </v-row>
        <v-col cols="12" align="end">
          <v-col>
            <v-checkbox label="자동로그인" value="John"></v-checkbox>
          </v-col>
        </v-col>
        <v-row
          rows="12"
          justify="center"
          style="padding-left: 12px; padding-right: 12px"
        >
          <v-col cols="4"><v-btn width="100%">아이디 찾기</v-btn></v-col>
          <v-col cols="4"><v-btn width="100%">비밀번호 찾기</v-btn></v-col>
          <v-col cols="4"><v-btn width="100%">회원가입</v-btn></v-col>
        </v-row>
        <v-col> </v-col>
        <v-col>
          <v-btn width="100%">카카오 로그인</v-btn>
        </v-col>
        <v-col>
          <v-btn width="100%">구글 로그인</v-btn>
        </v-col>
        <v-col>
          <v-btn width="100%">네이버 로그인</v-btn>
        </v-col>
      </v-col>
    </v-col>
  </v-container>
</template>

<style scoped></style>
