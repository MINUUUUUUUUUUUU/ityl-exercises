import { defineStore } from 'pinia';
import { reactive, computed } from 'vue';
import axios from 'axios';

export const useTodoListStore = defineStore('todoList', () => {
  // state
  const BASEURI = '/api/todos';
  const states = reactive({ todoList: [] });

  // getter
  const todoList = computed(() => states.todoList);
  const doneCount = computed(() => {
    return states.todoList.filter((todo) => todo.done === true).length;
  });

  // actions
  const fetchTodoList = async () => {
    try {
      const response = await axios.get(BASEURI);
      if (response.status === 200) {
        states.todoList = response.data;
      } else {
        alert('데이터조회실패');
      }
    } catch (error) {
      alert('에러발생:' + error);
    }
  };

  const addTodo = async ({ todo, desc }, successCallback) => {
    try {
      const payload = { todo, desc };
      const response = await axios.post(BASEURI, payload);
      if (response.status === 201) {
        states.todoList.push({ ...response.data, done: false });
        successCallback();
      } else {
        alert('Todo 추가 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
  };

  const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
    try {
      const payload = { id, todo, desc, done };
      const response = await axios.put(BASEURI + `/${id}`, payload);
      if (response.status === 200) {
        let index = states.todoList.findIndex((todo) => todo.id === id);
        states.todoList[index] = payload;
        successCallback();
      } else {
        alert('Todo 변경 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
  };

  const deleteTodo = async (id) => {
    try {
      const response = await axios.delete(BASEURI + `/${id}`);
      console.log(response.status, response.data);
      if (response.status === 200) {
        let index = states.todoList.findIndex((todo) => todo.id === id);
        states.todoList.splice(index, 1);
      } else {
        alert('Todo 삭제 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
  };

  const toggleDone = async (id) => {
    try {
      let todo = states.todoList.find((todo) => todo.id === id);
      let payload = { ...todo, done: !todo.done };
      const response = await axios.put(BASEURI + `/${id}`, payload);
      if (response.status === 200) {
        todo.done = payload.done;
      } else {
        alert('Todo 완료 변경 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
  };

  return {
    todoList,
    // isLoading,
    doneCount,
    fetchTodoList,
    addTodo,
    updateTodo,
    deleteTodo,
    toggleDone,
  };
});
