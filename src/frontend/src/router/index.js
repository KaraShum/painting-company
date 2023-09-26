import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('../views/HomeView.vue')
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('../components/LoginForm.vue')
        },
        {
            path: '/register',
            name: 'register',
            component: () => import('../components/RegisterForm.vue')
        },
        {
            path: '/shop',
            name: 'shop',
            component: () => import('../components/ShopPage.vue')
        },
        {
            // catch all other routes
            path: '/:pathMatch(.*)*',
            name: 'PageNotFound',
            component: () => import('../components/PageNotFound.vue')
        }
    ]
})

export default router
