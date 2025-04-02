<template>
  <div>
    <h1>/post(할 일 추가)</h1>
    <hr />
    <h3>할 일 추가</h3>
    <form @submit.prevent="addTodo">
      <div>
        할 일:
        <input type="text" v-model="state.todo.todo" />
      </div>
      <div>
        설 명:
        <input type="text" v-model="state.todo.desc" />
      </div>
      <button type="submit">추가</button>
    </form>
  </div>
</template>
<script setup>
import { reactive } from 'vue';
import axios from 'axios';
import { useRoute, useRouter } from 'vue-router';

const state = reactive({
  todo: {
    todo: '',
    desc: '',
    done: false,
  },
});

const router = useRouter();

const addTodo = async () => {
  const url = '/api/todos';

  const response = await axios.post(url, state.todo);
  const result = response.data;
  const id = result.id;

  router.push(`/get/${id}`);
};
</script>
