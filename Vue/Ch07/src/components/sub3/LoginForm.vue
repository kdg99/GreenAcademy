<template>
    <h4>로그인</h4>
    <form @submit.prevent="loginProc">
        <table border="1">
            <tr>
                <td>아이디</td>
                <td><input type="text" v-model="user.uid" /></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" v-model="user.pass" /></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="로그인" />
                </td>
            </tr>
        </table>
    </form>
</template>

<script setup>
import { reactive } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import axios from "axios";

const router = useRouter();
const store = useStore();

const user = reactive({
    uid: "",
    pass: "",
});

const loginProc = () => {
    //dispatch에서 return받은 promise값이 성공이면 then, 실패면 catch
    store
        .dispatch("login", user)
        .then((response) => {
            //로그인 성공
            router.push("/jwt/loginSuccess");
        })
        .catch((error) => {
            alert("로그인 실패");
        });
};
</script>

<style scoped></style>
