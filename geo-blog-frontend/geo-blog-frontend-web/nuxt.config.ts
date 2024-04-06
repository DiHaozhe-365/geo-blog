// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  // 开启 SSR 服务端渲染，默认开启
  ssr: true,
  // 开启 Nuxt 调试工具
  devtools: { enabled: true },
  // 应用模块
  modules: ['@vant/nuxt']
})
