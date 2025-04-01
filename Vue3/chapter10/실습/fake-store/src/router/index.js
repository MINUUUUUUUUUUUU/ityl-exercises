import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/pages/HomePage.vue';
import ElectronicsPage from '@/pages/ElectronicsPage.vue';
import JeweleryPage from '@/pages/JeweleryPage.vue';
import MensClothingPage from '@/pages/MensClothingPage.vue';
import WomenClothingPage from '@/pages/WomenClothingPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: '/electronics',
      name: 'electronics',
      component: ElectronicsPage,
    },
    {
      path: '/jewelery',
      name: 'jewelery',
      component: JeweleryPage,
    },
    {
      path: '/mens-clothing',
      name: 'mens-clothing',
      component: MensClothingPage,
    },
    {
      path: '/women-clothing',
      name: 'women-clothing',
      component: WomenClothingPage,
    },
  ],
});

export default router;
