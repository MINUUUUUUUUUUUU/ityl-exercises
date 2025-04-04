<script setup>
import { computed } from 'vue';
import { useCounterStore } from './stores/counter';

const store = useCounterStore();
const { increment } = store;
const count = computed(() => store.count);

increment();
console.log(store);
</script>

<template>
  {{ store.count }}/{{ store.doubleCount }} <br />
  {{ count }}
</template>
