<script lang="ts" setup>
import { ref } from 'vue'
import { login } from '@/api'
import { LockOutlined, UserOutlined } from '@ant-design/icons-vue'
import router from '@/router'

interface LoginForm {
  username: string
  password: string
  remember: boolean
}

const loginForm = ref<LoginForm>({
  username: '',
  password: '',
  remember: false
})

const handleLogin = async () => {
  await login(loginForm.value)
}
</script>

<template>
  <div class="login-card">
    <div class="title">登录</div>
    <div class="sub-title">以发现 GeoBlog 更多功能！</div>
    <a-form class="form" :model="loginForm" @finish="handleLogin">
      <a-form-item name="username" :rules="[{ required: true, message: '账号不能为空!' }]">
        <a-input v-model:value="loginForm.username" placeholder="账号/手机号/邮箱" max="28">
          <template #prefix>
            <UserOutlined />
          </template>
        </a-input>
      </a-form-item>

      <a-form-item name="password" :rules="[{ required: true, message: '密码不能为空!' }]">
        <a-input-password v-model:value="loginForm.password" placeholder="请输入密码" max="20">
          <template #prefix>
            <LockOutlined />
          </template>
        </a-input-password>
      </a-form-item>

      <a-form-item>
        <div class="options">
          <div class="remember" @click="loginForm.remember = !loginForm.remember">
            <a-checkbox class="checkbox" v-model:checked="loginForm.remember" />
            <span>记住我</span>
          </div>
          <a class="register" @click="router.push('/register')">注册账号</a>
        </div>
      </a-form-item>

      <a-form-item>
        <div class="buttons">
          <a-button type="primary" html-type="submit" class="login-form-button">
            立即登录
          </a-button>
        </div>
      </a-form-item>
    </a-form>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.login-card {
  min-width: 390px;
  padding: 60px 30px 20px 30px;
  width: 100%;
  border-radius: var(--geo-card-border-radius);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 20px;
  @include useTheme {
    background: var(--geo-card-bg);
    border: 1px solid var(--geo-card-border);
  }

  .title {
    width: 80%;
    font-size: 26px;
    font-weight: 700;
    user-select: none;
    @include useTheme {
      color: var(--geo-font-color);
    }
  }

  .sub-title {
    width: 80%;
    font-size: 14px;
    @include useTheme {
      color: var(--geo-font-color);
    }
  }

  .form {
    width: 80%;
    display: flex;
    flex-direction: column;

    .options {
      width: 100%;
      display: flex;
      justify-content: space-between;
      align-items: center;

      .remember {
        display: flex;
        align-items: center;
        gap: 5px;
        cursor: pointer;
        @include useTheme {
          color: var(--geo-font-color);
        }

        span {
          font-size: 14px;
          user-select: none;
        }
      }
    }

    .buttons {
      width: 100%;
      display: flex;
      flex-direction: column;

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
        margin-bottom: 10px;
        @include useTheme {
          font-weight: 500;
          color: var(--geo-font-color-hover);
          background: var(--geo-theme);
        }

        &:active {
          transform: scale(98%);
        }
      }
    }
  }
}
</style>