<script setup lang="ts">
import { ref } from 'vue'
</script>

<template>
  <div class="banner"></div>
</template>

<style scoped lang="scss">
@import '@/styles/theme';
.banner {
  min-width: 390px;
  flex: 1;
  aspect-ratio: 16/9;
  border-radius: 20px;
  @include useTheme {
    background: var(--hao-card-bg);
    border: 1px solid var(--hao-card-border);
  }
}
</style>
