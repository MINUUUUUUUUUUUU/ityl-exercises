<template>
  <DefaultLayout>
    <template v-slot:header><Header /></template>
    <template v-slot:navbar><Navbar /></template>
    <template v-slot:default><RouterView /></template>
  </DefaultLayout>
</template>
<script setup>
import { RouterView } from 'vue-router';
import DefaultLayout from './components/layouts/DefaultLayout.vue';
import Header from './components/layouts/Header.vue';
import Navbar from './components/layouts/Navbar.vue';
</script>
