<template>
  <div>
    <input type="text" placeholder="id 입력" v-model="id" />
    <button @click="getTodo">콘솔로 조회</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';

const id = ref('1');

const getTodo = async () => {
  const response = await axios.get(`/api/todos/${id.value}`);
  console.log(response.data);
};
</script>
