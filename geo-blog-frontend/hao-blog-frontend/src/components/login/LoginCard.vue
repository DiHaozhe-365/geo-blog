<script setup lang="ts">
import { ref } from 'vue'
import { User, Lock } from '@element-plus/icons-vue'
import { login } from '@/api'

const loginForm = ref({
  username: '',
  password: ''
})

const handleLogin = async () => {
  await login(loginForm.value)
}
</script>

<template>
  <div class="login-card">
    <div class="title">登录</div>
    <div class="sub-title">以解锁 HaoBlog 更多功能</div>
    <div class="form">
      <el-input v-model="loginForm.username" placeholder="账号/手机号/邮箱" type="text" maxlength="28">
        <template #prefix>
          <el-icon><User /></el-icon>
        </template>
      </el-input>
      <el-input v-model="loginForm.password" placeholder="请输入密码" type="password" maxlength="20">
        <template #prefix>
          <el-icon><Lock /></el-icon>
        </template>
      </el-input>
    </div>
    <div class="buttons">
      <button @click="handleLogin">立即登录</button>
    </div>
  </div>
</template>

<style scoped lang="scss">
@import '@/styles/theme';
.login-card {
  min-width: 390px;
  width: 500px;
  aspect-ratio: 15/9;
  border-radius: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 18px;
  @include useTheme {
    background: var(--hao-card-bg);
    border: 1px solid var(--hao-card-border);
  }
  .title {
    width: 70%;
    font-size: 26px;
    font-weight: 700;
    user-select: none;
    @include useTheme {
      color: var(--hao-font-color);
    }
  }
  .sub-title {
    width: 70%;
    font-size: 14px;
    @include useTheme {
      color: var(--hao-font-color);
    }
  }
  .form {
    width: 70%;
    display: flex;
    flex-direction: column;
    gap: 5px;
  }
  .buttons {
    width: 70%;
    display: flex;
    flex-direction: column;
    gap: 5px;
    button {
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 8px 10px;
      border: none;
      border-radius: 6px;
      user-select: none;
      text-decoration: none;
      transition: 0.3s;
      cursor: pointer;
      @include useTheme {
        font-weight: 500;
        color: var(--hao-font-color-hover);
        background: var(--hao-theme);
      }
      &:active {
        transform: scale(98%);
      }
    }
  }
}
</style>
