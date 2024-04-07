import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useAccountStore = defineStore(
  'account',
  () => {
    const username = ref('')
    const role = ref('')
    const token = ref('')
    const expire = ref('')
    return { username, role, token, expire }
  },
  {
    persist: {
      enabled: true,
      strategies: [
        {
          key: 'token',
          storage: localStorage,
          paths: ['token']
        },
        {
          key: 'expire',
          storage: localStorage,
          paths: ['expire']
        }
      ]
    }
  }
)
