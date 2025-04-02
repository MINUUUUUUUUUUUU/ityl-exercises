<template>
  <div>
    <h1>/get/:id(단건 조회)</h1>
    <hr />
    <h3>조회할 Todo의 id 입력</h3>
    <div>
      <input type="text" placeholder="id 입력" v-model="id" />
      <button @click="getTodo">조회</button>
    </div>
    <div>
      <h3>조회 결과</h3>
      <ul>
        <li>id : {{ state.todo.id }}</li>
        <li>todo : {{ state.todo.todo }}</li>
        <li>desc : {{ state.todo.desc }}</li>
        <li>done : {{ state.todo.done }}</li>
      </ul>
    </div>
  </div>
</template>
<script setup>
import { ref, reactive, onMounted } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';

const currentRoute = useRoute();
console.log('currentRoute : ', currentRoute.params.id);

const id = ref('1');

const state = reactive({ todo: {} });

const getTodo = async () => {
  const response = await axios.get(`/api/todos/${id.value}`);
  console.log(response.data);

  // id, title, completed 값으로 v-for로 list 출력

  state.todo = response.data;
};

onMounted(() => {
  id.value = currentRoute.params.id;
  getTodo();
});
</script>
