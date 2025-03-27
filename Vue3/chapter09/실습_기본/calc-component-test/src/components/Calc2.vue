<template>
  <div>
    X : <input type="text" v-model.number="x" /> <br />
    Y : <input type="text" v-model.number="y" /> <br />
    <button @click="calcAdd(x, y)">계산</button> <br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
<script>
import { ref } from 'vue';
export default {
  name: 'Calc2',
  setup() {
    const x = ref(10);
    const y = ref(20);
    const result = ref(30);
    const calcAdd = (x, y) => {
      result.value = x + y;
    };
    return { x, y, result, calcAdd };
  },
};
</script>
