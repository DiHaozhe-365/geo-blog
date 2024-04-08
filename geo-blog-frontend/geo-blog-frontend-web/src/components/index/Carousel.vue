<script lang="ts" setup></script>

<template>
  <div class="carousel">
    <div class="carousel-left-button"></div>
    <div class="carousel-right-button"></div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
.carousel {
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
  .carousel-left-button {
    width: 50%;
    height: 100%;
    display: flex;
  }
  .carousel-right-button {
    width: 50%;
    height: 100%;
    display: flex;
  }
}
</style>
