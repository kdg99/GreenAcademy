<template>
  <h4>Grids</h4>
  <v-container fluid>
    <h4>Grid 기본</h4>
    <v-row>
      <v-col cols="12" class="border text-center">12</v-col>
    </v-row>
    <v-row class="mt-4">
      <v-col cols="6" class="border text-center">6</v-col>
      <v-col cols="6" class="border text-center">6</v-col>
    </v-row>
    <v-row class="mt-4">
      <v-col cols="4" class="border text-center">4</v-col>
      <v-col cols="4" class="border text-center">4</v-col>
      <v-col cols="4" class="border text-center">4</v-col>
    </v-row>
    <v-row class="mt-4">
      <v-col cols="3" class="border text-center">3</v-col>
      <v-col cols="3" class="border text-center">3</v-col>
      <v-col cols="3" class="border text-center">3</v-col>
      <v-col cols="3" class="border text-center">3</v-col>
      <v-col cols="3" class="border text-center">3</v-col>
    </v-row>
    <v-row class="mt-5">
      <v-col cols="5" class="border text-center">5</v-col>
      <v-col cols="5" class="border text-center">5</v-col>
      <v-col cols="5" class="border text-center">5</v-col>
      <v-col cols="2" class="border text-center">2</v-col>
    </v-row>
    <!-- 범위 벗어나는 경우 늘어날 때는 체크 X 줄어들 때만 체크 -->
    <v-row class="mt-4">
      <v-col cols="12" xl="4" md="6" class="border text-center">sm1</v-col>
      <v-col cols="12" xl="4" md="6" class="border text-center">sm2</v-col>
      <v-col cols="12" xl="4" md="6" class="border text-center">sm3</v-col>
    </v-row>
  </v-container>
  <h4>반응형 레이아웃</h4>
  <v-container fluid>
    <v-row>
      <v-col class="border text-center" cols="12" md="6" lg="3">column1</v-col>
      <v-col class="border text-center" cols="12" md="6" lg="3">column2</v-col>
      <v-col class="border text-center" cols="12" md="6" lg="3">column3</v-col>
      <v-col class="border text-center" cols="12" md="6" lg="3">column4</v-col>
    </v-row>
  </v-container>
</template>

<script setup></script>

<style scoped></style>
