<template>
  <div class="row mb-3">
    <div class="col-md text-center">
      전체 todo 개수 : <span>{{ todolist.length }}</span>
    </div>
    <div class="col-md text-center">
      <!-- 완료 todo 개수 : <span :class="completedCount && completed">{{completedCount}}</span> -->
      완료 todo 개수 :
      <span :class="{ completed: completedCount > 0 }">{{
        completedCount
      }}</span>
    </div>
    <div class="col-md text-center">
      미완료 todo 개수 :
      <span :class="{ notCompleted: todolist.length - completedCount > 0 }">{{
        todolist.length - completedCount
      }}</span>
    </div>
  </div>
</template>
<script>
export default {
  name: 'TodoCount',
  computed: {
    completedCountHandler() {
      this.$emit('completed-count', this.todolist);
    },

    completedCount() {
      // todolist의 요소 중 completed 가 true인 요소만 남긴 배열 반환
      return this.todolist.filter((todo) => todo.completed).length;
    },
  },
  data() {
    return {};
  },
  props: { todolist: { type: Array, required: true } },
};
</script>
