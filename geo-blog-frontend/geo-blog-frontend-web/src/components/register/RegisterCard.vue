<script lang="ts" setup>
import { ref } from 'vue'
import { askVerifyCode, register } from '@/api'
import { LockOutlined, MailOutlined, SmileOutlined, UserOutlined } from '@ant-design/icons-vue'
import { message } from 'ant-design-vue'
import router from '@/router'

interface RegisterForm {
  username: string
  email: string
  password: string
  confirmPassword: string
  nickname: string
  code: string
}

const registerForm = ref<RegisterForm>({
  username: '',
  email: '',
  password: '',
  confirmPassword: '',
  nickname: '',
  code: ''
})

// 发送请求注册验证码逻辑
const codeState = ref({
  title: '发 送',
  count: 60,
  isDisable: false
})
const handleAskEmailCode = async () => {
  const reg = new RegExp(
    '^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$'
  )
  if (registerForm.value.email === '') {
    message.warn('邮箱不能为空')
  } else if (!reg.test(registerForm.value.email)) {
    message.warn('邮箱格式不正确')
  } else {
    await askVerifyCode({ email: registerForm.value.email, type: 'register' })
    startDisable()
  }
}

// 倒计时
let countInterval: any
const startDisable = () => {
  //将发送按钮设置为禁用，并开始60秒倒计时
  codeState.value.title = codeState.value.count + 's'
  codeState.value.isDisable = true
  countInterval = setInterval(() => {
    codeState.value.count = codeState.value.count - 1
    codeState.value.title = codeState.value.count + 's'
    if (codeState.value.count === 0) {
      codeState.value.title = '发 送'
      codeState.value.count = 60
      codeState.value.isDisable = false
      clearInterval(countInterval)
    }
  }, 1000)
  //倒计时结束后设置为可用
}

// 注册逻辑
const handleRegister = async () => {
  if (registerForm.value.password !== registerForm.value.confirmPassword) {
    message.warn('两次输入的密码不一致')
    return
  } else {
    await register(registerForm.value)
  }
}
</script>

<template>
  <div class="register-card">
    <div class="title">注册</div>
    <div class="sub-title">以发现 GeoBlog 更多功能！</div>
    <a-form class="form" :model="registerForm" @finish="handleRegister">
      <a-form-item name="username" :rules="[{ required: true, message: '账号不能为空!' }]">
        <a-input v-model:value="registerForm.username" placeholder="请输入账号" max="28">
          <template #prefix>
            <UserOutlined />
          </template>
        </a-input>
      </a-form-item>

      <a-form-item name="password" :rules="[{ required: true, message: '密码不能为空!' }]">
        <a-input-password v-model:value="registerForm.password" placeholder="请输入密码" max="20">
          <template #prefix>
            <LockOutlined />
          </template>
        </a-input-password>
      </a-form-item>

      <a-form-item
        name="confirmPassword"
        :rules="[{ required: true, message: '确认密码不能为空!' }]"
      >
        <a-input-password
          v-model:value="registerForm.confirmPassword"
          placeholder="请确认密码"
          max="20"
        >
          <template #prefix>
            <LockOutlined />
          </template>
        </a-input-password>
      </a-form-item>

      <a-form-item name="nickname" :rules="[{ required: true, message: '昵称不能为空!' }]">
        <a-input v-model:value="registerForm.nickname" placeholder="请输入昵称" max="20">
          <template #prefix>
            <SmileOutlined />
          </template>
        </a-input>
      </a-form-item>

      <a-form-item name="email" :rules="[{ required: true, message: '电子邮箱不能为空!' }]">
        <a-input v-model:value="registerForm.email" placeholder="请输入电子邮箱" max="28">
          <template #prefix>
            <MailOutlined />
          </template>
        </a-input>
      </a-form-item>

      <a-form-item name="code" :rules="[{ required: true, message: '验证码不能为空!' }]">
        <a-input-group compact>
          <a-input
            v-model:value="registerForm.code"
            placeholder="请输入验证码"
            max="6"
            style="width: 70%"
          >
          </a-input>
          <a-button
            type="primary"
            @click="handleAskEmailCode"
            style="width: 30%"
            :disabled="codeState.isDisable"
          >
            {{ codeState.title }}
          </a-button>
        </a-input-group>
      </a-form-item>

      <a-form-item>
        <div class="buttons">
          <a-button type="primary" html-type="submit" class="register-form-button">
            立即注册
          </a-button>
          <a-button type="default" @click="router.push('/login')"> 我有账号</a-button>
        </div>
      </a-form-item>
    </a-form>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';

.register-card {
  min-width: 390px;
  padding: 60px 30px 30px 30px;
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

    .options {
      width: 100%;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .buttons {
      width: 100%;
      display: flex;
      flex-direction: column;
      gap: 10px;
    }
  }
}
</style>