<script lang="ts" setup>
import Banner from '@/components/index/Banner.vue'
import Hero from '@/components/index/Hero.vue'
</script>

<template>
  <div class="home">
    <div class="banners">
      <Banner></Banner>
      <Hero></Hero>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.test {
  position: absolute;
  bottom: 100px;
  width: 500px;
  height: 500px;
  display: flex;
  align-items: center;
  justify-content: center;
}
@import '@/assets/styles/theme';
.home {
  width: 100%;
  display: flex;
  flex-direction: column;
  .banners {
    width: 100%;
    display: flex;
    justify-content: center;
    gap: 20px;
  }
}
</style>
