<script lang="ts" setup></script>

<template>
  <footer class="footer"></footer>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
.footer {
  width: 100%;
  height: 60px;
  @include useTheme() {
    background: var(--geo-card-bg);
    outline: 1px solid var(--geo-card-border);
  }
}
</style>
