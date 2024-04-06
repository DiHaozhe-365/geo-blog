<script name="app" lang="ts" setup>
useSeoMeta({
    title: "GeoBlog",
    description: "热爱可抵岁月漫长",
    keywords: "GeoBlog,邸浩哲,邸浩哲Geo",
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
// 设置 Vant 全局变量
:root {
    --van-primary-color: rgb(0, 122, 255) !important;
}
</style>
