import { createRouter, createWebHistory } from 'vue-router'
import FormDisplay from '../views/FormDisplay.vue'
import DataDisplay from '../views/DataDisplay.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: FormDisplay
    },
    {
      path: '/DataDisplay',
      name: 'datadisplay',
      component: DataDisplay
    }
  ]
})

export default router
