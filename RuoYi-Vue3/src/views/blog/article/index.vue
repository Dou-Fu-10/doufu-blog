<script lang="ts" name="Article" setup>
import TableColumn from "@/types/blog/common"
import BlogCommon from "@/components/BlogCommon/index.vue"
import { Article } from "@/types/blog/article"
import '@wangeditor/editor/dist/css/style.css'
import { onBeforeUnmount, reactive, ref, shallowRef } from "vue";
import { Plus } from '@element-plus/icons-vue'
import type { FormRules, UploadProps } from 'element-plus'
import { ElMessage } from "element-plus";
import { insert, remove, select, update } from "@/api/blog/article";
import { Editor, Toolbar } from "@wangeditor/editor-for-vue";

const imageUrl = ref('')
// 搜索框输入
const input = reactive<Article>({
  articleTitle: null,
  isPublish: null,
  isHot: null,
  isRecommend: null,
})
// 是否是添加数据
let isInsert = true
// 是否开启编辑器
let isEditor = ref(false)
// 加载中
const submitLoading = ref<boolean>(false)
// 表列
const tableColumn: Array<TableColumn> = [
  {
    prop: "articleTitle",
    label: "博文名称",
    sortable: true
  },
  {
    prop: "categoryId",
    label: "博文类型",
    sortable: false
  },
  {
    prop: "isHot",
    label: "是否火热",
    sortable: false
  },

  {
    prop: "isTop",
    label: "是否推荐",
    sortable: false
  },

  {
    prop: "viewsCount",
    label: "浏览人数",
    sortable: true
  },

  {
    prop: "commentsCount",
    label: "评论数",
    sortable: true
  },
  {
    prop: "createTime",
    label: "创建时间",
    sortable: true
  },
  {
    prop: "updateTime",
    label: "修改时间",
    sortable: true
  },
  {
    prop: "isPublish",
    label: "是否发布",
    sortable: false
  }
]
// 校验
const rules = reactive<FormRules<Article>>({
  articleSummary: [
    { required: true, message: 'Please input Activity name', trigger: 'blur' },
    { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' },
  ],
})
// 定义一个对象关联上子组件的 ref 值（注意：这里的属性名必须跟子组件定义的 ref 值一模一样，否者会关联失效）
const blog = ref("")
// 表单
let forms = reactive<Article>({
  articleId: null,
  categoryId: null,
  articleTitle: null,
  articleSummary: null,
  articleContent: null,
  articleCover: null,
  viewsCount: null,
  commentsCount: null,
  isPublish: null,
  isTop: null,
  isHot: null,
  isRecommend: null,
  reprint: null,
  editType: null
})
// 添加或更新
const saveOrUpdate = async () => {
  if (isInsert) {
    forms.articleContent = valueHtml.value
    forms.categoryId = "1752598956161298433"
    const res = await insert(forms)
    ElMessage({
      message: res.msg,
      type: 'success',
    })
  } else {
    forms.articleContent = valueHtml.value
    forms.categoryId = "1752598956161298433"
    const res = await update(forms)
    ElMessage({
      message: res.msg,
      type: 'success',
    })
    isInsert = true
  }
  refresh()
}
const resetFrom = () => {
  Object.entries(forms).forEach(function ([key]) {
    forms[key] = null; // 将每个属性值重置为默认值
  });
  valueHtml.value = ""
}

// 修改
const handleEdit = async (row: Article) => {
  resetFrom()
  forms.articleId = row.articleId;
  isInsert = false
  forms = Object.assign(forms, row);
  valueHtml.value = row.articleContent
  isEditor.value = true
}

// 删除
const handleDelete = async (row: Article) => {
  const res = await remove([row.articleId])
  ElMessage({
    message: res.msg,
    type: 'success',
  })
  refresh()
}
// 搜索
const handleSearch = () => {
  refresh(
    input
  )
}
// 刷新数据
const refresh = (data?: unknown) => {
  console.log("更新数据")
  resetFrom()
  blog.value.refresh(data)//调用子组件的show方法
}

const handleAvatarSuccess: UploadProps['onSuccess'] = (
  response,
  uploadFile
) => {
  imageUrl.value = URL.createObjectURL(uploadFile.raw!)
}

const beforeAvatarUpload: UploadProps['beforeUpload'] = (rawFile) => {
  if (rawFile.type !== 'image/jpeg') {
    ElMessage.error('Avatar picture must be JPG format!')
    return false
  } else if (rawFile.size / 1024 / 1024 > 2) {
    ElMessage.error('Avatar picture size can not exceed 2MB!')
    return false
  }
  return true
}

// 编辑器实例，必须用 shallowRef
const editorRef = shallowRef()

// 内容 HTML
const valueHtml = ref("")

// 模拟 ajax 异步获取内容
// onMounted(() => {
//   setTimeout(() => {
//     valueHtml.value = '<p></p>'
//   }, 1500)
// })

const toolbarConfig = {}
const editorConfig = { placeholder: '请输入内容...' }

// 组件销毁时，也及时销毁编辑器
onBeforeUnmount(() => {
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})

const handleCreated = (editor) => {
  editorRef.value = editor // 记录 editor 实例，重要！
}
</script>

<template>
  <div class="app-container">
    <div v-show="!isEditor">
      <BlogCommon ref="blog" :data="select" :table-column="tableColumn">
        <!--搜索框-->
        <template #header>
          <div class="kun-search">
            <el-input v-model="input.articleTitle" class="input" clearable placeholder="输入分类名称搜索" />
            <el-select v-model="input.isPublish" clearable placeholder="选择发布状态搜索">
              <el-option label="已完成" :value="true" />
              <el-option label="为完成" :value="false" />
            </el-select>
            <el-select v-model="input.isRecommend" clearable placeholder="选择是否推荐搜索">
              <el-option label="是" :value="true" />
              <el-option label="否" :value="false" />
            </el-select>
            <el-select v-model="input.isHot" clearable placeholder="选择是否火热搜索">
              <el-option label="是" :value="true" />
              <el-option label="否" :value="false" />
            </el-select>
            <el-button type="primary" @click="handleSearch">搜索</el-button>
          </div>
        </template>
        <!--添加-->
        <template #add>
          <!-- 添加 -->
          <el-button style="margin-bottom: 10px" @click="isEditor = !isEditor">添加</el-button>
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
    </div>
    <div v-show="isEditor">
      <svg-icon icon-class="back" style="width: 50px;height: 50px" @click="isEditor = !isEditor; resetFrom()" />
      <div style="box-shadow: var(--el-box-shadow);margin: 20px 0">
        <!--工具栏-->
        <Toolbar style="border-bottom: 1px solid #ccc" :editor="editorRef" :defaultConfig="toolbarConfig"
          mode="default" />
        <!--编辑器-->
        <Editor style="height: 500px; overflow-y: hidden;" v-model="valueHtml" :defaultConfig="editorConfig"
          mode="default" @onCreated="handleCreated" />
      </div>
      <div>
        <el-form-item label="博文标题">
          <el-input v-model="forms.articleTitle" maxlength="30" placeholder="请输入博文摘要" show-word-limit type="textarea" />
        </el-form-item>
        <el-form-item label="博文封面">
          <el-input v-model="forms.articleCover" maxlength="30" placeholder="请输入博文摘要" show-word-limit type="textarea" />
        </el-form-item>
        <el-upload class="avatar-uploader" action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
          :show-file-list="false" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar" />
          <el-icon v-else class="avatar-uploader-icon">
            <Plus />
          </el-icon>
        </el-upload>
        <div style="display: flex">
          <el-form-item label="是否火热" prop="delivery">
            <el-switch v-model="forms.isHot" />
          </el-form-item>
          <el-form-item label="是否顶置" prop="delivery">
            <el-switch v-model="forms.isTop" />
          </el-form-item>
          <el-form-item label="是否推荐" prop="delivery">
            <el-switch v-model="forms.isRecommend" />
          </el-form-item>
        </div>
        <el-form-item label="博文状态" prop="delivery">
          <el-switch v-model="forms.isPublish" class="mb-2"
            style="--el-switch-on-color: #13ce66; --el-switch-off-color: #ff4949" active-text="草稿" inactive-text="发布" />
        </el-form-item>

        <el-form-item label="是否转载" prop="delivery">
          <el-switch v-model="forms.reprint" />
        </el-form-item>
        <el-form-item label="博文摘要">
          <el-input v-model="forms.articleSummary" maxlength="30" placeholder="请输入博文摘要" show-word-limit type="textarea" />
        </el-form-item>
      </div>
      <el-button @click="" :disabled="submitLoading">取消</el-button>
      <el-button @click="saveOrUpdate" :disabled="submitLoading" type="primary">保存</el-button>
    </div>
  </div>
</template>

<style lang="scss">
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>
