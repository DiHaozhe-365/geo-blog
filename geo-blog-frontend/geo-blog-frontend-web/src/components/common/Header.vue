<script lang="ts" setup>
import { useSystemStore } from '@/stores/system'
import { RouterLink } from 'vue-router'
import { UserOutlined } from '@ant-design/icons-vue'

const systemStore = useSystemStore()
</script>

<template>
  <header class="header">
    <div class="header-content">
      <div class="header-left">
        <RouterLink to="/">
          <img
            v-if="systemStore.theme === 'light'"
            src="@/assets/images/svg/GEO-light.svg"
            alt="HAO Logo"
          />
          <img
            v-if="systemStore.theme === 'dark'"
            src="@/assets/images/svg/GEO-dark.svg"
            alt="HAO Logo"
          />
        </RouterLink>
      </div>
      <nav class="header-middle">
        <RouterLink class="header-middle-item" to="/">首页</RouterLink>
        <RouterLink class="header-middle-item" to="/post">文章</RouterLink>
        <RouterLink class="header-middle-item" to="/note">笔记</RouterLink>
        <RouterLink class="header-middle-item" to="/tutorial">教程</RouterLink>
        <RouterLink class="header-middle-item" to="/service">服务</RouterLink>
        <RouterLink class="header-middle-item" to="/about">关于</RouterLink>
      </nav>
      <div class="header-right">
        <div class="header-right-item">
          <a-avatar :size="32">
            <template #icon>
              <UserOutlined />
            </template>
          </a-avatar>
        </div>
      </div>
    </div>
  </header>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.header {
  z-index: 999;
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
    background: var(--geo-card-bg);
    outline: 1px solid var(--geo-card-border);
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
        padding: 8px 13px;
        border-radius: 18px;
        margin: 0 5px;
        user-select: none;
        text-decoration: none;
        transition: 0.3s;
        cursor: pointer;
        background: none;
        white-space: nowrap;
        @include useTheme {
          font-weight: 500;
          color: var(--geo-font-color);
        }

        &:hover {
          @include useTheme {
            color: var(--geo-font-color-hover);
            background: var(--geo-theme);
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
            background: var(--geo-card-border);
          }
        }
      }
    }
  }
}
</style>