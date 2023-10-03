import { defineStore } from 'pinia';

export const useAuthStore = defineStore('auth', {
    state: () => ({
        isAuthenticated: false,
        user: null
    }),
    actions: {
        setUser(user) {
            this.isAuthenticated = true;
            this.user = user;
        },
        logout() {
            this.isAuthenticated = false;
            this.user = null;
        }
    },
    getters: {
        isAdmin() {
            return this.user && this.user.role === 'admin';
        }
    }
});
