import { createWebHistory, createRouter } from "vue-router"
import Login from '../pages/Login.vue'
import Admin from '../pages/Admin.vue'

const history = createWebHistory()
const router = createRouter({
    history,
    routes: [
        {
            path: '/',
            component: Login
        },
        {
            path: '/admin',
            component: Admin
        }
    ]
})

export default router