<script setup lang="ts">
import emoji from '@/assets/comment/emoji.ts'
import {reactive, ref} from 'vue'
import {
  CommentApi,
  ConfigApi,
  SubmitParamApi,
  UToast,
  createObjectURL,
  dayjs,
  throttle,
  CommentInstance, ReplyPageParamApi, usePage, UComment, UCommentScroll
} from 'undraw-ui'
import Operate from "@/components/comment/operate.vue";
import {reply,comment} from "@/assets/comment/comment.js"

const config = reactive<ConfigApi>({
  user: {
    id: 1,
    username: 'jack',
    avatar: 'https://static.juzicon.com/avatars/avatar-200602130320-HMR2.jpeg?x-oss-process=image/resize,w_100',
    // 评论id数组 建议:存储方式用户uid和评论id组成关系,根据用户uid来获取对应点赞评论id,然后加入到数组中返回
    likeIds: [1, 2, 3]
  },
  emoji: emoji,
  comments: [],
  total: 10
})

const commentRef = ref<CommentInstance>()

const _throttle = throttle((type: string, comment: CommentApi, finish: Function) => {
  switch (type) {
    case '删除':
      alert(`删除成功: ${comment.id}`)
      finish()
      break
    case '举报':
      alert(`举报成功: ${comment.id}`)
      break
  }
})

const operate = (type: string, comment: CommentApi, finish: Function) => {
  _throttle(type, comment, finish)
}

let temp_id = 100
// 提交评论事件
const submit = ({content, parentId, files, finish}: SubmitParamApi) => {
  console.log('提交评论: ' + content, parentId, files)

  /**
   * 上传文件后端返回图片访问地址，格式以'||'为分割; 如:  '/static/img/program.gif||/static/img/normal.webp'
   */
  let contentImg = files?.map(e => createObjectURL(e)).join('||')

  temp_id += 1
  const comment: CommentApi = {
    id: String(temp_id),
    parentId: parentId,
    uid: config.user.id,
    address: '来自江苏',
    content: content,
    likes: 0,
    createTime: dayjs().subtract(5, 'seconds').toString(),
    contentImg: contentImg,
    user: {
      username: config.user.username,
      avatar: config.user.avatar,
      level: 6,
      homeLink: `/${temp_id}`
    },
    reply: null
  }
  setTimeout(() => {
    finish(comment)
    UToast({message: '评论成功!', type: 'info'})
  }, 200)
}
// 点赞按钮事件 将评论id返回后端判断是否点赞，然后在处理点赞状态
const like = (id: string, finish: () => void) => {
  console.log('点赞: ' + id)
  setTimeout(() => {
    finish()
  }, 200)
}
//回复分页
const replyPage = ({parentId, pageNum, pageSize, finish}: ReplyPageParamApi) => {
  let tmp = {
    total: reply.total,
    list: usePage(pageNum, pageSize, reply.list)
  }
  setTimeout(() => {
    finish(tmp)
  }, 200)
}
// 是否禁用滚动加载评论
const disable = ref(false)
// 加载更多评论
const more = () => {
  console.log(disable.value)
  if (pageNum <= Math.ceil(total / pageSize)) {
    setTimeout(() => {
      config.comments.push(...comment(pageNum, 1))
      pageNum++
    }, 200)
  } else {
    disable.value = true
  }
}
// 当前页数
let pageNum = 2
// 页大小
let pageSize = 1
// 评论总数量
let total = reply.total
config.comments = comment
</script>
<template>
  <u-comment-scroll :disable="disable" @more="more">
    <u-comment :config="config" page @submit="submit" @like="like" @operate="operate" @reply-page="replyPage"
               ref="commentRef" relative-time>
      <!-- <template>用户信息导航栏卡槽</template> -->
      <!-- <template #info>用户信息卡槽</template> -->
      <!-- <template #card>用户信息卡片卡槽</template> -->
      <template #operate="scope">
        <Operate :comment="scope"/>
      </template>
    </u-comment>
  </u-comment-scroll>
</template>
<style lang="scss" scoped>

</style>
