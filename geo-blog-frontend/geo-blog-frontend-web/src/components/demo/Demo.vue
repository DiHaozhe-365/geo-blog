<script lang="ts" setup>
import { getAccountList, getHello, login } from '@/api'

async function handleLogin() {
  const response = await login({ username: 'admin', password: '123456' })
  console.log(response)
}

async function handleList() {
  const response = await getAccountList()
  console.log(response)
}

async function handleHello() {
  const response = await getHello()
  console.log(response)
}
</script>

<template>
  <div class="demo">
    <button @click="handleLogin">登 录</button>
    <button @click="handleList">获取列表</button>
    <button @click="handleHello">获取你好</button>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.demo {
  position: absolute;
  top: 50%;
  left: 50%;
}

button {
  width: 100px;
  height: 100px;
}
</style>