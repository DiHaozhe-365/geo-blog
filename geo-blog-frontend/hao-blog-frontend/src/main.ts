import { createApp } from 'vue'
import { createPinia } from 'pinia'
import piniaPluginPersist from 'pinia-plugin-persist'
import App from '@/App.vue'
import router from '@/router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import '@/styles/normalize.scss'
import '@/styles/global.scss'

const store = createPinia()
store.use(piniaPluginPersist)

const app = createApp(App)

app.use(store)
app.use(router)
app.use(ElementPlus)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.mount('#app')
