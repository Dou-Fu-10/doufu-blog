import {defineConfig, loadEnv} from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

export default defineConfig(({mode, command}) => {
    const env = loadEnv(mode, process.cwd())
    const {VITE_APP_ENV} = env

    return {
        plugins: [vue()],
        // 部署生产环境和开发环境下的URL。
        // 默认情况下，vite 会假设你的应用是被部署在一个域名的根路径上
        // 例如 https://www.ruoyi.vip/。如果应用被部署在一个子路径上，你就需要用这个选项指定这个子路径。例如，如果你的应用被部署在 https://www.ruoyi.vip/admin/，则设置 baseUrl 为 /admin/。
        base: VITE_APP_ENV === 'production' ? '/' : '/',
        resolve: {
            // https://cn.vitejs.dev/config/#resolve-alias
            alias: {
                // 设置别名
                '@': path.resolve(__dirname, './src')
            },
            // https://cn.vitejs.dev/config/#resolve-extensions
            extensions: ['.mjs', '.js', '.ts', '.jsx', '.tsx', '.json', '.vue']
        },
        // vite 相关配置
        server: {
            port: 88,
            host: true,
            open: false,
            proxy: {
                // https://cn.vitejs.dev/config/#server-proxy
                '/dev-api': {
                    target: 'http://localhost:8081',
                    changeOrigin: true,
                    rewrite: (p) => p.replace(/^\/dev-api/, '')
                }
            }
        },
        css: {
            // css预处理器
            preprocessorOptions: {
                scss: {
                    // 引入 mixin.scss 这样就可以在全局中使用 mixin.scss中预定义的变量了
                    // 给导入的路径最后加上 ;
                    additionalData: '@import "@/assets/styles/mixin.scss";'
                }
            }
        }

    }
})
