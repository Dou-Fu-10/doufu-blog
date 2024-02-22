<!-- 文章展示 -->
<script lang="ts" setup>
import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";
import {selectOne} from "@/api/article.ts";
import {Article} from "@/types/article";
import {UAnchor} from "undraw-ui";
import Comment from "@/components/comment/comment.vue";
import Prism from "prismjs" //代码高亮core
import "prismjs/themes/prism-tomorrow.min.css" //高亮主题
import "prismjs/plugins/line-numbers/prism-line-numbers.min.js" //行号插件
import "prismjs/plugins/line-numbers/prism-line-numbers.min.css" //行号插件的样式
import "prismjs/plugins/toolbar/prism-toolbar.min.css" //复制代码
import "prismjs/plugins/toolbar/prism-toolbar.min.js" //复制代码
import "prismjs/plugins/copy-to-clipboard/prism-copy-to-clipboard.min.js"
// 获取路由
const route = useRoute()
// 文章id
const articleId = route.params.articleId as string;
// 文章
const article = ref<Article>({
  articleId: "1",
  categoryId: "1",
  articleTitle: "测试",
  articleSummary: "测试",
  articleContent: "测试",
  articleCover: "测试",
  viewsCount: 0,
  commentsCount: 0,
  isPublish: false,
  isTop: false,
  isHot: false,
  isRecommend: false,
  reprint: "测试",
  editType: "测试",
  createTime: new Date(),
  updateTime: new Date(),
  tags: [],
});
onMounted(async () => {
  // 获取文章信息
  const res = await selectOne(articleId);
  article.value = res.data
  setTimeout(() => {
    // 延迟加载高亮
    Prism.highlightAll()// 全局代码高亮
  }, 100)
})


</script>

<template>
  <!--文章横幅-->
  <div class="article-banner">
    <div :style="{ 'background-image': `url(${article.articleCover})` }" class="banner-img">
      <div class="article-info">
        <h1 class="article-title">{{ article.articleTitle }}</h1>
        <ul class="article-meta">
          <li class="createTime icon">
            <!--热度图标-->
            <span><el-icon><Female/></el-icon>{{ article.createTime }}</span>
          </li>
          <!-- 热度 -->
          <li class="views icon">
            <!--热度图标-->
            <span><el-icon><Female/></el-icon>{{ article.viewsCount }}</span>
          </li>
          <!-- 评论 -->
          <li class="comments icon">
            <!--评论图标-->
            <span><el-icon><Female/></el-icon>{{ article.commentsCount }}</span>
          </li>
          <!-- 点赞 -->
          <li class="like icon">
            <!--点赞图标-->
            <span><el-icon><Female/></el-icon>{{ 0 }}</span>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <!--文章-->
  <div class="article">
    <!--<div class="article-summary">{{ article.articleSummary }}</div>-->
    <div id="article" class="editor-content-view line-numbers" v-html="article.articleContent">
    </div>
    <div class="article-updateTime">
      文章最后更新于&nbsp;{{ article.updateTime }}
    </div>
    <div class="related">
      <div class="new">
        上一篇文章
      </div>
      <div class="old">
        下一篇文章
      </div>
    </div>
    <Comment></Comment>
  </div>

  <!-- container参数指定监听的容器，目录 -->
  <div class="article-catalog">
    <u-anchor container="#article"></u-anchor>
  </div>
</template>

<style lang="scss">

.article-summary {
  white-space: pre-line; /* 允许换行 */
}

.article-summary::after {
  content: "";
  display: inline-block;
  width: 100%;
  height: 0;
}

.article {
  width: 50%;
  margin: 70px auto 0;
}

.article-banner {
  width: 100%;
  height: 40vh;
  position: relative;

  .banner-img {
    width: inherit;
    height: inherit;
    background-size: cover;

    .article-info {
      position: absolute;
      bottom: 5%;
      color: white;
      left: 15%;
      //文章元素
      .article-meta {
        list-style: none;
        display: flex;
        flex-wrap: wrap;
        padding: 0;
        margin: 0;
        // 评论
        .comments {
        }

        // 点赞
        .like {
        }

        // 热度
        .views {
        }

      }

      .article-meta li:not(:last-child)::after {
        content: "";
        width: 2px;
        height: 2px;
        display: inline-block;
        border-radius: 50%;
        background-color: #ffffff;
        margin: 0 10px;
        position: relative;
        bottom: 25%;
      }
    }
  }
}

.article-catalog {
  position: fixed;
  top: 50%;
  right: 5%;
  background: rgb(247, 249, 254);
  padding: 15px;
  border-radius: 5%;

  .d2 {
    font-size: 16px !important;
  }
}


.editor-content-view p,
.editor-content-view li {
  white-space: pre-wrap; /* 保留空格 */
}

.editor-content-view img {
  max-width: 100%;
}

.editor-content-view video {
  max-width: 100%;
}

.editor-content-view blockquote {
  border-left: 8px solid #d0e5f2;
  padding: 10px 10px;
  margin: 10px 0;
  background-color: #f1f1f1;
}

.editor-content-view pre > code {
  display: block;
  padding: 10px;
}

.editor-content-view table {
  border-collapse: collapse;
}

.editor-content-view td,
.editor-content-view th {
  border: 1px solid #ccc;
  min-width: 50px;
  height: 20px;
}

.editor-content-view th {
  background-color: #f1f1f1;
}

.editor-content-view ul,
.editor-content-view ol {
  padding-left: 20px;
}

.editor-content-view input[type="checkbox"] {
  margin-right: 5px;
}
</style>
