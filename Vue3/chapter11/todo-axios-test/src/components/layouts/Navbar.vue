<template>
  <nav class="navbar navbar-expand bg-body-tertiary">
    <div class="container-fluid">
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <NavItem v-for="menu in menus" :menu="menu" />
        </ul>
      </div>
    </div>
  </nav>
</template>
<script setup>
import NavItem from './NavItem.vue';

const menus = [
  { uri: '/', text: 'Home' },
  { uri: '/all', text: 'All' },
  { uri: '/get/1', text: 'Get' },
  { uri: '/post', text: 'Post' },
];
</script>
