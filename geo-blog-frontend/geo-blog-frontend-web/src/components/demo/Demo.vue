<script lang="ts" setup>
import { askVerifyCode, getAccountList, getHello, login, logout, register } from '@/api'

async function handleLogin() {
  await login({ username: 'admin', password: '123456', remember: false })
}

async function handleLogout() {
  const response = await logout()
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

async function handleVerifyCode() {
  await askVerifyCode({ email: '1839279043@qq.com', type: 'register' })
}

async function handleRegister() {
  await register({
    username: 'test',
    email: '1839279043',
    password: '123456',
    nickname: '邸浩哲',
    code: '11'
  })
}
</script>

<template>
  <div class="demo">
    <button @click="handleLogin">登 录</button>
    <button @click="handleLogout">退出登录</button>
    <button @click="handleList">获取列表</button>
    <button @click="handleHello">获取你好</button>
    <button @click="handleVerifyCode">获取邮箱验证码</button>
    <button @click="handleRegister">注 册</button>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.demo {
  position: absolute;
  top: 50%;
  left: 50%;
  display: none;
  display: block;
}

button {
  width: 100px;
  height: 100px;
}
</style>