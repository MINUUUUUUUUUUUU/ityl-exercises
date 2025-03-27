<template>
  <div>
    <Calc1 />
    <hr />
    <Calc2 />
  </div>
</template>
<script>
import Calc1 from './components/Calc1.vue';
import Calc2 from './components/Calc2.vue';

export default {
  name: 'App',
  components: {
    Calc1,
    Calc2,
  },
};
</script>
