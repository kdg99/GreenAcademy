<template>
  <h4>Components</h4>

  <div>
    <h4>Icons</h4>
    <v-icon icon="mdi-arrow-all"></v-icon>
    <v-divider class="my-5"></v-divider>
    <!-- y축 마진 5px-->

    <h4>Images</h4>
    <v-img
      :width="300"
      aspect-ratio="16/9"
      cover
      src="https://cdn.vuetifyjs.com/images/parallax/material.jpg"
    ></v-img>
    <h4>Images</h4>
    <v-img
      :width="300"
      aspect-ratio="16/9"
      cover
      src="https://cdn.vuetifyjs.com/images/parallax/material.jpg"
    ></v-img>
    <v-divider></v-divider>

    <h4>Buttonds</h4>
    <v-btn>Button1</v-btn>
    <v-btn color="primary">Button2</v-btn>
    <v-btn color="secondary">Button3</v-btn>
    <v-btn prepend-icon="mdi-vuetify">Button4</v-btn>
    <v-btn size="small">Button5</v-btn>
    <v-btn block>Button6</v-btn>

    <v-divider></v-divider>

    <h4>Cards</h4>
    <v-card class="my-2" title="Card title" subtitle="Subtitle" text="내용">
      <v-card-actions>
        <v-btn>확인</v-btn>
      </v-card-actions>
    </v-card>

    <v-card width="400">
      <v-img
        height="200"
        src="https://cdn.pixabay.com/photo/2020/07/12/07/47/bee-5396362_1280.jpg"
        cover
        class="text-white"
      >
        <v-card-item>
          <v-card-title>This is a title</v-card-title>

          <v-card-subtitle>This is a subtitle</v-card-subtitle>
        </v-card-item>
      </v-img>
      <v-card-text> This is content </v-card-text>
    </v-card>
    k<v-divider></v-divider>
  </div>
</template>

<script setup></script>

<style scoped></style>
