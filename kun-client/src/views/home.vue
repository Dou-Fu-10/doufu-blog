<!-- 主页 -->
<script lang="ts" setup>
import {onMounted, ref} from "vue";
import Post from "@/components/post.vue"
import Aside from "@/components/aside/index.vue";
import homeBanner from "@/components/banner/homeBanner.vue";
import {select} from "@/api/article"
import {Article} from "@/types/article";

const postList = ref<Array<Article>>([])

onMounted(async () => {
  const response = await select();
  postList.value = response.rows
})
</script>

<template>
  <homeBanner></homeBanner>
  <div class="home">
    <el-container>
      <!-- 侧边栏 -->
      <el-aside width="300px">
        <Aside/>
      </el-aside>
      <!-- 内容区域 -->
      <el-main>
        <template v-for="post in postList" :key="post.articleId">
          <post class="post" :post="post"></post>
        </template>
      </el-main>
    </el-container>
  </div>
</template>

<style lang="scss" scoped>
.home {
  width: 80%;
  margin: 0 auto;

  .post {
    margin: 0 10px 30px;
  }
}
</style>
