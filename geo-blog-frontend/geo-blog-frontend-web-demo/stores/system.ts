import defineStore from "@pinia/nuxt"
import { ref } from 'vue'

export const useSystemStore = defineStore(
  'system',
  () => {
    const theme = ref('')
    return { theme }
  },
  {
    persist: {
      enabled: true
    }
  }
)
