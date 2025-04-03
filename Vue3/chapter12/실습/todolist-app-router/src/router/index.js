import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import TodoList from '@/pages/TodoList.vue';
import AddTodo from '@/pages/AddTodo.vue';
import EditTodo from '@/pages/EditTodo.vue';
import NotFound from '@/pages/NotFound.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      component: About,
    },
    {
      path: '/todos',
      name: 'todoList',
      component: TodoList,
    },
    {
      path: '/todos/add',
      name: 'addTodo',
      component: AddTodo,
    },
    {
      path: '/todos/edit/:id',
      name: 'editTodo',
      component: EditTodo,
    },
    {
      path: '/:paths(.*)*',
      name: 'notFound',
      component: () => import('../pages/NotFound.vue'),
    },
  ],
});

export default router;
