<template>
    <h3>TodoApp</h3>
    <Header v-on:addTodo="addTodoHandler"></Header>
    <Main></Main>
    <Footer></Footer>
</template>

<script setup>
import Header from "./components/Header.vue";
import Footer from "./components/Footer.vue";
import Main from "./components/Main.vue";
import { useStore } from "vuex";

const store = useStore();
let todolog = localStorage.getItem("todolog")?.split(",");
if (todolog != null && todolog[0] != "") {
    store.dispatch("setTodo", todolog);
}

const addTodoHandler = (value) => {
    store.dispatch("addTodo", value);
};
</script>

<style scoped></style>
