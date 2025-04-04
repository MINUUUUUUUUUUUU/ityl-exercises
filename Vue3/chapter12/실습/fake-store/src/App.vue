<template>
  <DefaultLayout>
    <template v-slot:header><Header /></template>
    <template v-slot:navbar><NavBar /></template>
    <template v-slot:default><RouterView /></template>
    <template v-slot:footer><Footer /></template>
  </DefaultLayout>
</template>

<script>
import { RouterView } from 'vue-router';
import DefaultLayout from './components/layouts/DefaultLayout.vue';
import Header from './components/layouts/Header.vue';
import NavBar from './components/layouts/NavBar.vue';
import Footer from './components/layouts/Footer.vue';

export default {
  name: 'App',
  components: { DefaultLayout, Header, NavBar, Footer },
};
</script>

<style scoped></style>
