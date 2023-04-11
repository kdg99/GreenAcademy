<template>
    <div>
        <h4>Child1</h4>
    </div>
</template>

<script>
import { ref } from "vue";
export default {
    name: "Child1",
    setup() {
        return {};
    },
};
</script>

<style scoped>
div {
    border: 1px solid green;
}
</style>
