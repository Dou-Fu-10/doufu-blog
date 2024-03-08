<script lang="ts" setup>
import { Article } from "@/types/article";
import postMeta from "@/components/post-meta.vue";

const props = defineProps<{
  post: Article
}>()
const date = new Date(props.post.createTime);

const year = date.getFullYear();
const month = date.getMonth() + 1;
const day = date.getDate();
const hours = date.getHours();
const minutes = date.getMinutes();
const seconds = date.getSeconds();

const formattedDate = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
</script>

<template>
  <!--文章-->
  <div class="post">
    <el-card :body-style="{ padding: '0px' }">
      <!--文章封面-->
      <div class="cover">
        <router-link :to="`/article/${props.post.articleId}`">
          <el-image class="image" :src="props.post.articleCover" fit="cover" />
        </router-link>
      </div>
      <!--文章信息-->
      <div class="post-info">
        <!--文章标题及头部信息-->
        <div class="info-head">
          <!--文章创建时间-->
          <div class="create-time">
            <el-icon size="14">
              <Calendar />
            </el-icon> 发布于 {{ formattedDate }}
          </div>
          <!--文章标题-->
          <div class="title">
            <router-link class="article-title" :to="`/article/${props.post.articleId}`">
              {{ props.post.articleTitle }}
            </router-link>
          </div>

        </div>
        <!--文章元素-->
        <div class="post-meta">
          <post-meta :create-time="post.createTime" :comments-count="post.commentsCount"
            :views-count="post.viewsCount"></post-meta>
          <!--文章摘要-->
          <p class="summary">{{ props.post.articleSummary }}</p>
          <!--页脚-->
          <div class="post-more">
            <!--标签-->
            <div class="tags-box">
              <el-tag v-for="item in props.post?.tags" :key="item.tagId" class="tag-item">
                {{ item.tagName }}
              </el-tag>
            </div>
          </div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<style lang="scss" scoped>
// 文章样式
.post {

  // 最大宽度
  max-width: 415px;
  // 最小宽度
  min-width: 270px;
  // 响应式宽度
  width: calc(33.33% - 20px);
  /* 初始每行显示3个div */
  margin: 0 5px 20px;
  // 过渡动画
  transition: width 0.5s;

  /* 添加过渡动画 */
  // 文章封面
  .cover {
    overflow: hidden;

    .image {
      vertical-align: top;
      transition: all .6s;
      width: 100%;
      height: 200px;
    }

    // 移入图片变大
    :hover .image {
      transform: scale(1.3)
    }
  }

  // 文章信息
  .post-info {
    padding: 15px;

    // 文章标题及头部信息
    .info-head {

      // 文章创建时间
      .create-time {
        color: rgb(127, 127, 127);
        // font-size: 13px;
      }

      // 文章标题
      .title {
        font-size: 21px;
        font-weight: 600;
        display: inline-block;

        .article-title {
          display: -webkit-box;
          overflow: hidden;
          text-overflow: ellipsis;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 1;
          /* 根据需要设定行数 */
          color: black;
          line-height: 36px;

        }
      }
    }
  }

  // 文章元素
  .post-meta {

    // 文章摘要
    .summary {
      display: inline-block;
      display: -webkit-box;
      overflow: hidden;
      text-overflow: ellipsis;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      height: 2.5em;
      /* 根据需要设定行数 */
    }
  }


  // 页脚
  .post-more {

    // 标签
    .tags-box {
      display: -webkit-box;
      overflow: hidden;
      text-overflow: ellipsis;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 1;
      /* 根据需要设定行数 */
      color: #409eff;

      .tag-item {
        margin: 0 2px;

      }
    }
  }
}

.el-card:hover {
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
  /* 移入时显示阴影 */
}

// 卡片圆角
.el-card {
  border:none;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
  border-radius: 15px;
}

// 根据不同的宽度决定div的宽度
@media screen and (max-width: 1403px) {
  .post {
    width: calc(50% - 20px);
    /* 当宽度达到最小宽度无法被调整时，显示两行 */
  }
}
</style>
