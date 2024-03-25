<script setup lang="ts"></script>
<template>
  <v-container class="container">
    <v-col cols="12" align="center" justify="center">
      <v-col>
        <v-img width="20%" src="@/assets/logo-1.svg" />
      </v-col>
      <v-col cols="5">
        <v-row rows="12">
          <v-col cols="12">
            <v-row
              ><v-col cols="12" align="start" class="label"> 아이디 </v-col>
              <v-col cols="12">
                <v-text-field
                  label="아이디를 입력해주세요."
                  variant="solo"
                ></v-text-field> </v-col
            ></v-row>
            <v-row
              ><v-col cols="12" align="start" class="label"> 비밀번호 </v-col>
              <v-col cols="12">
                <v-text-field
                  label="비밀번호를 입력해주세요."
                  variant="solo"
                ></v-text-field> </v-col
            ></v-row>
            <v-row
              ><v-col cols="12" align="start" class="label"> 이름 </v-col>
              <v-col cols="12">
                <v-text-field
                  label="이름입력"
                  variant="solo"
                ></v-text-field> </v-col
            ></v-row>
            <v-row
              ><v-col cols="12" align="start" class="label"> 생년월일 </v-col>
              <v-col cols="12">
                <v-text-field
                  label="YYYY/MM/DD"
                  variant="solo"
                ></v-text-field> </v-col
            ></v-row>
            <v-row
              ><v-col cols="12" align="start" class="label"> 이메일 </v-col>
              <v-col cols="12">
                <v-text-field
                  label="email@dongdongju.co.kr"
                  variant="solo"
                ></v-text-field> </v-col
            ></v-row>
            <v-row
              ><v-col cols="12" align="start" class="label"> 약관 </v-col>
              <v-col cols="12">
                <v-col
                  cols="8"
                  style="border: 1px solid lightgray; border-radius: 10px"
                >
                  <v-checkbox style="margin-top: -15px; margin-bottom: -20px"
                    ><template v-slot:label
                      >(필수) 개인정보 약관 동의</template
                    ></v-checkbox
                  >
                  <v-checkbox style="margin-top: -15px; margin-bottom: -20px"
                    ><template v-slot:label
                      >(필수) 개인정보 약관 동의</template
                    ></v-checkbox
                  >
                  <v-checkbox style="margin-top: -15px; margin-bottom: -20px"
                    ><template v-slot:label
                      >(선택) 개인정보 약관 동의</template
                    ></v-checkbox
                  >
                </v-col>
              </v-col>
            </v-row>
            <v-row>
              <v-col cols="12">
                <v-btn width="100%" size="large" style="margin-bottom: 300px"
                  >회원 가입하기</v-btn
                >
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-col>
    </v-col>
  </v-container>
</template>

<style scoped>
.label {
  padding: 0px;
  padding-left: 12px;
}
</style>
