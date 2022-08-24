import { createWebHistory, createRouter } from "vue-router"
import Login from '../pages/Login.vue'
import Admin from '../pages/Admin.vue'
import Register from '../pages/Register.vue'
import { register } from "@formkit/core"



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
        }
            
            
    ]
})

export default router