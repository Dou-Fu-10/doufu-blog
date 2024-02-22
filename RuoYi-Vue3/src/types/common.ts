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
