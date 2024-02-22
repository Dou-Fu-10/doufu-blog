<script lang="ts" name="Tags" setup>
import TableColumn from "@/types/blog/common"
import BlogCommon from "@/components/BlogCommon/index.vue"
import {Tag} from "@/types/blog/tags"
import {reactive, ref} from "vue";
import type {FormRules} from "element-plus";
import {ElMessage} from "element-plus";
import {insert, remove, select, update} from "@/api/blog/tags";
// 搜索框输入
const input = ref('')
// 是否开启对话框
const dialogFormVisible = ref<boolean>(false)
// 是否是添加数据
let isInsert = true
// 加载中
const submitLoading = ref<boolean>(false)
// 表列
const tableColumn: Array<TableColumn> = [
  {
    prop: "tagId",
    label: "ID",
    sortable: false
  },
  {
    prop: "tagName",
    label: "标签名称",
    sortable: false
  },
  {
    prop: "tagDesc",
    label: "描述",
    sortable: false
  },
  {
    prop: "createTime",
    label: "创建时间",
    sortable: false
  },
  {
    prop: "updateTime",
    label: "修改时间",
    sortable: false
  }
]
// 校验
const rules = reactive<FormRules<Tag>>({
  tagName: [
    {required: true, message: 'Please input Activity name', trigger: 'blur'},
    {min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur'},
  ],
  tagDesc: [
    {required: true, message: 'Please input Activity name', trigger: 'blur'},
    {min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur'},
  ],
})
// 定义一个对象关联上子组件的 ref 值（注意：这里的属性名必须跟子组件定义的 ref 值一模一样，否者会关联失效）
const blog = ref(null)
// 表单
let forms = reactive<Tag>({
  tagId: null,
  tagName: null,
  tagDesc: null
})
// 添加或更新
const saveOrUpdate = async () => {
  if (isInsert) {
    const res = await insert(forms)
    ElMessage({
      message: res.msg,
      type: 'success',
    })
  } else {
    const res = await update(forms)
    ElMessage({
      message: res.msg,
      type: 'success',
    })
    isInsert = true
  }
  dialogFormVisible.value = false
  refresh()
}
// 关闭对话框
const close = () => {
  dialogFormVisible.value = false
  resetFrom()
}
const resetFrom = () => {
  Object.entries(forms).forEach(function ([key, value]) {
    forms[key] = null; // 将每个属性值重置为默认值
  });
}
// 修改
const handleEdit = async (row: Tag) => {
  resetFrom()
  forms.tagId = row.tagId;
  forms.tagName = row.tagName;
  forms.tagDesc = row.tagDesc;
  dialogFormVisible.value = true
  isInsert = false
}

// 删除
const handleDelete = async (row: Tag) => {
  const res = await remove([row.tagId])
  ElMessage({
    message: res.msg,
    type: 'success',
  })
  refresh()
}
// 搜索
const handleSearch = () => {
  refresh({tagName: input.value})
}
// 刷新数据
const refresh = (data?: unknown) => {
  resetFrom()
  blog.value.refresh(data)//调用子组件的show方法
}
</script>

<template>
  <div class="app-container">
    <BlogCommon ref="blog" :data="select" :table-column="tableColumn">
      <!--搜索框-->
      <template #header>
        <div class="kun-search">
          <el-input v-model="input" class="input" clearable placeholder="输入标签名称搜索"/>
          <el-button type="primary" @click="handleSearch">搜索</el-button>
        </div>
      </template>
      <!--添加-->
      <template #add>
        <el-button style="margin-bottom: 10px" @click="dialogFormVisible = true">添加</el-button>
      </template>
      <template #operation>
        <el-table-column label="操作" fixed="right" width="200">
          <template #default="scope">
            <el-button type="primary" size="small" @click="handleEdit(scope.row)">修改</el-button>
            <el-popconfirm title="确定删除？" @confirm="handleDelete(scope.row)">
              <template #reference>
                <el-button size="small" type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </template>
    </BlogCommon>
    <el-dialog v-model="dialogFormVisible" title="添加标签">
      <el-form ref="ruleFormRef" :model="forms" :rules="rules" label-width="120px" class="demo-ruleForm"
               size="default"
               status-icon v-loading="submitLoading">
        <el-form-item label="标签名称" prop="categoryName">
          <el-input v-model="forms.tagName"/>
        </el-form-item>
        <el-form-item label="描述" prop="tagDesc">
          <el-input v-model="forms.tagDesc" type="textarea"/>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="close" :disabled="submitLoading">取消</el-button>
          <el-button @click="saveOrUpdate" :disabled="submitLoading" type="primary">保存</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<style lang="scss" scoped></style>
