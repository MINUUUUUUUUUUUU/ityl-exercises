<template>
  <div>
    <h1>자식의 자식 Click Count: {{ cnt }}</h1>
    <button @click="increment">+1</button>
  </div>
</template>
<script>
export default {
  name: 'ChildClickCount',
  inject: ['cnt', 'increment'],
};
</script>
