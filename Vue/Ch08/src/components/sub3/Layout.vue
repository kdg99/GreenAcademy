<template>
  <v-app>
    <v-app-bar app>Layout 실습</v-app-bar>
    <v-navigation-drawer>메뉴</v-navigation-drawer>
    <v-main>
      <v-container>
        내용
        <router-link to="/">main</router-link>
      </v-container>
    </v-main>
    <v-footer app> 푸터 내용</v-footer>
  </v-app>
</template>

<script setup></script>

<style scoped></style>
