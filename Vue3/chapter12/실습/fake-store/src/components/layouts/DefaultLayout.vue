<style></style>

<template>
  <slot name="header"></slot>
  <slot name="navbar"></slot>
  <div class="container-fluid">
    <div class="content my-5 px-3">
      <slot></slot>
    </div>
    <slot name="footer"></slot>
  </div>
</template>

<script>
export default {
  components: {},
  setup() {},
};
</script>
