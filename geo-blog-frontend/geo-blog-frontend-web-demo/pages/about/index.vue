<script lang="ts" setup>
// 使用了具名路由中间件
definePageMeta({
    middleware: "auth",
})

// 下面是匿名路由中间
// definePageMeta({
//     middleware: defineNuxtRouteMiddleware(() => {
//         // 判断用户是否登录
//         let isLogin = false
//         if (!isLogin) {
//             return navigateTo("/login")
//         }
//     }),
// })
</script>

<template>
    <div class="about">这是关于页</div>
    <a-button type="primary">测试</a-button>
</template>

<style lang="scss" scoped></style>
