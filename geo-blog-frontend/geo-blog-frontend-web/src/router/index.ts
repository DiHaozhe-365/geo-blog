import { createRouter, createWebHistory } from 'vue-router'
import { useAccountStore } from '@/stores/account'
import Home from '@/views/Home.vue'
import Login from '@/views/Login.vue'
import Register from '@/views/Register.vue'
import Post from '@/views/Post.vue'
import Note from '@/views/Note.vue'
import My from '@/views/My.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
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
      path: '/my',
      name: 'my',
      component: My
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
    alert('您还没有登录，请先登录')
    next('/login')
  }
})

export default router
