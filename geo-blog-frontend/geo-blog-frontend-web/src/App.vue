<script lang="ts" setup>
import { RouterView } from 'vue-router'
import { useSystemStore } from '@/stores/system'
import Header from '@/components/common/Header.vue'
import Footer from '@/components/common/Footer.vue'

// 获取网站当前主题，如果为空则设置默认系统主题
const systemStore = useSystemStore()
if (systemStore.theme === '') {
  const themeMedia = window.matchMedia('(prefers-color-scheme: light)')
  systemStore.theme = themeMedia.matches ? 'light' : 'dark'
}
document.getElementsByTagName('html')[0].dataset.theme = systemStore.theme
</script>

<template>
  <Header></Header>
  <div class="content-wrapper">
    <div class="content">
      <RouterView />
    </div>
  </div>
  <Footer></Footer>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.content-wrapper {
  padding-top: 80px;
  width: 100%;
  height: 5000px;
  display: flex;
  justify-content: center;
  .content {
    max-width: 1400px;
    width: 100%;
    display: flex;
    justify-content: center;
    padding: 0 3rem;
  }
}
</style>
