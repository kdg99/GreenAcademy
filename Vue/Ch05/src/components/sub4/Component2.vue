<template>
    <main>
        <h4>Component2</h4>

        <p>
            params : {{ $route.params }} <br />
            name : {{ $route.params.name }} <br />
            age : {{ $route.params.age }} <br />
            addr : {{ $route.params.addr }} <br />
        </p>
    </main>
</template>

<script setup></script>

<style scoped>
main {
    border: 1px solid green;
}
</style>
