<template>
  <div class="row">
    <div class="col p-3">
      <router-link class="btn btn-primary" to="/todos/add"
        >할일 추가</router-link
      >
      <button class="btn btn-primary ms-1" @click="fetchTodoList">
        새로 고침
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
    <span>완료된 할일 개수 : {{ doneCount }}</span>
  </div>
</template>
<script setup>
import { computed } from 'vue';
import TodoItem from '@/components/TodoItem.vue';
import { useTodoListStore } from '@/stores/todoList';

const todoListStore = useTodoListStore();

const todoList = computed(() => todoListStore.todoList);
const { fetchTodoList } = todoListStore;
const doneCount = computed(() => todoListStore.doneCount);
</script>
