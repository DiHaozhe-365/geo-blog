class Config {
  private BACKEND_ROOT_URL: string = '' // 后端根路径
  private TIMEOUT_PERIOD: number = 0 // 请求超时时间

  constructor() {
    switch (process.env.NODE_ENV) {
      case 'development': // 开发环境配置项
        this.BACKEND_ROOT_URL = 'http://localhost:8090'
        this.TIMEOUT_PERIOD = 20000
        break
      case 'production': // 生产环境配置项
        this.BACKEND_ROOT_URL = 'http://dihaozhe.com'
        this.TIMEOUT_PERIOD = 20000
        break
    }
  }

  public getBackendRootURL(): string {
    return this.BACKEND_ROOT_URL
  }

  public getTimeoutPeriod(): number {
    return this.TIMEOUT_PERIOD
  }
}

export default new Config()
