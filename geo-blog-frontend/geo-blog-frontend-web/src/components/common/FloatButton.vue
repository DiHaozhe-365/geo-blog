<script lang="ts" setup>
import ChangeTheme from '@/components/common/ChangeTheme.vue'
</script>

<template>
  <a-float-button-group
    class="float-buttons"
    shape="square"
    :style="{ right: '10px', bottom: '80px' }"
  >
    <a-float-button class="float-button">
      <template #icon>
        <ChangeTheme></ChangeTheme>
      </template>
    </a-float-button>

    <a-back-top :visibility-height="0" />
  </a-float-button-group>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.float-buttons {
  opacity: 0.7;
  transform: scale(90%);
  transition: 0.3s;

  &:hover {
    opacity: 0.9;
    transform: scale(100%);
  }
}
</style>