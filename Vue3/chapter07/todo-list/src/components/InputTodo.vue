<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <!-- 새 할 일 추가-->
        <input
          type="text"
          class="form-control"
          placeholder="할 일을 여기에 입력!"
          v-model.trim="todo"
          @keyup.enter="addTodoHandler"
        />
        <span
          class="btn btn-primary input-group-addon"
          @click.stop="addTodoHandler"
          >추가</span
        >
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'InputTodo',
  data() {
    return { todo: '' };
  },
  methods: {
    addTodoHandler() {
      if (this.todo.length >= 3) {
        // 이벤트 발신(emit) 이용
        this.$emit('add-todo', this.todo);
        this.todo = '';
      } else {
        alert('할 일은 3글자 이상으로 작성해주세요!!');
      }
    },
  },
};
</script>
