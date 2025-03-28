<template>
  <div class="card card-body">
    <h2>Test</h2>
    <div>
      <RouterLink :to="{ name: 'test/num', params: { num: 1 } }">
        <button class="btn btn-primary">1번 버튼</button>
      </RouterLink>
      <RouterLink :to="{ name: 'test/num', params: { num: 2 } }">
        <button class="btn btn-warning">2번 버튼</button>
      </RouterLink>
      <RouterLink :to="{ name: 'test/num', params: { num: 3 } }">
        <button class="btn btn-danger">3번 버튼</button>
      </RouterLink>
    </div>
    <RouterView />
  </div>
</template>

<script>
export default {
  name: 'Test',
};
</script>
