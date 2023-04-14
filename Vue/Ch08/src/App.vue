<template>
  <h3>Ch08.Vuefity 실습</h3>
  <p>
    <router-link to="/components">Components</router-link> /
    <router-link to="/grids">Grids</router-link> /
    <router-link to="/layout">Layout</router-link>
  </p>

  <br />
  <hr />
  <br />
  <router-view></router-view>
</template>

<script setup></script>

<style>
#app {
  padding: 10px;
}
</style>
