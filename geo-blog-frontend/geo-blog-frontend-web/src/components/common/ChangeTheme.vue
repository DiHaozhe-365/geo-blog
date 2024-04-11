<script lang="ts" setup>
import { useChangeTheme } from '@/hooks/useChangeTheme'
import { useSystemStore } from '@/stores/system'

const systemStore = useSystemStore()
</script>

<template>
  <div class="change-theme">
    <div
      class="change-theme-item"
      v-if="systemStore.theme === 'light'"
      @click="useChangeTheme('dark')"
    >
      <img src="@/assets/images/svg/change-theme-light.svg" alt="Change Theme Light" />
    </div>

    <div
      class="change-theme-item"
      v-if="systemStore.theme === 'dark'"
      @click="useChangeTheme('light')"
    >
      <img src="@/assets/images/svg/change-theme-dark.svg" alt="Change Theme Dark" />
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.change-theme {
  width: 40px;
  height: 40px;
  position: fixed;
  left: 20px;
  bottom: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  box-shadow: 0 0 10px rgba(1, 2, 5, 0.2);
  cursor: pointer;
  transition: 0.3s;
  @include useTheme {
    background: var(--geo-card-bg);
    border: 1px solid var(--geo-card-border);
  }

  .change-theme-item {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
  }

  &:hover {
    @include useTheme {
      background: var(--geo-font-color-hover);
    }
  }

  &:active {
    @include useTheme {
      transform: scale(95%);
    }
  }
}
</style>