import { createRouter, createWebHistory } from 'vue-router'
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

export default router
