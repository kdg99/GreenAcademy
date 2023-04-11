<template>
    <main>
        <h4>Component1</h4>
        <p>
            query : {{ $route.query }} <br />
            name : {{ $route.query.name }} <br />
            age : {{ $route.query.age }} <br />
            addr : {{ $route.query.addr }} <br />
        </p>
    </main>
</template>

<script setup></script>

<style scoped>
main {
    border: 1px solid green;
}
</style>
