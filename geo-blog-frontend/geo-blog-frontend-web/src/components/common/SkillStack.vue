<script lang="ts" setup>
import { ref } from 'vue'
const skills = ref([
  {
    id: 1,
    name: 'HTML5',
    img: '/src/assets/images/skills/HTML.png'
  },
  {
    id: 2,
    name: 'CSS3',
    img: '/src/assets/images/skills/CSS.png'
  },
  {
    id: 3,
    name: 'Sass',
    img: '/src/assets/images/skills/sass.png'
  },
  {
    id: 4,
    name: 'TS',
    img: '/src/assets/images/skills/typescript.png'
  },
  {
    id: 5,
    name: 'Vue',
    img: '/src/assets/images/skills/vue.png'
  },
  {
    id: 6,
    name: 'React',
    img: '/src/assets/images/skills/react.png'
  },
  {
    id: 7,
    name: 'SpringBoot',
    img: '/src/assets/images/skills/spring-boot.png'
  },
  {
    id: 8,
    name: 'Java',
    img: '/src/assets/images/skills/java.png'
  }
])
</script>

<template>
  <div class="skill-stack">
    <div class="skill-pair">
      <div class="skill" v-for="skill in skills" :key="skill.id">
        <img :src="skill.img" :alt="skill.name" />
      </div>
    </div>
    <div class="skill-pair">
      <div class="skill" v-for="skill in skills" :key="skill.id">
        <img :src="skill.img" :alt="skill.name" />
      </div>
    </div>
    <div class="skill-pair">
      <div class="skill" v-for="skill in skills" :key="skill.id">
        <img :src="skill.img" :alt="skill.name" />
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/theme';
.skill-stack {
  display: flex;
  flex-direction: column;
  gap: 20px;
  animation: skillStackUp 70s infinite linear;
  .skill-pair {
    display: flex;
    width: 320px;
    flex-wrap: wrap;
    gap: 20px;
    .skill {
      width: 140px;
      height: 140px;
      border-radius: 35px;
      background-color: #867412;
      display: flex;
      justify-content: center;
      align-items: center;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      @include useTheme {
        background: var(--geo-smart-ball-bg) !important;
      }
      img {
        width: 60%;
        transform: translateY(0px);
        user-select: none;
        -moz-user-select: none;
        -webkit-user-select: none;
        -ms-user-select: none;
        -khtml-user-select: none;
      }
    }
    :nth-child(odd) {
      transform: translateY(-20px);
    }
  }
}

@keyframes skillStackUp {
  0% {
    transform: translateY(30%);
  }

  50% {
    transform: translateY(-30%);
  }

  100% {
    transform: translateY(30%);
  }
}
</style>
