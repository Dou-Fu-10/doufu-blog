<script lang="ts" name="Message" setup>
import BlogCommon from "@/components/BlogCommon/index.vue"
import Category from "@/types/blog/category"
import TableColumn from "@/types/blog/common"
import {ref} from "vue";

const input = ref('')
const tableColumn: Array<TableColumn> = [
  {
    prop: "id",
    label: "ID",
    sortable: false
  },
  {
    prop: "name",
    label: "头像",
    sortable: false
  },
  {
    prop: "address",
    label: "昵称",
    sortable: false
  },

  {
    prop: "createTime",
    label: "留言邮箱",
    sortable: false
  },

  {
    prop: "createTime",
    label: "回复状态",
    sortable: false
  },

  {
    prop: "createTime",
    label: "留言内容",
    sortable: false
  },
  {
    prop: "createTime",
    label: "是否管理员",
    sortable: false
  },
  {
    prop: "createTime",
    label: "创建时间",
    sortable: false
  },
  {
    prop: "UpdateTime",
    label: "修改时间",
    sortable: false
  }
]

const categoryList: Category[] = [
  {
    id: 1,
    date: '2016-05-02',
    name: 'wangxiaohu',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    id: 2,
    date: '2016-05-04',
    name: 'wangxiaohu',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    id: 3,
    date: '2016-05-01',
    name: 'wangxiaohu',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    id: 4,
    date: '2016-05-03',
    name: 'wangxiaohu',
    address: 'No. 189, Grove St, Los Angeles',
  },
]


// 添加分类
const addCategory = () => {
  console.log("添加")
}
// 修改
const handleEdit = (index: number, row) => {
  console.log(index, row)
}
// 删除
const handleDelete = (index: number, row) => {
  console.log(index, row)
}
// 搜索
const search = () => {
  console.log("search")
  console.log(input.value)
}
const getCategoryList = () => {
  console.log("获取分类数据")
  return categoryList;
}

const handleChange = (value) => {
  console.log(value)
}
</script>

<template>
  <div class="app-container">
    <BlogCommon
        :add="addCategory"
        :data="getCategoryList"
        :handle-delete="handleDelete"
        :handle-edit="handleEdit"
        :search="search"
        :table-column="tableColumn">
      <!--搜索框-->
      <template #header>
        <div class="kun-search">
          <el-input v-model="input" class="input" clearable placeholder="输入昵称搜索"/>
          <el-input v-model="input" class="input" clearable placeholder="输入留言内容搜索"/>
          <el-button type="primary" @click="search">搜索</el-button>
        </div>
      </template>
      <!--添加-->
      <template #add>
        <!-- 添加 -->
        <el-button style="margin-bottom: 10px" @click="">添加</el-button>
      </template>
    </BlogCommon>
  </div>
</template>

<style lang="scss" scoped>
</style>
