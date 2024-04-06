export default defineNuxtRouteMiddleware((to, from) => {
    // 判断用户是否登录
    let isLogin = false
    if (!isLogin) {
        return navigateTo("/login")
    }
})
