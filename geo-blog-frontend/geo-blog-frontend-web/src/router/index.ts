import { createRouter, createWebHistory } from 'vue-router'
import { useAccountStore } from '@/stores/account'
import Index from '@/views/Index.vue'
import Post from '@/views/Post.vue'
import Note from '@/views/Note.vue'
import Tutorial from '@/views/Tutorial.vue'
import Service from '@/views/Service.vue'
import Register from '@/views/Register.vue'
import About from '@/views/About.vue'
import Login from '@/views/Login.vue'
import { message } from 'ant-design-vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    },
    {
      path: '/post',
      name: 'post',
      component: Post
    },
    {
      path: '/note',
      name: 'note',
      component: Note
    },
    {
      path: '/tutorial',
      name: 'tutorial',
      component: Tutorial
    },
    {
      path: '/service',
      name: 'service',
      component: Service
    },
    {
      path: '/about',
      name: 'about',
      component: About
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    }
  ]
})

router.beforeEach((to, from, next) => {
  const accountStore = useAccountStore()
  if (
    to.path === '/' ||
    to.path === '/login' ||
    to.path === '/register' ||
    accountStore.role !== ''
  ) {
    next()
  } else {
    message.info('您还没有登录，请先登录')
    next('/login')
  }
})

export default router
