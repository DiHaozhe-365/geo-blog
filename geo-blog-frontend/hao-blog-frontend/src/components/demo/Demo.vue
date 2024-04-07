<script setup lang="ts">
import { login } from '@/api'

async function handleLogin() {
  const response = await login({ username: 'admin', password: '123456' })
  console.log(response.data)
}
</script>

<template>
  <div class="demo">
    <button @click="handleLogin">登 录</button>
  </div>
</template>

<style scoped lang="scss">
@import '@/styles/theme';

button {
  width: 1000px;
  height: 5000px;
  @include useTheme {
    background-color: var(--hao-theme);
    font-size: 50px;
  }
}
</style>
