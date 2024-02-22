<!-- 文章 -->
<script lang="ts" setup>
const tags = "http://192.168.100.100:9000/images/2023-11/%E6%9D%A8%E8%B6%85%E8%B6%8A4K%E7%94%B5%E8%84%91%E6%A1%8C%E9%9D%A2_%E5%BD%BC%E5%B2%B8%E5%9B%BE%E7%BD%91.jpg"

</script>

<template>
  <div class="article">
    <el-card class="custom-card">
      <div>
        <el-image style="width: 150px; height: 100px;border-radius: 10px" :src="tags" fit="cover"/>
      </div>
      <div>
        <div style="display:block;"> Node 回眸</div>
        <div>
          <div>
            学习笔记
          </div>
          <div>
            前端•NodeJS
          </div>
        </div>
      </div>
      <div>
        <div style="display:block;">
          <ul class="article-meta">
            <li class="createTime icon">
              <!--热度图标-->
              <span><el-icon><Female/></el-icon>{{ 1 }}</span>
            </li>
            <!-- 热度 -->
            <li class="views icon">
              <!--热度图标-->
              <span><el-icon><Female/></el-icon>{{ 1 }}</span>
            </li>
            <!-- 评论 -->
            <li class="comments icon">
              <!--评论图标-->
              <span><el-icon><Female/></el-icon>{{ 1 }}</span>
            </li>
            <!-- 点赞 -->
            <li class="like icon">
              <!--点赞图标-->
              <span><el-icon><Female/></el-icon>{{ 0 }}</span>
            </li>
          </ul>
        </div>
        <div>
          2024-01-16
        </div>
      </div>
    </el-card>
  </div>
</template>

<style lang="scss" scoped>
.article{
  display: inline-block;
  max-width: 600px;
}
.custom-card {
  padding: 0;

  div {
    display: inline-block;
  }
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
</style>
