import { createApp } from 'vue'
import { createPinia } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import App from '@/App.vue'
import router from '@/router'
import Antd from 'ant-design-vue'
import '@/assets/styles/normalize.scss'
import '@/assets/styles/global.scss'
import 'ant-design-vue/dist/reset.css'

const store = createPinia()
store.use(piniaPluginPersistedstate)

const app = createApp(App)

app.use(store)
app.use(router)
app.use(Antd)

app.mount('#app')
