<script lang="ts" setup>
const props = defineProps(['message'])
</script>

<template>
  <div class="smart-ball">
    <div class="blue-ball"></div>
    <div class="inner-ball"></div>
    <div class="inner-ball-text">
      <span>{{ props.message }}</span>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
.smart-ball {
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  width: 100%;
  .blue-ball {
    position: absolute;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    animation: blueBall 0.8s ease forwards;
    @include useTheme {
      background: var(--geo-theme);
    }
  }
  .inner-ball {
    position: absolute;
    width: 52px;
    height: 52px;
    border-radius: 50%;
    backdrop-filter: blur(7px);
    animation: innerBall 0.8s ease forwards;
    @include useTheme {
      background: var(--geo-smart-ball-bg);
    }
  }
  .inner-ball-text {
    position: absolute;
    height: 52px;
    border-radius: 1000px;
    backdrop-filter: blur(7px);
    animation: innerBallText 1.6s ease forwards;
    justify-content: center;
    align-items: center;
    white-space: nowrap;
    cursor: pointer;
    font-size: 18px;
    font-weight: 500;
    transition: 0.3s;
    @include useTheme {
      background: var(--geo-smart-ball-bg);
      border: 1px solid var(--geo-card-border);
      color: var(--geo-font-color);
    }
    &:hover {
      @include useTheme {
        color: var(--geo-font-color-hover);
        background: var(--geo-theme);
      }
    }
    &:active {
      transform: scale(95%);
    }
    span {
      margin: 0 10px;
      animation: innerBallTextSpan 1s ease forwards;
      user-select: none;
    }
  }
}

@keyframes innerBall {
  0% {
    width: 0;
    height: 0;
    transform: translateY(80px);
  }
  100% {
    width: 52px;
    height: 52px;
    transform: translateY(0);
    display: none;
  }
}

@keyframes blueBall {
  0% {
    width: 0;
    height: 0;
    transform: translateY(80px);
  }
  15% {
    width: 0px;
    height: 0px;
  }
  75% {
    width: 90px;
    height: 90px;
  }
  100% {
    width: 50px;
    height: 50px;
    transform: translateY(0);
    display: none;
  }
}

@keyframes innerBallText {
  0% {
    display: none;
    width: 52px;
  }
  50% {
    width: 52px;
    padding: 0;
    display: none;
  }
  70% {
    width: 100%;
    display: flex;
  }
  100% {
    width: 100%;
    display: flex;
  }
}
@keyframes innerBallTextSpan {
  0% {
    opacity: 0;
    display: none;
  }
  10% {
    opacity: 0;
    display: block;
  }
  100% {
    opacity: 1;
    display: block;
  }
}
</style>
