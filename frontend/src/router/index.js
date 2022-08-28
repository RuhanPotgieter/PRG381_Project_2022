import { createWebHistory, createRouter } from "vue-router"
import Login from '../pages/Login.vue'
import Admin from '../pages/Admin.vue'
import Register from '../pages/Register.vue'
import NotFound from '../pages/404.vue'



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
        },
        {
            path: '/register',
            component: Register
        },
        {
            path: '/404',
            component: NotFound
        },
        {
            path: "/:catchAll(.*)",
            redirect: "/404"
        },
    ]
})

export default router