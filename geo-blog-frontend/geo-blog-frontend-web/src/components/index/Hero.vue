<script lang="ts" setup>
import { ref } from 'vue'
</script>

<template>
  <div class="hero">
    <div class="hero-left"></div>
    <div class="hero-right"></div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
.hero {
  min-width: 652px;
  max-width: 690px;
  flex: 1;
  aspect-ratio: 16/9;
  border-radius: var(--geo-card-border-radius);
  display: flex;
  animation: slidein 0.6s 0.1s backwards;
  @include useTheme {
    background: var(--geo-card-bg);
    border: 1px solid var(--geo-card-border);
  }
  .hero-left {
    width: 50%;
    height: 100%;
    display: flex;
  }
  .hero-right {
    width: 50%;
    height: 100%;
    display: flex;
  }
}
</style>
