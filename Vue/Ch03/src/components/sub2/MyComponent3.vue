<template>
    <h4>MyComponent3(computed API)</h4>
    <input v-model="price" type="number" />
    <input v-model="count" type="number" />
    <p>금액 : {{ totPrice }}</p>

    <p>20자 이내로 입력하세요.</p>
    <textarea v-model="message" cols="30" rows="10"></textarea>
    <p>글자수 : {{ txtCount }}</p>
    <p v-bind:class="calcColor">남은 글자수 : {{ remainText }}</p>
</template>
<script>
export default {
    name: "MyComponent3",
    data() {
        return {
            price: 1000,
            count: 1,
            message: "",
            color: "green",
        };
    },
    computed: {
        totPrice: function () {
            return this.price * this.count;
        },
        txtCount: function () {
            return this.message.length;
        },
        remainText: function () {
            return 20 - this.message.length;
        },
        calcColor: function () {
            if (this.remainText < 15) {
                this.color = "green";
            }
            if (this.remainText < 10) {
                this.color = "orange";
            }
            if (this.remainText < 3) {
                this.color = "red";
            }
            return this.color;
        },
    },
};
</script>
<style scoped>
.red {
    color: red;
}
.orange {
    color: orange;
}
.green {
    color: green;
}
</style>
