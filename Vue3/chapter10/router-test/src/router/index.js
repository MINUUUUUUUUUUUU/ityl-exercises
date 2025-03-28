import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import MemberInfo from '@/pages/MemberInfo.vue';
import Test from '@/pages/Test.vue';
import TestChild from '@/pages/TestChild.vue';
TestChild;

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: Home },
    { path: '/about', component: About },
    { path: '/members', component: Members },
    { path: '/videos', component: Videos, name: 'vi' },
    {
      path: '/members/:id', // 동적 라우트
      component: MemberInfo,
    },
    {
      path: '/test', // 중첩 라우트
      component: Test,
      children: [
        {
          path: ':num',
          component: TestChild,
          name: 'test/num',
          params: { num: 1 },
        },
      ],
    },
  ],
});

export default router;
