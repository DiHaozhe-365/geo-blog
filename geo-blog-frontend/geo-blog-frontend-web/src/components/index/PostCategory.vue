<script lang="ts" setup>
import { ref } from 'vue'

const categories = ref([
  {
    id: 1,
    name: '全部'
  },
  {
    id: 2,
    name: '前端'
  },
  {
    id: 3,
    name: '后端'
  },
  {
    id: 4,
    name: '安卓'
  },
  {
    id: 5,
    name: 'iOS'
  },
  {
    id: 6,
    name: '人工智能'
  },
  {
    id: 7,
    name: '开发工具'
  }
])

const activeCategoryName = ref('全部')

const changeCategory = (name: string) => {
  activeCategoryName.value = name
}
</script>

<template>
  <div class="post-category">
    <div class="categories">
      <div
        class="category"
        v-for="category in categories"
        :key="category.id"
        :class="{ active: activeCategoryName === category.name }"
        @click="changeCategory(category.name)"
      >
        {{ category.name }}
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
@import '@/assets/styles/layout';

.post-category {
  width: 100%;
  height: 50px;
  border-radius: var(--geo-card-border-radius);
  display: flex;
  justify-content: center;
  align-items: center;
  animation: slidein 0.6s 0.3s backwards;
  overflow: hidden;
  @include useTheme {
    background: var(--geo-card-bg);
    border: 1px solid var(--geo-card-border);
  }

  .categories {
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    padding: 20px;
    gap: 10px;

    .category {
      padding: 6px 8px;
      border-radius: 6px;
      user-select: none;
      cursor: pointer;
      transition: 0.1s;
      white-space: nowrap;
      @include useTheme {
        color: var(--geo-font-color);
      }

      &:hover {
        @include useTheme {
          background: var(--geo-font-color-hover);
          color: var(--geo-theme);
        }
      }

      &:active {
        opacity: 0.7;
      }
    }

    .active {
      @include useTheme {
        background: var(--geo-theme);
        color: var(--geo-card-bg) !important;
      }

      &:hover {
        @include useTheme {
          background: var(--geo-theme) !important;
        }
      }
    }
  }
}
</style>