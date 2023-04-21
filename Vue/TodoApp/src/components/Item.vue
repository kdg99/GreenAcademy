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
    data: String,
});
const emit = defineEmits(["removeItem"]);

//
let todo = ref(props.data);
todo = computed(() => props.data);
</script>

<style scoped></style>
