<template>
    <h4>Component3</h4>
    <p>
        이름 : <input v-model="user.name" type="text" /> <br />
        나이 : <input v-model="user.age" type="number" /> <br />
        <button @click="btnSend">상위 컴포넌트로 전송</button>
    </p>
</template>
<script>
export default {
    name: "Component3",
    setup(props, context) {
        //변수 선언(반응성 없음 하지만 객체[json]는 반응성 있음)
        const user = {
            name: "",
            age: 0,
        };
        const btnSend = () => {
            console.log("name : " + user.name);
            console.log("age : " + user.age);
            //상위 컴포넌트로 이벤트 발생
            context.emit("myEvent", user);
        };
        return {
            user,
            btnSend,
        };
    },
};
</script>
<style scoped></style>
