import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { plugin as dialogPlugin } from 'gitart-vue-dialog'
import Toaster from "@meforma/vue-toaster";
import { VueCookieNext } from 'vue-cookie-next'


const app = createApp(App)
app.use(dialogPlugin)
app.use(router)
app.use(VueCookieNext)
app.use(Toaster)

VueCookieNext.config({
    expire: '7d',
    path: '/',
    domain: '',
    secure: '',
    sameSite: '',
  });
VueCookieNext.setCookie('lang', 'en')
app.mount('#app')
