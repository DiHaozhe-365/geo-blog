// api
import request from '@/utils/request'
import { message } from 'ant-design-vue'
import { useAccountStore, useRemoveAccount } from '@/stores/account'
import router from '@/router'

export interface Response {
  code: number
  message: string
  data?: any
}

const defaultError = () => {
  message.error('系统出错了，请联系管理员')
}

const defaultWarning = (response: Response) => {
  message.warning(response.message)
}

/**
 * 获取邮箱验证码接口
 * @param {object} params AskVerifyCodeRequest
 * @param {string} params.email
 * @param {string} params.type
 * @returns
 */
interface AskVerifyCodeParams {
  email: string
  type: 'register' | 'reset'
}

export const askVerifyCode = async (params: AskVerifyCodeParams) => {
  try {
    const response = await request.get('/api/auth/ask-code', params)
    if (response.code === 200) {
      message.success('验证码已发送至[' + params.email + ']，请注意查收')
    } else {
      defaultWarning(response)
    }
  } catch (error: any) {
    defaultError()
    console.log(error)
    throw error
  }
}

/**
 * 注册接口
 * @param {object} params RegisterRequest
 * @param {string} params.username
 * @param {string} params.email
 * @param {string} params.password
 * @param {string} params.confirmPaasword
 * @param {string} params.code
 * @returns
 */
export interface RegisterParams {
  username: string
  email: string
  password: string
  code: string
}

export const register = async (params: RegisterParams) => {
  try {
    const headers = {
      // 指定请求头
      'Content-Type': 'application/json'
    }
    const response = await request.post('/api/auth/register', params, headers)
    if (response.code === 200) {
      message.success('注册成功')
      router.push('/login')
    } else {
      defaultWarning(response)
    }
  } catch (error: any) {
    defaultError()
    console.log(error)
    throw error
  }
}

/**
 * 登录接口
 * @param {object} params LoginRequest
 * @param {string} params.username
 * @param {string} params.password
 * @param {boolean} params.remember
 * @returns
 */
export interface LoginParams {
  username: string
  password: string
  remember: boolean
}

export const login = async (params: LoginParams) => {
  try {
    const response = await request.post('/api/auth/login', params)
    if (response.code === 200) {
      const accontStore = useAccountStore()
      accontStore.username = response.data.username
      accontStore.role = response.data.role
      accontStore.token = response.data.token
      accontStore.expire = response.data.expire
      // 勾选记住我，将登录状态存储在本地存储空间
      if (params.remember) {
        const account: object = {
          username: accontStore.username,
          role: accontStore.role,
          token: accontStore.token,
          expire: accontStore.expire
        }
        localStorage.setItem('account', JSON.stringify(account))
      } else {
        // 未勾选记住我，将存储在本地存储空间的登录状态清除
        localStorage.removeItem('account')
      }
    } else {
      defaultWarning(response)
    }
  } catch (error: any) {
    defaultError()
    console.log(error)
    throw error
  }
}

/**
 * 退出登录接口
 * @returns
 */
export const logout = async () => {
  try {
    const response = await request.get('/api/auth/logout')
    if (response.code === 200) {
      useRemoveAccount()
    } else {
      defaultWarning(response)
    }
  } catch (error: any) {
    defaultError()
    console.log(error)
    throw error
  }
}

/**
 * 获取用户列表接口
 * @returns
 */
export const getAccountList = async () => {
  try {
    const response = await request.get('/api/account/list')
    return response
  } catch (error: any) {
    defaultError()
    console.log(error)
    throw error
  }
}

/**
 * 下载图片
 * @param {string} img
 * @returns {Promise<string>} 临时URL
 */
// 响应接口
export interface DownloadImgRes {}

/**
 * 下载图片
 * @param {string} img
 * @returns {Promise<string>} url
 */
export async function downloadImg(img: string) {
  try {
    const response = await request.get(`/api/img/download?img=${img}`)

    // Create a blob URL for the binary data
    const imageUrl = window.URL.createObjectURL(new Blob([response.data]))

    console.log(imageUrl)

    return imageUrl
  } catch (error) {
    console.error('Error downloading image:', error)
    return null // or handle the error appropriately
  }
}
