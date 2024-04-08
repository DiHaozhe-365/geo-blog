<script lang="ts" setup>
import Banner from '@/components/index/Banner.vue'
import Carousel from '@/components/index/Carousel.vue'
</script>

<template>
  <div class="home">
    <div class="banners">
      <Banner></Banner>
      <Carousel></Carousel>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
.home {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  .banners {
    width: 100%;
    display: flex;
    justify-content: center;
    gap: 20px;
  }
}
</style>
