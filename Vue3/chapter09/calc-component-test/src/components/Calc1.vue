<!-- Options API 적용 -->

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
export default {
  name: 'Calc1',
  data() {
    return {
      name: '',
      x: 10,
      y: 20,
      sum1: 30,
    };
  },
  methods: {
    changeName(inputName) {
      this.name = inputName.toUpperCase();
    },
    calculateSum(num1, num2) {
      this.sum1 = num1 + num2;
    },
  },
};
</script>
