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
  display: flex;
  justify-content: center;
  align-items: center;

  .change-theme-item {
    display: flex;
    justify-content: center;
    align-items: center;
  }
}
</style>