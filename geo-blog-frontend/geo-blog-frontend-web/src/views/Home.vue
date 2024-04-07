<script lang="ts" setup>
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

<style lang="scss" scoped>
@import '@/assets/styles/theme';
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
