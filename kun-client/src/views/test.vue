<script lang="ts" setup>
import Post from "@/components/post.vue";
import {onMounted, ref} from "vue";
import {select} from "@/api/article"
import {Article} from "@/types/article";

// const postList = ref<Array<Article>>([])
const postList = ref<Article>()
onMounted(async () => {
  const response = await select();
  postList.value = response.rows[0]
})
</script>
<template>
  <el-main>
    <div v-if="postList">
      <post class="post" :post="postList"></post>
    </div>

    <!--<template v-for="post in postList" :key="post.articleId">-->
    <!--  <post class="post" :post="post"></post>-->
    <!--</template>-->
  </el-main>
</template>

<style>
.post{
  margin-top: 150px;
}
</style>
