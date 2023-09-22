import {defineStore} from 'pinia'
import axios from 'axios'

export const useColorStore = defineStore('colorStore', {
    state: () => ({
        colors: [],
        color: null,
        loading: false,
        error: null
    }),
    getters: {
        getColors: state => state.colors,
    },
    actions: {
        async fetchColors() {
            this.loading = true
            try {
                const response = await axios.get('http://localhost:8080/api/v1/colors')
                this.colors = response.data
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },
        async fetchColor(id) {
            this.loading = true
            try {
                const response = await axios.get(`/api/v1/colors/${id}`)
                this.color = response.data
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },
        async createColor(color) {
            this.loading = true
            try {
                await axios.post('/api/v1/colors', color)
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },
        async updateColor(color) {
            this.loading = true
            try {
                await axios.put(`/api/v1/colors/${color.id}`, color)
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },
        async deleteColor(id) {
            this.loading = true
            try {
                await axios.delete(`/api/v1/colors/${id}`)
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },

    }
})