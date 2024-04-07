<script lang="ts" setup>
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

<style lang="scss" scoped>
@import '@/assets/styles/theme';

button {
  width: 1000px;
  height: 5000px;
  @include useTheme {
    background-color: var(--hao-theme);
    font-size: 50px;
  }
}
</style>
