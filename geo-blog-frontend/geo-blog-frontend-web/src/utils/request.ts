// request.ts
import type { AxiosInstance, AxiosResponse, InternalAxiosRequestConfig } from 'axios'
import axios from 'axios'
import config from '@/config'
import { isExpired } from '@/utils/time'
import { useRemoveAccount } from '@/stores/account'

export interface Response {
  code: number
  message: string
  data?: any
}

export interface RequestOptions {
  url: string
  method?: string
  params?: any
  data?: any
  headers?: any
}

export interface Account {
  username: string
  password: string
  role: string
  token: string
  expire: string
}

class Request {
  private instance: AxiosInstance

  constructor() {
    this.instance = axios.create({
      baseURL: config.getBackendRootURL(),
      timeout: config.getTimeoutPeriod()
    })
    this.instance.interceptors.request.use(
      this.handleRequestIntercept,
      this.handleRequestInterceptError
    )
  }

  private handleRequestIntercept(config: InternalAxiosRequestConfig): InternalAxiosRequestConfig {
    // 修改请求头中的Content-Type为'application/x-www-form-urlencoded'
    config.headers['Content-Type'] = 'application/x-www-form-urlencoded'
    // 尝试从本地存储中获取Token信息
    const account: string =
      localStorage.getItem('account') ||
      sessionStorage.getItem('account') ||
      '{"token":"","expire":""}'
    const accountJSON: Account = JSON.parse(account)
    const token: string = accountJSON.token || ''
    const expire: string = accountJSON.expire || ''
    // 判断该Token是否存在
    if (token !== '') {
      //判断该Token是否过期
      if (!isExpired(expire)) {
        // 未过期，写入请求头
        config.headers['Authorization'] = 'Bearer ' + token
      } else {
        // 已过期，清除Account
        useRemoveAccount()
      }
    }
    useRemoveAccount()
    return config
  }

  private handleRequestInterceptError(error: any): Promise<any> {
    return Promise.reject(error)
  }

  public get(url: string, params?: any, headers?: any): Promise<Response> {
    return this.request({
      url,
      method: 'get',
      params,
      headers
    })
  }

  public post(url: string, data?: any, headers?: any): Promise<Response> {
    return this.request({
      url,
      method: 'post',
      data,
      headers
    })
  }

  public put(url: string, data?: any, headers?: any): Promise<Response> {
    return this.request({
      url,
      method: 'put',
      data,
      headers
    })
  }

  public delete(url: string, data?: any, headers?: any): Promise<Response> {
    return this.request({
      url,
      method: 'delete',
      data,
      headers
    })
  }

  private async request(options: RequestOptions): Promise<Response> {
    try {
      const response: AxiosResponse<Response> = await this.instance.request(options)
      return response.data
    } catch (error: any) {
      throw error.response ? error.response.data : error
    }
  }
}

const request = new Request()

export default request
