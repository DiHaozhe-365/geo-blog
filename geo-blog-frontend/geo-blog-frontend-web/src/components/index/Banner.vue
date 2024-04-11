<script lang="ts" setup>
import { ref } from 'vue'
import SmartBall from '@/components/common/SmartBall.vue'
import SkillStack from '@/components/common/SkillStack.vue'

const bannerTitle = ref({
  firstLine: '全新升级',
  secondLine: '重磅来袭',
  subTitle: '全栈、产品、设计、开发'
})
</script>

<template>
  <div class="banner">
    <div class="banner-left">
      <div class="banner-title">
        <div class="banner-title-first-line">{{ bannerTitle.firstLine }}</div>
        <div class="banner-title-second-line">{{ bannerTitle.secondLine }}</div>
      </div>
      <div class="banner-sub-title">
        {{ bannerTitle.subTitle }}
      </div>
      <div class="banner-buttons">
        <div class="banner-button">
          <SmartBall message="解锁新知识"></SmartBall>
        </div>
      </div>
    </div>
    <div class="banner-right">
      <SkillStack></SkillStack>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
@import '@/assets/styles/layout';

.banner {
  position: relative;
  max-width: 690px;
  min-width: 600px;
  width: 100%;
  aspect-ratio: 16/9;
  border-radius: var(--geo-card-border-radius);
  display: flex;
  animation: slidein 0.6s 0.1s backwards;
  @include useTheme {
    background: var(--geo-card-bg);
    border: 1px solid var(--geo-card-border);
  }
  @include responseTo('phone') {
  }

  .banner-left {
    width: 50%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
    gap: 15px;

    .banner-title {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: flex-start;
      margin-left: 15%;
      margin-top: 20%;

      .banner-title-first-line {
        font-size: 36px;
        font-weight: 700;
        @include useTheme {
          color: var(--geo-font-color);
        }
      }

      .banner-title-second-line {
        font-size: 36px;
        font-weight: 700;
        @include useTheme {
          color: var(--geo-font-color);
        }
      }
    }

    .banner-sub-title {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: flex-start;
      margin-left: 15%;
      font-size: 14px;
      font-weight: 300;
      @include useTheme {
        color: var(--geo-font-color);
      }
    }

    .banner-buttons {
      margin-left: 15%;
      margin-top: auto;
      margin-bottom: 25%;
      width: 50%;
    }
  }

  .banner-right {
    width: 50%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    overflow: hidden;
    gap: 20px;
  }
}
</style>