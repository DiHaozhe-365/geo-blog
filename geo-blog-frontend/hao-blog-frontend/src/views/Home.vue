<script setup lang="ts">
import Banner from '@/components/home/Banner.vue'
</script>

<template>
  <div class="home">
    <div class="banners">
      <Banner></Banner>
      <Banner></Banner>
    </div>
  </div>
</template>

<style scoped lang="scss">
@import '@/styles/theme';
.home {
  width: 100%;
  display: flex;
  flex-direction: column;
  .banners {
    width: 100%;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    gap: 20px;
  }
}
</style>
