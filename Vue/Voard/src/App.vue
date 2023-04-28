<template>
  <router-view></router-view>
</template>

<script setup>
import { onBeforeMount } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";
import { useStore } from "vuex";
const router = useRouter();
const userStore = useStore();
onBeforeMount(() => {
  const accessToken = localStorage.getItem("accessToken");
  if (accessToken != null) {
    axios
      .get("/user/auth", {
        headers: { "X-AUTH-TOKEN": accessToken },
      })
      .then((response) => {
        console.log(response);
        const user = response.data.user;
        if (user != null) {
          userStore.dispatch("setUser", user);
          router.push("/list");
        } else {
          router.push("/user/login");
        }
      })
      .catch((error) => {
        console.log(error);
        router.push("/user/login");
      });
  } else {
    router.push("/user/login");
  }
});
</script>
