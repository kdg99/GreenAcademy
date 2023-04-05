<template>
    <h4>UComponent</h4>
    <p>name: {{ name }}</p>
    <p>age: {{ age }}</p>
</template>
<script>
export default {
    name: "UComponent",
    props: ["name", "age"],
};
</script>
<style scoped></style>
