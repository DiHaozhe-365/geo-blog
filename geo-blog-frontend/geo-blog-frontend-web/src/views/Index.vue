<script lang="ts" setup>
import Banner from '@/components/index/Banner.vue'
import Carousel from '@/components/index/Carousel.vue'
import PostCategory from '@/components/index/PostCategory.vue'
</script>

<template>
  <div class="index">
    <div class="banners">
      <Banner></Banner>
      <Carousel></Carousel>
    </div>
    <div class="post-and-sidebar">
      <div class="posts">
        <PostCategory></PostCategory>
      </div>
      <div class="sidebar"></div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
@import '@/assets/styles/layout';

.index {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;

  .banners {
    width: 100%;
    display: flex;
    justify-content: center;
    gap: 20px;
    overflow: hidden;
  }

  .post-and-sidebar {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    gap: 20px;

    .posts {
      width: 100%;
      height: 100%;
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 20px;
      transition: 0.3s;
    }

    .sidebar {
      width: 100%;
      height: 100%;
      display: flex;
      display: none;
      flex-direction: column;
      align-items: center;
      background: aqua;
      gap: 20px;
      transition: 0.3s;
    }
  }
}
</style>