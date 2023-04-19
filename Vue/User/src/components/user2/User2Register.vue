<template>
    <h4>User2 등록</h4>
    <form @submit.prevent="user2Register">
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
import { useRouter } from "vue-router";
const router = useRouter();

//임시로 저장할 유저 객체 -> 반응성 필요X
const user = {
    uid: "",
    name: "",
    hp: "",
    age: 0,
};

const user2Register = () => {
    axios
        .post("http://localhost:8080/Ch09/user1", user)
        .then((response) => {
            console.log(response);
            router.push("/user2/list");
        })
        .catch((error) => {
            console.log(error);
        });
};
</script>

<style scoped></style>
