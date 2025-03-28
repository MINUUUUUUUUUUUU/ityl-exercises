import { createRouter, createWebHistory } from 'vue-router';

import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import MemberInfo from '@/pages/MemberInfo.vue';

import NotFound from '@/pages/NotFound.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'Home', component: Home },
    { path: '/about', name: 'About', component: About },
    { path: '/members', name: 'Members', component: Members },
    {
      path: '/members/:id',
      name: 'MemberInfo',
      component: MemberInfo,
      beforeEnter: (to, from) => {
        // members/:id 경로는 /members에서만 접근 가능
        // console.log(from.name);
        if (from.name !== 'Members') {
          return false;
        }
      },
    },
    { path: '/videos', name: 'Videos', component: Videos },
    {
      path: '/:paths(.*)*', // 모든 매칭되지 않는 경로
      name: 'NotFound',
      component: NotFound,
    },
  ],
});
export default router;
