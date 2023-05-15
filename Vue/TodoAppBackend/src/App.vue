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
import { onBeforeMount } from "vue";
import axios from "axios";

const store = useStore();

onBeforeMount(() => {
    axios
        .get("http://kdg99.link:8103/TodoAppBackend/todo")
        .then((response) => {
            console.log(response);
            store.dispatch("setTodo", response.data);
        })
        .catch((error) => {
            console.log(error);
        });
});

const addTodoHandler = (value) => {
    store.dispatch("addTodo", value);
};
</script>

<style scoped></style>
