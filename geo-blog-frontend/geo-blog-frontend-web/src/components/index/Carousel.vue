<script lang="ts" setup>
import { ref } from 'vue'
import router from '@/router'

const carouselList = ref([
  {
    id: 1,
    title: '',
    link: '/post/1',
    img: '/src/assets/images/carousel/img.png'
  },
  {
    id: 2,
    title: 'CSS',
    link: '/post/2',
    img: '/src/assets/images/carousel/img2.png'
  },
  {
    id: 3,
    title: 'JS',
    link: '/post/3',
    img: '/src/assets/images/carousel/img3.png'
  },
  {
    id: 4,
    title: 'TS',
    link: '/post/4',
    img: '/src/assets/images/carousel/img4.png'
  },
  {
    id: 5,
    title: 'Vue',
    link: '/post/5',
    img: '/src/assets/images/carousel/img5.png'
  }
])

// 当前图片索引
const currentImg = ref(1)
// 定时器实现自动轮播
let autoPlay: any
const carouselImgList = ref<any>(null)

// 开启定时轮播
const startAutoPlay = () => {
  autoPlay = setInterval(() => {
    if (currentImg.value === carouselImgList.value.children.length) {
      currentImg.value = 0
    }
    currentImg.value = currentImg.value + 1
    for (let i = 0; i < carouselImgList.value.children.length; i++) {
      carouselImgList.value.children[i].style.display = 'none'
    }
    carouselImgList.value.children[currentImg.value - 1].style.display = 'block'
  }, 4000)
}
startAutoPlay()

// 下一张
const nextImg = () => {
  clearInterval(autoPlay)
  if (currentImg.value === carouselImgList.value.children.length) {
    currentImg.value = 0
  }
  currentImg.value = currentImg.value + 1
  for (let i = 0; i < carouselImgList.value.children.length; i++) {
    carouselImgList.value.children[i].style.display = 'none'
  }
  carouselImgList.value.children[currentImg.value - 1].style.display = 'block'
  startAutoPlay()
}

// 上一张
const lastImg = () => {
  clearInterval(autoPlay)
  if (currentImg.value === 1) {
    currentImg.value = carouselImgList.value.children.length + 1
  }
  currentImg.value = currentImg.value - 1
  for (let i = 0; i < carouselImgList.value.children.length; i++) {
    carouselImgList.value.children[i].style.display = 'none'
  }
  carouselImgList.value.children[currentImg.value - 1].style.display = 'block'
  startAutoPlay()
}

// 跳转到图片
const toImg = (id: number) => {
  clearInterval(autoPlay)
  currentImg.value = id
  for (let i = 0; i < carouselImgList.value.children.length; i++) {
    carouselImgList.value.children[i].style.display = 'none'
  }
  carouselImgList.value.children[id - 1].style.display = 'block'
  startAutoPlay()
}

// 点击后跳转到对应路径
const linkTo = (path: string) => {
  router.push(path)
}
</script>

<template>
  <div class="carousel">
    <div ref="carouselImgList" class="carousel-img-list">
      <div
        class="carousel-img"
        v-for="(carousel, index) in carouselList"
        :key="index"
        @click="linkTo(carousel.link)"
      >
        <span v-if="carousel.title !== ''" class="carousel-title">{{ carousel.title }}</span>
        <img :src="carousel.img" alt="carousel img" draggable="false" />
      </div>
    </div>
    <div class="carousel-points">
      <ul>
        <li
          v-for="(point, index) in carouselList"
          :key="index"
          @click="toImg(index + 1)"
          :class="{ active: currentImg === index + 1 }"
        ></li>
      </ul>
    </div>
    <div class="carousel-left-button" @click="lastImg">◀</div>
    <div class="carousel-right-button" @click="nextImg">▶</div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
.carousel {
  position: relative;
  min-width: 652px;
  max-width: 690px;
  flex: 1;
  aspect-ratio: 16/9;
  border-radius: var(--geo-card-border-radius);
  display: flex;
  justify-content: space-between;
  align-items: center;
  animation: slidein 0.6s 0.1s backwards;
  overflow: hidden;
  @include useTheme {
    background: var(--geo-card-bg);
    border: 1px solid var(--geo-card-border);
  }
  .carousel-img-list {
    width: 100%;
    height: 100%;
    position: relative;
    .carousel-img {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      display: none;
      transition: all 1s;
      &:nth-child(1) {
        display: block;
      }
      img {
        width: 100%;
        height: 100%;
        user-select: none;
        -moz-user-select: none;
        -webkit-user-select: none;
        -ms-user-select: none;
        -khtml-user-select: none;
      }
      .carousel-title {
        position: absolute;
        bottom: 20px;
        left: 20px;
        font-size: 18px;
        padding: 2px 20px;
        border-radius: 6px;
        transition: 0.3s;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        backdrop-filter: blur(50px);
        cursor: pointer;
        user-select: none;
        @include useTheme {
          color: var(--geo-font-color);
          background: var(--geo-card-bg-70);
          border: 1px solid var(--geo-card-border);
        }
        &:hover {
          @include useTheme {
            color: var(--geo-font-color-hover);
            background: var(--geo-theme);
            border: 1px solid var(--geo-theme);
          }
        }
      }
    }
  }
  .carousel-points {
    position: absolute;
    bottom: 20px;
    right: 20px;
    display: flex;
    justify-content: center;
    ul {
      padding: 0;
      margin: 0;
      list-style: none;
      display: flex;
      justify-content: center;
      align-items: flex-end;
      gap: 10px;
      li {
        width: 10px;
        height: 10px;
        border-radius: 50%;
        cursor: pointer;
        transition: 0.3s;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        @include useTheme {
          border: 1px solid var(--geo-card-border);
        }
        &:hover {
          @include useTheme {
            width: 15px;
            height: 15px;
            background: var(--geo-font-hover);
          }
        }
        @include useTheme {
          background: var(--geo-card-border);
        }
      }
      .active {
        @include useTheme {
          background: var(--geo-theme);
        }
      }
    }
  }
  .carousel-left-button {
    position: absolute;
    left: 0;
    width: 20px;
    height: 80px;
    font-size: 8px;
    border-radius: 0 50px 50px 0;
    display: flex;
    justify-content: center;
    align-items: center;
    user-select: none;
    cursor: pointer;
    transition: 0.3s;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
    opacity: 0;
    @include useTheme {
      background: var(--geo-card-border);
      color: var(--geo-font-color);
    }
    &:hover {
      width: 50px;
      height: 50px;
      font-size: 16px;
      opacity: 1;
      @include useTheme {
        background: var(--geo-theme);
        color: var(--geo-font-color-hover);
      }
    }
    &:active {
      width: 40px;
    }
  }
  .carousel-right-button {
    position: absolute;
    right: 0;
    width: 20px;
    height: 80px;
    font-size: 8px;
    border-radius: 50px 0 0 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    user-select: none;
    cursor: pointer;
    transition: 0.3s;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
    opacity: 0;
    @include useTheme {
      background: var(--geo-card-border);
      color: var(--geo-font-color);
    }
    &:hover {
      width: 50px;
      height: 50px;
      font-size: 16px;
      opacity: 1;
      @include useTheme {
        background: var(--geo-theme);
        color: var(--geo-font-color-hover);
      }
    }
    &:active {
      width: 40px;
    }
  }
}
</style>
