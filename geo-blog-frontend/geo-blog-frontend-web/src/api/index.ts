// api
import request from '@/utils/request'
import { message } from 'ant-design-vue'
import { useAccountStore } from '@/stores/account'

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

// 参数接口
export interface LoginParams {
  username: string
  password: string
  remember: boolean
}

/**
 * 登录接口
 * @param {object} params LoginRequest
 * @param {string} params.username
 * @param {string} params.password
 * @param {boolean} params.remember
 * @returns
 */
export const login = async (params: LoginParams) => {
  try {
    const response = await request.post('/api/auth/login', params)
    if (response.code === 200) {
      message.success('登录成功')
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
 * 获取用户列表接口
 * @returns
 */
export const getAccountList = async () => {
  try {
    const response = await request.get('/api/account/list')
    if (response.code === 200) {
      console.log('请求成功')
    } else {
      message.warning(response.message)
    }
    return response
  } catch (error: any) {
    defaultError()
    console.log(error)
    throw error
  }
}

/**
 * 获取你好接口
 * @returns
 */
export const getHello = async () => {
  try {
    return await request.get('/api/test/hello')
  } catch (error: any) {
    defaultError()
    console.log(error)
    throw error
  }
}
