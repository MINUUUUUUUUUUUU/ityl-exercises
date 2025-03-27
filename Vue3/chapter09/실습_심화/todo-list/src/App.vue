<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">✅:: Todolist App (Composition API 적용) 😵</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <!-- add-todo 이벤트 감지시 addTodo() 메서드 호출 -->
        <InputTodo @add-todo="addTodo" />

        <TodoCount :todolist="sortedList" />

        <!-- v-bind: 전달할 이름 = "데이터" -->
        <TodoList
          :todolist="sortedList"
          @toggle-completed="toggleCompleted"
          @delete-todo="deleteTodo"
        />
      </div>
    </div>
  </div>
</template>
<script setup>
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';
import TodoCount from './components/TodoCount.vue';

import { reactive, onMounted, computed } from 'vue';

const state = reactive({ todoList: [] });

onMounted(() => {
  state.todoList.push({
    id: Date.now(),
    todo: '자전거 타기',
    completed: false,
  });
  state.todoList.push({
    id: Date.now() + 1,
    todo: '딸과 공원 산책',
    completed: false,
  });
  state.todoList.push({
    id: Date.now() + 2,
    todo: '일요일 애견 카페',
    completed: false,
  });
  state.todoList.push({
    id: Date.now() + 3,
    todo: 'Vue 원고 집필',
    completed: false,
  });
});

// receiveTodo : 전달받은 Todo
const addTodo = (receiveTodo) => {
  state.todoList.push({
    id: new Date().getTime(),
    todo: receiveTodo,
    completed: false,
  });
};

// TodoListItem 에서부터 전달된 id
const toggleCompleted = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  state.todoList[index].completed = !state.todoList[index].completed;
};

// TodoListItem 에서부터 전달된 id
const deleteTodo = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  state.todoList.splice(index, 1);
};

const sortedList = computed(() => {
  state.todoList.sort((t1, t2) => {
    if (t1.completed > t2.completed) {
      return 1; // 양수 반환 시 자리 바뀜 (t1, t2 -> t2, t1)
    }

    if (t1.completed < t2.completed) {
      return -1; // 음수 반환 시 자리 바꿈 X
    }

    // 위 if문 실행 X === completed가 같을 경우
    // -> 문자열 오름 차순 정렬

    // 모두 소문자로 변경(대소문자 구분 X)
    const todo1 = t1.todo.toLowerCase();
    const todo2 = t2.todo.toLowerCase();

    if (todo1 > todo2) return 1; // 자리 교체
    else if (todo1 === todo2) return 0; // 유지
    else return -1; // 유지
  });
  return state.todoList;
});
</script>
