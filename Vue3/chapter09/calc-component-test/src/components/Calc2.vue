<template>
  <div>
    <h3>OPTIONS API</h3>
    <input
      type="text"
      placeholder="입력하면대문자로변환된다"
      :value="name"
      @input="changeName($event.target.value)"
    />
  </div>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
    <button @click="calculateSum(x, y)">계산하기</button>
    <p>X+Y = {{ sum1 }}</p>
  </div>
</template>
<script>
import { ref } from 'vue';

export default {
  name: 'Calc2',
  setup() {
    const name = ref(''); // data() 대체
    const changeName = (inputName) => {
      name.value = inputName.toUpperCase();
    };
    // -----

    const x = ref(5);
    const y = ref(7);
    const sum1 = ref(12);

    const calculateSum = (num1, num2) => {
      sum1.value = num1 + num2;
    };

    // setup() return 구문에 작성 -> <template>에서 사용 가능
    return { name, changeName, x, y, sum1, calculateSum };
  },
};
</script>
