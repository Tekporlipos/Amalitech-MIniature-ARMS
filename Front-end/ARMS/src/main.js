import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { plugin as dialogPlugin } from 'gitart-vue-dialog'
import Toaster from "@meforma/vue-toaster";

const app = createApp(App)
app.use(dialogPlugin)
app.use(router)
app.use(Toaster)

app.mount('#app')
