<script lang="ts" setup></script>

<template>
    <header class="header">
        <div class="header-content">
            <div class="header-left"></div>
            <nav class="header-middle">
                <NuxtLink class="header-middle-item" to="/post">文 章</NuxtLink>
                <NuxtLink class="header-middle-item" to="/note">笔 记</NuxtLink>
                <NuxtLink class="header-middle-item" to="/my">我 的</NuxtLink>
            </nav>
            <div class="header-right"></div>
        </div>
    </header>
</template>

<style lang="scss" scoped>
@import "@/assets/styles/theme";

.header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 60px;
    display: flex;
    justify-content: center;
    align-items: center;
    transition: 0.3s;
    @include useTheme {
        background: var(--hao-card-bg);
        outline: 1px solid var(--hao-card-border);
    }
    .header-content {
        max-width: 1400px;
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 0 3rem;
        .header-left {
            display: flex;
            justify-content: center;
            align-items: center;
            img {
                height: 20px;
                user-select: none;
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
                -khtml-user-select: none;
            }
        }
        .header-middle {
            display: flex;
            justify-content: center;
            align-items: center;
            .header-middle-item {
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 10px 15px;
                border-radius: 20px;
                margin: 0 5px;
                user-select: none;
                text-decoration: none;
                transition: 0.3s;
                cursor: pointer;
                background: none;
                @include useTheme {
                    font-weight: 500;
                    color: var(--hao-font-color);
                }
                &:hover {
                    @include useTheme {
                        color: var(--hao-font-color-hover);
                        background: var(--hao-theme);
                    }
                }
                &:active {
                    transform: scale(95%);
                }
            }
        }
        .header-right {
            display: flex;
            justify-content: center;
            align-items: center;
            .header-right-item {
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 0.3rem;
                border-radius: 50%;
                user-select: none;
                transition: 0.3s;
                cursor: pointer;
                &:hover {
                    @include useTheme {
                        background: var(--hao-card-border);
                    }
                }
            }
        }
    }
}
</style>
