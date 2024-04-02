# SSAFY Project : 동동주
<img width="100" height="100" src="./exec/images/ssafyLogo.png">
<img height="100" src="./exec/images/logo.png">

### 삼성청년소프트웨어아카데미(SSAFY) AI 특화 프로젝트

### 동동주 - 동화 동요의 주인공이 되어봐요

### 개발 기간 : 2024.02.26.~2024.04.04 (6주)


<br>
<br>

## 팀 구성

* [고승민](https://github.com/smink112) - 팀장, INFRA(서버 환경 구축), Backend (동요 리스트, 동요 상세, 좋아요, DB)
* [김기찬](https://github.com/TearofCoding) - 팀원, AI(prompt 커스터마이징), Backend (동요 기반 동화 생성)
* [박현우](https://github.com/gogoadl) - 팀원, Backend (메인 페이지, 로그인 페이지, 동요 목록 페이지, 동요 상세 페이지)
* [유제훈](https://github.com/JehunYoo) - 팀원, Backend (인증, 로그인, 회원가입, 좋아요 동요 목록)
* [차승윤](https://github.com/sycha11) - 팀원, Frontend (동화 제작 페이지, 동화 페이지, 동요 좋아요 목록 페이지)

<br>
<br>

## 프로젝트 소개
:star: 동요를 들을 때, 청각적요소 뿐만 아니라 시각적 요소가 동반된다면 아이들이 동요를 더 잘 들을 수 있단 생각에 시작하였습니다.

:star: 사용자가 직접 제공된 동요를 선택하고 선택한 키워드를 바탕으로 새로운 이미지를 생성하여 이미지와 함께 동요를 재생할 수 있는 서비스를 개발하였습니다.

<br>
<br>

## 프로젝트 주요 기능
:star: 동요를 바탕으로 동화책의 이미지를 제공합니다.

:star: 사용자가 선택한 태그에 따라서 동화를 생성합니다.

<br>
<br>

## 페이지 구성









<br>
<br>

## 사용 기술 스택
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 간편한 설정, 객체 지향 프로그래밍

<img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"> 인증, 로그인

<img src="https://img.shields.io/badge/jpa-6DB33F?style=for-the-badge&logo=jpa&logoColor=white">  객체 지향 프로그래밍

<img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white">   가볍고 유연한 프론트엔드 프레임워크

<img src="https://img.shields.io/badge/vuetify-1867C0?style=for-the-badge&logo=mysql&logoColor=white"> 그리드 시스템 사용을 위해 채택

<img src="https://img.shields.io/badge/typescript-3178C6?style=for-the-badge&logo=typescript&logoColor=white"> 오류 검출 및 유지보수성 향상을 위해 채택

<img src="https://img.shields.io/badge/turnjs-6DB33F?style=for-the-badge&logo=turnjs&logoColor=white"> 동화책을 넘기는 UI를 표현하기 위해 사용

<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 기본 서버 데이터베이스로 사용하여 데이터를 안전하게 저장, 관리

<img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white"> 토큰 저장

<img src="https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white"> CI/CD 구축

<img src="https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=white"> Vue Client Server, SpringBoot Server 배포

<img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"> 이미지, 컨테이너 등을 활용하여 편리한 서버 환경 구축


<br>
<br>

## 시스템 아키텍처
![SystemArchitecture](./exec/images/SystemArchitecture.png)

<br>
<br>

## ERD
![ERD](./exec/images/DongDongZooERD.png)


## 프로젝트 회고
이러한점이 잘 되었다~ 너무 좋았다~

이런건 또 아쉽더라~

초기에 기획한 **사용자 이미지와 생성된 이미지를 합성**하여 **사용자가 주인공이 되는 기능**이 Karlo의 일부 서비스가 종료되어 구현하지 못한점이 아쉽습니다.