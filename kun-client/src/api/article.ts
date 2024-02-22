import request from '@/utils/request'
import {Article} from "@/types/article"
import {AjaxResult, TableDataInfo, TableSupport} from "@/types/common"

// 获取标签列表
export function select(data?: TableSupport): Promise<TableDataInfo<Article>> {
    return request({
        url: '/blog/article',
        method: 'get',
        params: data
    })
}

export function selectOne(articleId: string): Promise<AjaxResult<Article>> {
    return request({
        url: `/blog/article/${articleId}`,
        method: 'get',
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
