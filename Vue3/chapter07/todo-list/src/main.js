// main.js
// index.html에 추가되는 모듈
// main.js에 작성된 내용은 전역으로 작성

import 'bootstrap/dist/css/bootstrap.css';
import './assets/main.css';

import { createApp } from 'vue';
import App from './App.vue';

createApp(App).mount('#app');
