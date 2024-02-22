// 表列
interface TableColumn {
    prop: string,
    label: string,
    sortable: boolean
}

export interface TableSupport {
    // 当前记录起始索引
    pageNum?: string
    // 每页显示记录数
    pageSize?: string
    // 排序列
    orderByColumn?: string
    // 排序的方向 "desc" 或者 "asc".
    isAsc?: string
    // 分页参数合理化
    reasonable?: string
}

// 分类数据返回
export interface TableDataInfo<T> {
    /**
     * 总记录数
     */
    total: number

    /**
     * 列表数据
     */
    rows: Array<T>

    /**
     * 消息状态码
     */
    code: number

    /**
     * 消息内容
     */
    msg: string

}

export interface AjaxResult<T> {
    /**
     * 状态码
     */
    code: number
    /**
     * 返回内容
     */
    msg: string
    /**
     * 数据对象
     */
    data: T
}
