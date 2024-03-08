<script setup lang="ts">
import type { PostMeta } from "@/types/article";
// import type {PropType} from "vue";

const props = withDefaults(defineProps<PostMeta>(), {
  commentsCount: 0, viewsCount: 0, createTime: undefined
})
console.log(props)
</script>

<template>
  <div class="meta">
    <ul class="info-meta">
      <!-- 评论 -->
      <li class="comments icon">
        <span>
          <!--评论图标-->
          <el-icon size="14">
            <Comment />
          </el-icon>
          {{ commentsCount }}条评论
        </span>
      </li>
      <li>
        <el-divider direction="vertical" />
      </li>
      <!-- 点赞 -->
      <li class="like icon">
        <span>
          <!--点赞图标-->
          <el-icon size="14">
            <Star />
          </el-icon>
          {{ viewsCount }}点赞
        </span>
      </li>
      <li>
        <el-divider direction="vertical" />
      </li>
      <!-- 热度 -->
      <li class="views icon">
        <span>
          <!--热度图标-->
          <el-icon size="14">
            <View />
          </el-icon>
          {{ viewsCount }}热度
        </span>
      </li>
    </ul>
  </div>
</template>

<style scoped lang="scss">
.meta {
  display: -webkit-box;
  overflow: hidden;
  text-overflow: ellipsis;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
}

// .info-meta li {
//   white-space: nowrap;
// }
.info-meta {
  list-style: none;
  padding: 0;
  margin: 0;

  li {
    display: inline-block;
  }

  // 评论
  .comments {}

  // 点赞
  .like {}

  // 热度
  .views {}
}</style>
