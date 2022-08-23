import { createApp } from 'vue'
import App from './App'
import { plugin, defaultConfig } from '@formkit/vue'
import '@formkit/themes/genesis'
import router from '@/router'

createApp(App).use(router).use(plugin, defaultConfig).mount('#app')