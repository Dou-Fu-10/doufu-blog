import request from '@/utils/request'
import {Article} from "@/types/blog/article"
import {TableSupport} from "@/types/common"

// 获取标签列表
export function select(data?: TableSupport) {
    console.log(data);
    
    return request({
        url: '/blog/article',
        method: 'get',
        params: data
    })
}

export function selectOne() {
    return request({
        url: '/blog/article',
        method: 'get'
    })
}

export function insert(data: Article) {
    console.log(data)
    return request({
        url: '/blog/article',
        method: 'post',
        data
    })
}


export function update(data: Article) {
    console.log(data)
    return request({
        url: '/blog/article',
        method: 'put',
        data
    })
}

export function remove(ids: Array<bigint>) {
    return request({
        url: '/blog/article',
        method: "delete",
        data: ids
    })
}
