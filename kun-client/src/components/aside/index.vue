<script setup lang="ts">

import site from "@/components/aside/site.vue"
import recommended from "@/components/aside/recommended.vue"
import search from "@/components/aside/search.vue"
</script>

<template>
  <div class="aside">
    <div>
      <!--网站信息-->
      <site/>
    </div>
    <div>
      <!--搜索-->
      <search/>
    </div>
    <div>
      <!--推荐文章-->
      <recommended/>
    </div>
  </div>

</template>

<style scoped lang="scss">
.aside {
  div {
    margin-bottom: 30px;
    transition: box-shadow 0.5s ease; /* 添加过渡效果 */
  }

  div:hover {
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* 移入时显示阴影 */
  }
}
</style>
