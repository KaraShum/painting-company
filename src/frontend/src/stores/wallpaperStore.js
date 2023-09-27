import {defineStore} from 'pinia'
import axios from 'axios'

export const useWallpaperStore = defineStore('wallpaperStore', {
    state: () => ({
        wallpaper: [],
        color: null,
        loading: false,
        error: null
    }),
    getters: {
        getAll: state => state.wallpapers,
        getWallpaperById: state => id => state.wallpapers.find(color => color.id === id),
        getPrice: state => state.wallpaper.price,
    },
    actions: {
        async fetchWallpapers() {
            this.loading = true
            try {
                const response = await axios.get('http://localhost:8080/api/v1/wallpapers')
                this.wallpapers = response.data
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },
        async fetchWallpaper(id) {
            this.loading = true
            try {
                const response = await axios.get(`http://localhost:8080/api/v1/wallpapers/${id}`)
                this.wallpaper = response.data
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },
        async addWappaper(wallpaper, price) {
            this.loading = true
            try {
                await axios.post('http://localhost:8080/api/v1/wallpapers', {wallpaper, price}, {
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                    }
                })
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },
        async updatewallpaper(wallpaper) {
            this.loading = true
            try {
                await axios.put(`http://localhost:8080/api/v1/wallpapers/${wallpaper.id}`, wallpaper)
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },
        async deleteWallpaper(id) {
            this.loading = true
            try {
                await axios.delete(`/http://localhost:8080/api/v1/wallpapers/${id}`)
            } catch (error) {
                this.error = error
            } finally {
                this.loading = false
            }
        },

    }
})