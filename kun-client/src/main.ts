import {createApp} from 'vue'
import App from '@/App.vue'
// 引入自定义路由
import router from '@/router'
// 引入element-plus 和样式
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// 引入element icon
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import store from '@/store'

import UndrawUi from 'undraw-ui'
import 'undraw-ui/dist/style.css'

const app = createApp(App)
// 按需引入icon
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

app.use(UndrawUi)
app.use(store)
app.use(router);
app.use(ElementPlus)
app.mount('#app')
