<template>
    <h4>로그인 성공</h4>
    <p>
        {{ user.nick }}님 반갑습니다. <br />
        <a href="#" @click.prevent="logout">로그아웃</a>
    </p>
</template>

<script setup>
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { computed } from "vue";

const router = useRouter();
const store = useStore();
//비동기 때문에 값 바뀐 뒤에 불러오도록 computed 처리
const user = computed(() => {
    return store.getters.getUser;
});

const logout = () => {
    localStorage.removeItem("accessToken");
    router.push("/jwt/loginForm");
};
</script>

<style scoped></style>
