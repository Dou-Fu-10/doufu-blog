import request from '@/utils/request'
import {Tag} from "@/types/blog/tags"
import {TableSupport} from "@/types/common"

// 获取标签列表
export function select(data?: TableSupport) {
    console.log(data)
    return request({
        url: '/blog/tags',
        method: 'get',
        params: data
    })
}

export function selectOne() {
    return request({
        url: '/blog/tags',
        method: 'get'
    })
}

export function insert(data: Tag) {
    return request({
        url: '/blog/tags',
        method: 'post',
        data
    })
}


export function update(data: Tag) {
    return request({
        url: '/blog/tags',
        method: 'put',
        data
    })
}

export function remove(ids: Array<bigint>) {
    return request({
        url: '/blog/tags',
        method: "delete",
        data: ids
    })
}
