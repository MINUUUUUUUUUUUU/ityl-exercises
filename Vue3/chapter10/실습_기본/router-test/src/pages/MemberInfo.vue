<template>
  <div class="card card-body">
    <div>
      <!-- 경로 패턴: /members/:id<br /> -->
      <!-- 요청 경로: {{ currentRoute.fullPath }}<br /> -->
      <!-- id값: {{ currentRoute.params.id }}<br /> -->
      <!-- {{ member[currentRoute.params.id] }} -->
      <img :src="member[currentRoute.params.id].photo" />
      <!-- <h3>{{ member[currentRoute.params.id] }}</h3> -->
      <h3>{{ member[currentRoute.params.id].name }}</h3>
      <p>{{ member[currentRoute.params.id].role }}</p>
      <a
        v-if="member[currentRoute.params.id].insta != 0"
        :href="member[currentRoute.params.id].insta"
        class="fa fa-instagram"
      ></a>
      <a
        v-if="member[currentRoute.params.id].facebook != 0"
        :href="member[currentRoute.params.id].facebook"
        class="fa fa-facebook"
      ></a>
      <a
        v-if="member[currentRoute.params.id].youtube != 0"
        :href="member[currentRoute.params.id].youtube"
        class="fa fa-youtube"
      >
      </a>
      <br />
      <button class="btn btn-link" @click.stop="goBackMemberList">
        멤버 목록으로
      </button>
    </div>
  </div>
</template>
<script>
import { useRoute, useRouter } from 'vue-router';
import member from '@/members.json';

export default {
  name: 'MemberInfo',
  setup() {
    const currentRoute = useRoute();

    const router = useRouter();
    const goBackMemberList = () => {
      router.push('/members');
    };

    return { currentRoute, member, goBackMemberList };
  },
};
</script>
