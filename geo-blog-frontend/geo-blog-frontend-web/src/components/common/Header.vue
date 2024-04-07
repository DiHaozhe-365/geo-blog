<script lang="ts" setup>
import { useSystemStore } from '@/stores/system'
import { useChangeTheme } from '@/hooks/useChangeTheme'
import { RouterLink } from 'vue-router'

const systemStore = useSystemStore()
</script>

<template>
  <header class="header">
    <div class="header-content">
      <div class="header-left">
        <RouterLink to="/">
          <img
            v-if="systemStore.theme === 'light'"
            src="@/assets/images/logo-light.svg"
            alt="HAO Logo"
          />
          <img
            v-if="systemStore.theme === 'dark'"
            src="@/assets/images/logo-dark.svg"
            alt="HAO Logo"
          />
        </RouterLink>
      </div>
      <nav class="header-middle">
        <RouterLink class="header-middle-item" to="/post">文 章</RouterLink>
        <RouterLink class="header-middle-item" to="/note">笔 记</RouterLink>
        <RouterLink class="header-middle-item" to="/my">我 的</RouterLink>
      </nav>
      <div class="header-right">
        <div
          class="header-right-item"
          v-if="systemStore.theme === 'light'"
          @click="useChangeTheme('dark')"
        >
          <img src="@/assets/images/change-theme-light.svg" alt="Change Theme Light" />
        </div>
        <div
          class="header-right-item"
          v-if="systemStore.theme === 'dark'"
          @click="useChangeTheme('light')"
        >
          <img src="@/assets/images/change-theme-dark.svg" alt="Change Theme Dark" />
        </div>
      </div>
    </div>
  </header>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.3s;
  @include useTheme {
    background: var(--hao-card-bg);
    outline: 1px solid var(--hao-card-border);
  }
  .header-content {
    max-width: 1400px;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 3rem;
    .header-left {
      display: flex;
      justify-content: center;
      align-items: center;
      img {
        height: 20px;
        user-select: none;
        -moz-user-select: none;
        -webkit-user-select: none;
        -ms-user-select: none;
        -khtml-user-select: none;
      }
    }
    .header-middle {
      display: flex;
      justify-content: center;
      align-items: center;
      .header-middle-item {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 10px 15px;
        border-radius: 20px;
        margin: 0 5px;
        user-select: none;
        text-decoration: none;
        transition: 0.3s;
        cursor: pointer;
        background: none;
        @include useTheme {
          font-weight: 500;
          color: var(--hao-font-color);
        }
        &:hover {
          @include useTheme {
            color: var(--hao-font-color-hover);
            background: var(--hao-theme);
          }
        }
        &:active {
          transform: scale(95%);
        }
      }
    }
    .header-right {
      display: flex;
      justify-content: center;
      align-items: center;
      .header-right-item {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 0.3rem;
        border-radius: 50%;
        user-select: none;
        transition: 0.3s;
        cursor: pointer;
        &:hover {
          @include useTheme {
            background: var(--hao-card-border);
          }
        }
      }
    }
  }
}
</style>
