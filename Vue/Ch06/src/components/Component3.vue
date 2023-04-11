<template>
    <h4>Component3</h4>
    <p>Vuex count : {{ store.state.count }}</p>
    <input type="number" v-model="count" />
    <button @click="btnInit">초기화</button>
</template>

<script setup>
import { ref } from "vue";
import { useStore } from "vuex";
const store = useStore();
const count = ref(0);

const btnInit = () => {
    store.dispatch("initCount", count);
};
</script>

<style scoped></style>
