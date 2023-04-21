<template>
    <main>
        <ul>
            <Item
                @removeItem="removeItemHandler(index)"
                v-for="(todo, index) in todos"
                v-bind:data="todo"
                v-bind:index="index"
            />
        </ul>
    </main>
</template>

<script setup>
//
import Item from "./Item.vue";
import { useStore } from "vuex";
import { computed } from "vue";
const store = useStore();
const todos = computed(() => {
    return store.getters.getTodos;
});

//
const removeItemHandler = (index) => {
    store.dispatch("removeTodo", index);
};
</script>

<style>
main {
    width: 100%;
    height: auto;
}
main > ul {
    width: 100%;
    height: auto;
    list-style: none;
    padding-left: 0;
    box-sizing: border-box;
}
main > ul > li {
    width: 100%;
    height: 40px;
    line-height: 40px;
    padding-left: 6px;
    margin: 6px 0;
    box-sizing: border-box;
    background-color: white;
}
main > ul > li > button {
    float: right;
    width: 40px;
    height: 40px;
    border: none;
    color: #de4343;
}
</style>
