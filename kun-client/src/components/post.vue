<script lang="ts" setup>
import {Article} from "@/types/article";

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
  <article class="post">
    <el-card :body-style="{ padding: '0px' }">
      <!--文章封面-->
      <div class="cover">
        <router-link :to="`/article/${props.post.articleId}`">
          <el-image class="image" :src="props.post.articleCover" fit="cover"/>
        </router-link>
      </div>
      <!--文章信息-->
      <div class="post-info">
        <!--文章标题及头部信息-->
        <div class="info-head">
          <!--文章创建时间-->
          <div class="create-time">
            发布于 {{ formattedDate }}
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

          <ul class="info-meta">
            <!-- 评论 -->
            <li class="comments icon">
                            <span>
                                <!--评论图标-->
                                <el-icon>
                                    <Female/>
                                </el-icon>
                                {{ props.post.commentsCount }}条评论
                            </span>
            </li>
            <el-divider direction="vertical"/>
            <!-- 点赞 -->
            <li class="like icon">
                            <span>
                                <!--点赞图标-->
                                <el-icon>
                                    <Female/>
                                </el-icon>
                                {{ props.post.viewsCount }}点赞
                            </span>
            </li>
            <el-divider direction="vertical"/>
            <!-- 热度 -->
            <li class="views icon">
                            <span>
                                <!--热度图标-->
                                <el-icon>
                                    <Female/>
                                </el-icon>
                                {{ props.post.viewsCount }}热度
                            </span>
            </li>
          </ul>

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
  </article>
</template>

<style lang="scss" scoped>
a {
  text-decoration: none;
}

.post {
  max-width: 400px;
  min-width: 320px;
  // 文章封面
  .cover {
    .image {
      width: 100%;
      height: 170px;
    }
  }

  // 文章信息
  .post-info {
    padding: 15px;

    // 文章标题及头部信息
    .info-head {

      // 文章创建时间
      .create-time {
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
        }
      }
    }
  }

  // 文章元素
  .post-meta {
    .info-meta {
      list-style: none;
      display: flex;
      flex-wrap: wrap;
      padding: 0;
      margin: 0;
    }


    // 评论
    .comments {
    }

    // 点赞
    .like {
    }

    // 热度
    .views {
    }

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
}</style>
