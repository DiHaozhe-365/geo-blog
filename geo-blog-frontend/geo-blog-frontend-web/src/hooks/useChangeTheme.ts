import { useSystemStore } from '@/stores/system'

export const useChangeTheme = (theme: string) => {
  const systemStore = useSystemStore()
  document.getElementsByTagName('html')[0].dataset.theme = theme
  systemStore.theme = theme
}
