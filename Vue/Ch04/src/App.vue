<template>
    <h3>Ch04.Composition API 실습</h3>

    <h4>1)setup</h4>
    <Component1></Component1>
    <hr />

    <h4>2)Reactivity</h4>
    <MyComponent1></MyComponent1>
    <hr />

    <h4>3)LifeCycle Hooks</h4>
    <HooksComponent v-if="isShow"></HooksComponent>
    <button @click="btnToggle">컴포넌트 {{ status }}</button>
    <hr />

    <h4>4)Dependency Injection</h4>
    <DIComponent></DIComponent>
    <hr />
</template>

<script>
/*
날짜 : 2023/04/06
이름 : 김동근
내용 : Ch04. Composition API

*/
import { ref, provide, reactive } from "vue";
import Component1 from "./components/sub1/Component1.vue";
import MyComponent1 from "./components/sub2/MyComponent1.vue";
import HooksComponent from "./components/sub3/HooksComponent.vue";
import DIComponent from "./components/sub4/DIComponent1.vue";

export default {
    name: "App",
    components: { Component1, MyComponent1, HooksComponent, DIComponent },
    setup() {
        const isShow = ref(true);
        const status = ref("삭제");

        const user = reactive({
            name: "김유신",
            age: 23,
            addr: "김해시",
        });
        //App 컴포넌트 하위 모든 컴포넌트에서 inject를 통해 user 참조 가능
        provide("user", user);

        const btnToggle = () => {
            if (isShow.value) {
                isShow.value = false;
                status.value = "생성";
            } else {
                isShow.value = true;
                status.value = "삭제";
            }
        };
        return {
            isShow,
            status,
            btnToggle,
        };
    },
};
</script>
