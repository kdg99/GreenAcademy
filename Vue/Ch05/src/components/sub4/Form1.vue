<template>
    <main>
        <h4>Form1</h4>
        <form v-on:submit.prevent="submitHandler">
            <table border="1">
                <tr>
                    <td>아이디</td>
                    <td><input v-model="user.uid" type="text" /></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input v-model="user.name" type="text" /></td>
                </tr>
                <tr>
                    <td>나이</td>
                    <td><input v-model="user.age" type="number" /></td>
                </tr>

                <tr>
                    <td>주소</td>
                    <td>
                        <select v-model="user.addr">
                            <option value="서울">서울</option>
                            <option value="부산">부산</option>
                            <option value="대전">대전</option>
                            <option value="대구">대구</option>
                            <option value="광주">광주</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="전송" />
                    </td>
                </tr>
            </table>
        </form>
    </main>
</template>

<script setup>
import { ref, reactive } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();

const user = reactive({
    uid: "",
    name: "",
    age: 0,
    addr: "",
});

const submitHandler = () => {
    router.push({
        name: "Result1",
        query: {
            uid: user.uid,
            name: user.name,
            age: user.age,
            addr: user.addr,
        },
    });
};
</script>

<style scoped>
main {
    border: 1px solid green;
}
</style>
