<script lang="ts" setup></script>

<template>
  <div class="post-category">
    <div class="categories">
      <div class="category active">全部</div>
      <div class="category">前端</div>
      <div class="category">后端</div>
      <div class="category">安卓</div>
      <div class="category">iOS</div>
      <div class="category">人工智能</div>
      <div class="category">开发工具</div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
@import '@/assets/styles/layout';

.post-category {
  width: 100%;
  height: 50px;
  border-radius: var(--geo-card-border-radius);
  display: flex;
  justify-content: center;
  align-items: center;
  animation: slidein 0.6s 0.3s backwards;
  overflow: hidden;
  @include useTheme {
    background: var(--geo-card-bg);
    border: 1px solid var(--geo-card-border);
  }

  .categories {
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    padding: 20px;
    gap: 10px;

    .category {
      padding: 6px 8px;
      border-radius: 6px;
      user-select: none;
      cursor: pointer;
      transition: 0.1s;
      white-space: nowrap;
      @include useTheme {
        color: var(--geo-font-color);
      }

      &:hover {
        @include useTheme {
          color: var(--geo-theme);
        }
      }

      &:active {
        opacity: 0.7;
      }
    }

    .active {
      @include useTheme {
        background: var(--geo-theme);
        color: var(--geo-card-bg) !important;
      }
    }
  }
}
</style>
