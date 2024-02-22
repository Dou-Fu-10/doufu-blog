<!--网站信息-->
<script setup lang="ts">

const errorHandler = () => true
</script>

<template>
  <el-card class="site">
    <!--头像-->
    <div class="site-avatar">
      <el-avatar :size="100" fit="cover" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
                 @error="errorHandler">
        <img
            src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png"
            alt=""/>
      </el-avatar>
    </div>
    <!--作者名字-->
    <div class="site-author-name">
      <h2>I-KUN</h2>
    </div>
    <div class="site-state">
      <div class="site-state-item site-state-posts">
        <router-link to="/archives/">
          <div class="site-state-item-count">29</div>
          <div class="site-state-item-name">日志</div>
        </router-link>
      </div>

      <div class="site-state-item site-state-categories">
        <router-link to="/categories/">
          <div class="site-state-item-count">16</div>
          <div class="site-state-item-name">分类</div>
        </router-link>
      </div>

      <div class="site-state-item site-state-tags">
        <router-link to="/tags/">
          <div class="site-state-item-count">71</div>
          <div class="site-state-item-name">标签</div>
        </router-link>
      </div>

    </div>
  </el-card>
</template>

<style scoped lang="scss">
.site {
  /* 背景渐变色 - 原理2 */
  background: linear-gradient(-45deg, #CDD0D6, #ce5082, #23a6d5, #23d5ab);
  /* 背景尺寸 - 原理3 */
  background-size: 600% 600%;
  /* 循环动画 - 原理4 */
  animation: gradientBG 10s linear infinite;

  div {
    display: flex;
    justify-content: center; /* 水平居中 */
    align-items: center; /* 垂直居中 */
  }

  .site-author-name {
    h2 {
      font-family: "楷体";
    }
  }

  .site-state {
    .site-state-item {
      margin: 0 20px;

      a {
        text-decoration: none;
        color: black;
      }
    }
  }

  /* 动画，控制背景 background-position */
  @keyframes gradientBG {
    0% {
      background-position: 0% 50%;
    }
    50% {
      background-position: 100% 50%;
    }
    100% {
      background-position: 0% 50%;
    }
  }
}
</style>
