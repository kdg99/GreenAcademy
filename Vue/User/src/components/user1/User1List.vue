<template>
    <h4>User1 목록</h4>
    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>휴대폰</th>
            <th>나이</th>
            <th>관리</th>
        </tr>
        <tr v-for="user in users">
            <td>{{ user.uid }}</td>
            <td>{{ user.name }}</td>
            <td>{{ user.hp }}</td>
            <td>{{ user.age }}</td>
            <td>
                <a href="#" @click.prevent="modifyUser(user)">수정</a> /
                <a href="#" @click.prevent="deleteUser(user.uid)">삭제</a>
            </td>
        </tr>
    </table>
</template>

<script setup>
import { onBeforeMount, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const router = useRouter();
const users = ref([]);

const modifyUser = (user) => {
    router.push({ name: "User1Modify", params: user });
};
const deleteUser = (uid) => {
    if (confirm("삭제?")) {
        axios
            .delete(`http://localhost:8080/Ch09/user1/${uid}`)
            .then((response) => {
                alert("삭제성공");
                users.value = response.data;
            })
            .catch((error) => {
                console.log(error);
            });
    }
};

onBeforeMount(() => {
    axios
        .get("http://localhost:8080/Ch09/user1s")
        .then((response) => {
            console.log(response);
            users.value = response.data;
        })
        .catch((error) => {
            console.log(error);
        });
});
</script>

<style scoped></style>
