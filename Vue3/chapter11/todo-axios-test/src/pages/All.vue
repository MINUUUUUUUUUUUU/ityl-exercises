<template>
  <div>
    <h1>ALL(전체 조회)</h1>
    <table class="table table-bordered">
      <thead>
        <th>DONE</th>
        <th>ID</th>
        <th>TODO</th>
        <th>DESC</th>
        <th>DELETE</th>
      </thead>
      <tbody>
        <tr v-for="todo in state.todos" :key="todo.id">
          <td>
            <input
              type="checkbox"
              :checked="todo.done"
              @change="updateTodo(todo)"
            />
          </td>
          <td>{{ todo.id }}</td>
          <td>{{ todo.todo }}</td>
          <td>{{ todo.desc }}</td>
          <td><button @click="deleteTodo(todo.id)">삭제</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script setup>
import { reactive } from 'vue';
import axios from 'axios';

// 상태 변수 선언 -> 값 변경 시 반응 -> 컴포넌트 다시 렌더링
const state = reactive({ todos: [] });

// 비동기로 서버로부터 모든 할일 목록 얻어오기
const fetchTodoList = async () => {
  const response = await axios.get('/api/todos');
  state.todos = response.data;
};

const updateTodo = async (todo) => {
  todo.done = !todo.done;
  const response = await axios.put(`/api/todos/${todo.id}`, todo);
  console.log(response.data);
};

const deleteTodo = async (id) => {
  await axios.delete(`/api/todos/${id}`);
  state.todos = state.todos.filter((t) => t.id !== id);
};

fetchTodoList();
</script>
