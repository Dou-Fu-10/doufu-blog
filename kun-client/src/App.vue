<script lang="ts" setup>
import Footer from "@/components/layout/footer.vue"
import Nav from "@/components/layout/Nav.vue";
</script>

<template>
  <div class="common-layout">
    <el-container>
      <!--头-->
      <el-header>
        <Nav></Nav>
      </el-header>
      <!--内容-->
      <RouterView/>
      <!--尾-->
      <el-footer>
        <Footer></Footer>
      </el-footer>
    </el-container>
  </div>
</template>

<style lang="scss" scoped>
// 固定头部
.el-header {
  position: fixed;
  padding: 0;
  z-index: 100;
  // 全屏
  width: $header-width;
  // 全局 头部高度 默认 70px
  height: $header-height;
}
</style>
