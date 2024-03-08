<script setup lang="ts">

import site from "@/components/aside/site.vue"
import recommended from "@/components/aside/recommended.vue"
import search from "@/components/aside/search.vue"
</script>

<template>
  <div class="aside">
    <!--网站信息-->
    <site />
    <!--搜索-->
    <search />
    <!--推荐文章-->
    <recommended />
  </div>

</template>

<style scoped lang="scss">
.aside {
  margin: 15px;

  div {
    margin-bottom: 30px;
    transition: box-shadow 0.5s ease;
    /* 添加过渡效果 */
  }

}
</style>
