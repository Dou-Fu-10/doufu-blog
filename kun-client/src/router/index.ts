import { createRouter, createWebHashHistory, Router, RouteRecordRaw, RouterOptions } from 'vue-router'
//由于router的API默认使用了类型进行初始化，内部包含类型定义，所以本文内部代码中的所有数据类型是可以省略的
//RouterRecordRaw是路由组件对象
const routes: RouteRecordRaw[] = [
    { path: '/', name: 'Home', component: () => import('@/views/home.vue') },
    { path: '/test', name: 'Test', component: () => import('@/views/test.vue') },
    { path: '/article/:articleId', name: 'Article', component: () => import('@/views/article.vue') },
    { path: '/about', name: 'About', component: () => import('@/views/about.vue') },
    { path: '/category', name: 'Category', component: () => import('@/views/category.vue') },
    { path: '/archives', name: 'Archives', component: () => import('@/views/archives.vue') },
    { path: '/tags', name: 'Tags', component: () => import('@/views/tags.vue') },
    { path: '/messageBoard', name: 'MessageBoard', component: () => import('@/views/messageBoard.vue') }
]

// RouterOptions是路由选项类型
const options: RouterOptions = {
    history: createWebHashHistory(),
    routes,
    scrollBehavior(to, from, savedPosition) {
        // 始终滚动到顶部
        return { top: 0 }
    },
}

// Router是路由对象类型
const router: Router = createRouter(options)

export default router;
