// request.ts
import axios from 'axios'
import type { AxiosInstance, InternalAxiosRequestConfig, AxiosResponse } from 'axios'
import config from '@/config'

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
    // 设置Token
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
