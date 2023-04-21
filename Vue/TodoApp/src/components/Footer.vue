<template>
    <footer>
        <button @click="btnClear">Clear All</button>
    </footer>
</template>

<script setup>
import { useStore } from "vuex";
const store = useStore();

const btnClear = () => {
    store.dispatch("clearTodo");
};
</script>

<style scoped>
footer {
    width: 100%;
    height: auto;
    text-align: center;
}
footer > button {
    width: 100px;
    height: 30px;
    color: #e20303;
}
</style>
