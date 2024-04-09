//  new Date => "xxxx-xx-xx xx:xx:xx.xxx"
export const getFormatDate = () => {
  const date = new Date()
  const year = date.getFullYear() // 获取年份
  const month = ('0' + (date.getMonth() + 1)).slice(-2) // 获取月份，注意+1
  const day = ('0' + date.getDate()).slice(-2) // 获取日期
  const hours = ('0' + date.getHours()).slice(-2) // 获取小时
  const minutes = ('0' + date.getMinutes()).slice(-2) // 获取分钟
  const seconds = ('0' + date.getSeconds()).slice(-2) // 获取秒数
  const milliseconds = ('00' + date.getMilliseconds()).slice(-3) // 获取毫秒数
  return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}.${milliseconds}`
}

export const isExpired = (str: string) => {
  const targetDate = new Date(str) // 根据传入的时间字符串创建Date对象
  const now = new Date() // 获取当前时间
  if (now > targetDate) {
    return true // 当前时间已经超过了传入的时间字符串表示的时间
  } else {
    return false // 当前时间还未超过传入的时间字符串表示的时间
  }
}
