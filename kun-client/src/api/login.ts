import request from '@/utils/request'
import {UserInfo} from "@/types/user";

// 登录方法
export function login(userInfo: UserInfo) {
    return request({
        url: '/login',
        headers: {
            isToken: false,
            repeatSubmit: false
        },
        method: 'post',
        data: userInfo
    })
}

// 注册方法
export function register(userInfo: UserInfo) {
    return request({
        url: '/register',
        headers: {
            isToken: false
        },
        method: 'post',
        data: userInfo
    })
}

// 获取用户详细信息
export function getInfo() {
    return request({
        url: '/getInfo',
        method: 'get'
    })
}

// 退出方法
export function logout() {
    return request({
        url: '/logout',
        method: 'post'
    })
}

// 获取验证码
export function getCodeImg() {
    return request({
        url: '/captchaImage',
        headers: {
            isToken: false
        },
        method: 'get',
        timeout: 20000
    })
}
