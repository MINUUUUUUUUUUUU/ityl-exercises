<template>
  <div class="card card-body">
    <h2>TestChild</h2>
    <h3>parameter num : {{ num }}</h3>
    <button class="btn btn-lg btn-secondary" @click.stop="closeTest">
      닫기
    </button>
  </div>
</template>

<script>
import { useRoute, useRouter } from 'vue-router';
import { ref, watchEffect } from 'vue';

export default {
  name: 'TestChild',
  setup() {
    const currentRoute = useRoute();
    const num = ref(currentRoute.params.num);

    watchEffect(() => {
      num.value = currentRoute.params.num;
    });

    const router = useRouter();
    const closeTest = () => {
      router.push('/test');
      // <RouterLink to="/test"> 클릭한 것과 같은 효과
    };

    return { num, closeTest };
  },
};
</script>
