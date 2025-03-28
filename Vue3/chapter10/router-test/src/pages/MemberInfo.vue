<template>
  <div class="card card-body">
    <h2>MemberInfo {{ id }}</h2>
  </div>
</template>

<script>
import { useRoute, useRouter } from 'vue-router';

export default {
  name: 'MemberInfo',

  setup() {
    const currentRoute = useRoute(); // 현재 라우트 정보 객체
    const router = useRouter(); // 라우터 인스턴스 (페이지 이동, 히스토리 제어)

    console.log('currentRoute : ', currentRoute);
    console.log('router : ', router);

    const id = currentRoute.params.id; // 동적 라우트 시 지정한 파라미터(:id)

    return { id };
  },
};
</script>
