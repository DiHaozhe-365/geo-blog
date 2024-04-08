<script lang="ts" setup></script>

<template>
  <footer class="footer">
    <div class="footer-content">
      <div class="footer-left">
        <span>©2024 By 邸浩哲Geo</span>
      </div>
      <div class="footer-middle"></div>
      <div class="footer-right">
        <span>冀ICP备-2023021272号</span>
      </div>
    </div>
  </footer>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
.footer {
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: center;
  align-items: center;
  @include useTheme() {
    background: var(--geo-card-bg);
    outline: 1px solid var(--geo-card-border);
  }
  .footer-content {
    max-width: 1400px;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 3rem;
    user-select: none;
    @include useTheme() {
      color: var(--geo-font-color);
    }
  }
}
</style>
