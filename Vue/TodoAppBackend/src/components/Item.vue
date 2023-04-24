<template>
    <li>
        <i class="fa-solid fa-check"></i>
        {{ todo }}
        <button @click="emit('removeItem')">삭제</button>
    </li>
</template>

<script setup>
//
import { ref, computed } from "vue";
const props = defineProps({
    data: Object,
});
const emit = defineEmits(["removeItem"]);

//
let todo = ref(props.data.content);
todo = computed(() => props.data.content);
</script>

<style scoped></style>
