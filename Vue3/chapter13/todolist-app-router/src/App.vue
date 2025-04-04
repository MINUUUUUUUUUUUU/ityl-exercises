<template>
  <div class="container"><Header /> <router-view /></div>
</template>
<script setup>
import { computed } from 'vue';
import Header from '@/components/Header.vue';
import { useTodoListStore } from './stores/todoList';

const todoListStore = useTodoListStore();
const { fetchTodoList } = todoListStore;
// const isLoading = computed(() => todoListStore.isLoading);

fetchTodoList();
</script>
