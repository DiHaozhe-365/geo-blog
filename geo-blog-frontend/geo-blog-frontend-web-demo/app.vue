<script lang="ts" setup>
import Header from "./components/common/Header.vue"
import { useSystemStore } from "./stores/system"

useSeoMeta({
    title: "邸浩哲Geo - 热爱可抵岁月漫长",
    description: "热爱可抵岁月漫长",
    keywords: "GeoBlog,邸浩哲,邸浩哲Geo",
})

// 配置 ant-design-vue 全局主题
const antdTheme = ref({
    token: {
        colorPrimary: "#1890ff",
    },
})
</script>

<template>
    <div class="app">
        <a-config-provider :theme="antdTheme">
            <Header></Header>
            <div class="content-background">
                <div class="content">
                    <NuxtPage />
                </div>
            </div>
        </a-config-provider>
    </div>
</template>

<style lang="scss">
@import "./assets/styles/normalize.scss";
@import "./assets/styles/theme.scss";

.content-background {
    padding-top: 80px;
    width: 100%;
    display: flex;
    justify-content: center;
    .content {
        max-width: 1400px;
        width: 100%;
        display: flex;
        justify-content: center;
        padding: 0 3rem;
    }
}
</style>
