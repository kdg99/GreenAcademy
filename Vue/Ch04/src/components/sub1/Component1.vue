<template>
    <h4>Component1</h4>
    <p>
        message : {{ message }}
        <button @click="changeMessage">수정</button>
    </p>
    <p>
        count:{{ count }}
        <button @click="countUp">증가</button>
    </p>
    <p>
        name : {{ user.name }} <br />
        age : {{ user.age }} <br />
        addr : {{ user.addr }} <br />
    </p>
    <Component2 name="홍길동" age="21" addr="부산"></Component2>
    <Component3 v-on:myEvent="receiveUser"></Component3>
</template>
<script>
import Component2 from "./Component2.vue";
import Component3 from "./Component3.vue";

export default {
    name: "Component1",
    //기존 Options API를 통합한 Compoisition API
    setup() {
        //변수 선언(반응성[바인딩] 없음)
        let message = "Hello";
        let count = 0;
        let user = {
            name: "이순신",
            age: 22,
            addr: "부산",
        };
        //함수 선언
        function changeMessage() {
            message = "Welcome";
        }

        const countUp = function () {
            count++;
        };

        const receiveUser = (data) => {
            console.log("data name : " + data.name);
            console.log("data age : " + data.age);
        };

        // setup API 마지막에는 항상 return
        return {
            message,
            changeMessage,
            count,
            countUp,
            user,
            receiveUser,
        };
    },
    components: {
        Component2,
        Component3,
    },
};
</script>
<style scoped></style>
