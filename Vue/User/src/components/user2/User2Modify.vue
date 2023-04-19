<template>
    <h4>User1 수정</h4>
    <form @submit.prevent="user2Modify">
        <table border="1">
            <tr>
                <td>아이디</td>
                <td><input type="text" v-model="user.uid" readonly /></td>
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
                    <input type="submit" value="수정" />
                </td>
            </tr>
        </table>
    </form>
</template>

<script setup>
import axios from "axios";
import { ref, reactive, onBeforeMount } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();
const store = useStore();
const user = ref({});

onBeforeMount(() => {
    user.value = store.getters.getUser;
});

const user2Modify = () => {
    axios
        .put("http://localhost:8080/Ch09/user1", user.value)
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
