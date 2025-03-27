<template>
  <li
    :key="todoitem.id"
    class="list-group-item"
    :class="{ 'list-group-item-success': todoitem.completed }"
  >
    <input
      type="checkbox"
      class="me-3"
      v-model="todoitem.completed"
      @click.stop="toggleCompletedHandler(todoitem.id)"
    />
    <span class="pointer" :class="{ 'todo-done': todoitem.completed }">
      {{ todoitem.todo }} {{ todoitem.completed ? '(완료)' : '' }}
    </span>
    <span
      class="float-end badge bg-secondary pointer"
      @click.stop="$emit('delete-todo', todoitem.id)"
      >삭제</span
    >
  </li>
</template>
<script setup>
const props = defineProps({
  todoitem: { type: Object, required: true },
});

const emit = defineEmits(['toggle-completed', 'delete-todo']);
const toggleCompletedHandler = (id) => {
  emit('toggle-completed', id);
};
</script>
