<template>
    <h4>MyComponent1</h4>
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
        <button @click="changeUser">변경</button>
    </p>
    <p>신라사람</p>
    <ul>
        <li v-for="person in sillaPerson">{{ person.name }}</li>
    </ul>
    <p>조선사람</p>
    <ul>
        <li v-for="person in josunPerson">{{ person.name }}</li>
    </ul>

    <p>
        result : {{ result }} result2x : {{ result2x }}
        <button @click="resultUp">증가</button>
    </p>
</template>
<script>
import { ref, reactive, computed, watch } from "vue";

export default {
    name: "MyComponent1",
    setup() {
        //변수 선언(반응성을 갖는 상태값)
        //ref() -> 기본타입을 반응형으로 처리 API
        // reactive() -> 참조타입을 반응형으로 처리 API(생략 가능 json등 객체는 기본적으로 반응성)
        const message = ref("Hello");
        const count = ref(0);
        const user = reactive({
            name: "홍길동",
            age: 21,
            addr: "부산",
        });

        const users = reactive([
            { id: 1, name: "김유신" },
            { id: 2, name: "김춘추" },
            { id: 3, name: "장보고" },
            { id: 4, name: "정약용" },
            { id: 5, name: "이순신" },
        ]);

        const result = ref(10);

        //함수 정의
        function changeMessage() {
            //ref반응형 변수의 값 참조는 value
            message.value = "Welcome";
        }

        const countUp = function () {
            count.value++;
        };

        const changeUser = () => {
            user.name = "김유신";
            user.age = 24;
            user.addr = "마산";
        };

        const sillaPerson = computed(() => {
            return users.filter((user) => {
                return user.id <= 3;
            });
        });
        const josunPerson = computed(() => users.filter((user) => user.id > 3));

        const resultUp = function () {
            result.value++;
        };
        const result2x = computed(() => {
            return result.value * 2;
        });

        //watch API
        watch(result, (current, prev) => {
            console.log("이전 값 : " + prev);
            console.log("현재 값 : " + current);
        });

        return {
            message,
            changeMessage,
            count,
            countUp,
            user,
            changeUser,
            sillaPerson,
            josunPerson,
            result,
            resultUp,
            result2x,
        };
    },
};
</script>
<style scoped></style>
