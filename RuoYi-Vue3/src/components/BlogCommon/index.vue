<script name="BlogCommon" setup lang="ts">
import TableColumn from "@/types/blog/common"
import {onMounted, ref} from 'vue'
import {TableSupport} from "@/types/common"

let tablePaging: TableSupport = {
  // 当前记录起始索引
  pageNum: 1,
  // 每页显示记录数
  pageSize: 10,
}
// 总共多少条
const total = ref(0)
// 数据列表
const dataList = ref([])

const props = defineProps<{
  tableColumn: Array<TableColumn>,
  // 获取数据的方法
  data: Function,
}
>();

// 切换显示数量
const handleSizeChange = (val: number) => {
  tablePaging.pageSize = val
  getDataList()
}
// 切换页码
const handleCurrentChange = (val: number) => {
  tablePaging.pageNum = val
  getDataList()
}
const load = (row: unknown, treeNode: unknown, resolve: (date: unknown[]) => void) => {
  setTimeout(() => {
    resolve([
      {
        id: 31,
        date: '2016-05-01',
        name: 'wangxiaohu',
        address: 'No. 189, Grove St, Los Angeles',
      },
      {
        id: 32,
        date: '2016-05-01',
        name: 'wangxiaohu',
        address: 'No. 189, Grove St, Los Angeles',
      },
    ])
  }, 1000)
}
// 获取数据
const getDataList = async () => {
  const res = await props.data(tablePaging);
  dataList.value = res.rows
  total.value = parseInt(res.total)
  return res;
}

onMounted(() => {
  getDataList()
})
const refresh = (data?: unknown) => {
  tablePaging = Object.assign(tablePaging, data);
  getDataList()
};
defineExpose({refresh})
</script>

<template>
  <slot name="header"></slot>
  <slot name="add"></slot>
  <!--数据表格-->
  <el-table
      class="table"
      :data="dataList"
      style="width: 100%"
      row-key="id"
      border
      lazy
      :load="load"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
  >
    <el-table-column :prop="column.prop" :label="column.label" :sortable="column.sortable"
                     v-for="column in props.tableColumn">
    </el-table-column>
    <slot name="operation"></slot>
  </el-table>
  <!--分页-->
  <div class="demo-pagination-block">
    <el-pagination
        :current-page="tablePaging.pageNum"
        :page-size="tablePaging.pageSize"
        :page-sizes="[5, 10, 15, 20]"
        :background="true"
        layout="total, sizes, prev, pager, next, jumper"
        :total=total
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </div>
</template>

<style lang="scss" scoped>


.table {
  height: calc(100vh - 300px);
  max-height: calc(100vh - 300px);
  min-height: 270px;
}

.el-pagination {
  margin-top: 30px;
  justify-content: center;
}
</style>
