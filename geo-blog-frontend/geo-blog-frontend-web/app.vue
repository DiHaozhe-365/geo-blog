<script name="app" lang="ts" setup>
useSeoMeta({
    title: "交大软件工程助手",
    description: "更适合 DJTU 软件工程学生体质的学习平台",
    keywords: "大连,交通大学,软件工程,DJTU",
})
</script>

<template>
    <div class="app">
        <NuxtLink to="/">首页</NuxtLink>
        <NuxtLink to="/about">关于</NuxtLink>
        <NuxtPage />
    </div>
</template>

<style lang="scss">
@import "./assets/styles/normalize.scss";
@import "./assets/styles/theme.scss";

.app {
    @include useTheme {
        background-color: var(--hao-background);
    }
}
// // 设置 Vant 全局变量
:root {
    --van-primary-color: rgb(0, 122, 255) !important;
}
</style>
