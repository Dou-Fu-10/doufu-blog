import cache from '@/plugins/cache'
import modal from '@/plugins/modal'
import {App} from "vue";

export default function installPlugins(app: App) {
    // 缓存对象
    app.config.globalProperties.$cache = cache
    // 模态框对象
    app.config.globalProperties.$modal = modal
}
