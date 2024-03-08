<!--推荐文章-->
<script setup lang="ts">

import Articles from "@/components/aside/article-list.vue";
</script>

<template>
  <el-card class="recommended">
    <h3>
      推荐文章
    </h3>
    <Articles />
    <Articles />
    <Articles />
  </el-card>
</template>

<style scoped lang="scss">
.recommended:hover {
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  /* 移入时显示阴影 */
}

// 卡片圆角
.el-card {
  border: none;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
  border-radius: 15px;
}
</style>
