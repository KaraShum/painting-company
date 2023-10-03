import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    linkActiveClass: 'active',
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
            path: '/company',
            name: 'company',
            component: () => import('../components/CompanyPage.vue'),
            meta: { requiresAuth: true }
        },
        {
            // catch all other routes
            path: '/:pathMatch(.*)*',
            name: 'PageNotFound',
            component: () => import('../components/PageNotFound.vue')
        }
    ]
});

// router.beforeEach(async (to) => {
//     const publicPages = ['/login', '/register', '/shop'];
//     const authRequired = !publicPages.includes(to.path);
//     const authStore = useAuthStore();
//
//     if (authRequired && !authStore.user) {
//         authStore.returnUrl = to.fullPath;
//         return '/login';
//     }
// });

export default router
