import { createApp } from 'vue'
import { createPinia } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import App from '@/App.vue'
import router from '@/router'
import '@/assets/styles/normalize.scss'
import '@/assets/styles/global.scss'

const store = createPinia()
store.use(piniaPluginPersistedstate)

const app = createApp(App)

app.use(store)
app.use(router)

app.mount('#app')
