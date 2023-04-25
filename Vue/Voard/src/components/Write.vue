<template>
  <v-app>
    <v-app-bar>
      <v-app-bar-title>쓰기</v-app-bar-title>
    </v-app-bar>
    <v-main>
      <v-container>
        <v-sheet max-width="800" class="mx-auto mt-16" border>
          <div id="app">
            <ckeditor
              :editor="editor"
              v-model="editorData"
              :config="editorConfig"
            ></ckeditor>
          </div>
        </v-sheet>

        <v-sheet max-width="800" class="mx-auto text-right">
          <v-btn @click="btnCancel">취소</v-btn>
          <v-btn class="ml-2" color="primary" @click="btnWrite">작성</v-btn>
        </v-sheet>
      </v-container>
    </v-main>
    <v-footer app theme="dark">copyright &copy;Voard v1.0</v-footer>
  </v-app>
</template>

<script setup>
import { useRouter } from "vue-router";
const router = useRouter();

const btnCancel = () => {
  router.push("/list");
};

const btnWrite = () => {
  router.push("/list");
};

//editor
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";

const editor = ClassicEditor;
const editorData = "<p>Content of the editor.</p>";
</script>

<style scoped></style>
