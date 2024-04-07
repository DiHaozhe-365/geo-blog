// api
import request from '@/utils/request'
import { useAccountStore } from '@/stores/account'

// 参数接口
export interface LoginParams {
  username?: string
  password?: string
}

/**
 * 登录接口
 * @param {object} params LoginRequest
 * @param {string} params.username
 * @param {string} params.password
 * @returns
 */
export const login = async (params: LoginParams) => {
  try {
    const response = await request.post('/api/auth/login', params)
    if (response.code === 200) {
      const accontStore = useAccountStore()
      accontStore.username = response.data.username
      accontStore.role = response.data.role
      accontStore.token = response.data.token
      accontStore.expire = response.data.expire
    }
    return response
  } catch (error: any) {
    console.log(error.message)
    throw error
  }
}