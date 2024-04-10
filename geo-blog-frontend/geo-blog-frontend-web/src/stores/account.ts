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
      storage: sessionStorage
    }
  }
)

// 清除本地所有空间Account登录状态
export const useRemoveAccount = () => {
  const accountStore = useAccountStore()
  accountStore.username = ''
  accountStore.role = ''
  accountStore.token = ''
  accountStore.expire = ''
  localStorage.removeItem('account')
  sessionStorage.removeItem('account')
}
