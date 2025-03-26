<template>
  <div>
    <InputName v-model:name="searchName" />
    <h3>검색어 : {{ searchName }}</h3>

    <hr />
    <h1>부모 Click Count : {{ count }}</h1>
    <ClickCount />
  </div>
  <hr />
  <h1>Teleport Text</h1>
  <button @click="changeModal">isModal 상태 변경</button>
  <!-- id="modal" 요소에 모달 컴포넌트 렌더링 -->
  <teleport to="#modal">
    <Modal v-if="isModal" />
  </teleport>
</template>

<script>
import InputName from './components/InputName.vue';
import ClickCount from './components/ClickCount.vue';

import { computed } from 'vue';

import Modal from './components/Modal.vue';

export default {
  name: 'App',
  components: { InputName, ClickCount, Modal },
  data() {
    return { searchName: 'John', count: 0, isModal: false };
  },
  provide() {
    return {
      cnt: computed(() => this.count),
      increment: () => this.count++,
    };
  },
  methods: {
    changeModal() {
      this.isModal = true;
      setTimeout(() => {
        this.isModal = false;
      }, 2000);
    },
  },
};
</script>
