import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/Dashboard.vue'
import Login from "../views/Login.vue"
import Management from '../views/Management.vue'
import Employee from '../views/Employee.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/change-password',
      name: 'changePassword',
      component: Login
    },
    {
      path: '/management',
      name: 'management',
      component: Management
    },
    {
      path: '/employee',
      name: 'employee',
      component: Employee
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
