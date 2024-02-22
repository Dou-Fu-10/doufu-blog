import request from '@/utils/request'
import {Category} from "@/types/category"
import {TableSupport} from "@/types/common"

// 获取标签列表
export function select(data?: TableSupport) {
    console.log(data)
    return request({
        url: '/blog/category',
        method: 'get',
        params: data
    })
}

export function selectOne() {
    return request({
        url: '/blog/category',
        method: 'get'
    })
}

export function insert(data: Category) {
    return request({
        url: '/blog/category',
        method: 'post',
        data
    })
}


export function update(data: Category) {
    return request({
        url: '/blog/category',
        method: 'put',
        data
    })
}

export function remove(ids: Array<bigint>) {
    return request({
        url: '/blog/category',
        method: "delete",
        data: ids
    })
}
