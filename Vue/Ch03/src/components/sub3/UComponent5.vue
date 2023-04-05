<template>
    <h4>UComponent5</h4>
    <p>
        이름 : <input v-model="name" type="text" /> <br />
        나이 : <input v-model="age" type="text" />
    </p>
    <button @click="onEmit">상위 컴포넌트로 전달</button>
</template>
<script>
export default {
    name: "UComponent5",
    data() {
        return {
            name: "홍길동",
            age: 21,
        };
    },
    methods: {
        onEmit: function () {
            let data = {
                name: this.name,
                age: this.age,
            };
            this.$emit("myShow", data);
        },
    },
};
</script>
<style scoped></style>
