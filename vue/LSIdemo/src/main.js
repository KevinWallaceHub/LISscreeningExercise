
import App from './App.vue'
import router from './router'
import { createApp, onMounted } from 'vue'
import axios from 'axios'
import './assets/main.css'


const app = createApp(App)

app.use(router) 

app.mount('#app')


router.afterEach((to, from) => {
    if (to.name === 'datadisplay' && from.name === 'home') {
      const entry = router.currentRoute.value.params.entry;
      router.app.$store.commit('addEntry', entry);
    }
});
