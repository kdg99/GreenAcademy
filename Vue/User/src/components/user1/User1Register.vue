<template>
    <h4>User1 등록</h4>
    <form @submit.prevent="user1Register">
        <table border="1">
            <tr>
                <td>아이디</td>
                <td><input type="text" v-model="user.uid" /></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" v-model="user.name" /></td>
            </tr>
            <tr>
                <td>휴대폰</td>
                <td><input type="text" v-model="user.hp" /></td>
            </tr>
            <tr>
                <td>나이</td>
                <td><input type="text" v-model="user.age" /></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="등록" />
                </td>
            </tr>
        </table>
    </form>
</template>

<script setup>
import axios from "axios";
import { reactive } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();

const user = reactive({
    uid: "",
    name: "",
    hp: "",
    age: 0,
});

const user1Register = () => {
    axios
        .post("http://localhost:8080/Ch09/user1", user)
        .then((response) => {
            alert("등록완료!");
            router.push("/user1/list");
        })
        .catch((error) => {
            console.log(error);
        });
};
</script>

<style scoped></style>
