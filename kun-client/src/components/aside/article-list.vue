<!-- 文章列表 -->
<script lang="ts" setup>
const url =
    'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
</script>

<template>
  <div class="articles">
    <div style="display: flex;">
      <el-image :src="url" fit="cover" class="avatar"/>
      <span class="content">从这个角度来看， 左拉在不经意间这样说过，生活的道路一旦选定，就要勇敢地走到底，决不回头。</span>
    </div>
    <div class="create-date">发布时间{{ new Date().toLocaleString() }}</div>
  </div>
</template>

<style lang="scss" scoped>
.articles {
  margin: 15px 0 ;
  .avatar {
    width: 40%;
    min-width: 40%;
    margin-right: 10px;
    border-radius: 10px;
  }

  .content {
    display: -webkit-box; /* 将文本作为弹性盒子显示 */
    -webkit-line-clamp: 2; /* 设置最大显示行数 */
    -webkit-box-orient: vertical; /* 指定盒子内的子元素排列方式为垂直方向 */
    text-overflow: ellipsis; /* 显示省略号 */
    overflow: hidden; /* 继续隐藏溢出内容 */
    height: 40px; /* 设置容器高度 */
  }

  .create-date {
    //float: left;
  }
}

</style>
