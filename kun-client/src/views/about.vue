<script setup lang="ts">
import Stats from "@/components/stats.vue";
import {ref} from "vue";

const expandedIndex = ref(1)
const shrinkIndex = ref(-1)

const errorHandler = () => false
const category = "http://192.168.100.100:9000/images/2023-11/%E6%9D%A8%E8%B6%85%E8%B6%8A4K%E7%94%B5%E8%84%91%E6%A1%8C%E9%9D%A2_%E5%BD%BC%E5%B2%B8%E5%9B%BE%E7%BD%91.jpg"

function toggleExpand(index: number) {
  if (expandedIndex.value !== index) {
    shrinkIndex.value = expandedIndex.value; // 关闭展开的图片
    expandedIndex.value = index; // 展开对应索引的图片
  }
}
</script>

<template>
  <!--关于---》https://www.qcqx.cn/about/ -->
  <div class="about">
    <div class="author-main">
      <div class="author-tag-left">
        <span class="author-tag">💻 Like数码科技</span>
        <span class="author-tag">🥣 干饭魂 干饭人</span>
        <span class="author-tag">🕊 咕咕咕咕咕咕~</span>
        <span class="author-tag">🧱 CV工程师</span>
      </div>
      <div class="author-box">
        <el-avatar :size="150" :src="category" @error="errorHandler">
          <img
              src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png"
          />
        </el-avatar>
      </div>
      <div class="author-tag-right">
        <span class="author-tag">吃饭不如碎觉 💤</span>
        <span class="author-tag">乐观 积极 向上 🤝</span>
        <span class="author-tag">专攻各种困难 🔨</span>
        <span class="author-tag">人不狠话超多 💢</span>
      </div>

    </div>
    <div>
      关于本站
    </div>
    <Stats>
    </Stats>
    <div style="display: flex;justify-content: center;align-items: center">
      <div v-for="index in 5" :key="index" class="img-test">
        <img :src="category" alt=""
             :class="{'swiper': expandedIndex === index, 'swiper-out': shrinkIndex === index}"
             @click="toggleExpand(index)"/>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.author-main {
  position: relative;
  display: flex;
  align-items: center;
  user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;

  .author-tag-left {
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    margin-right: 30px;
  }

  .author-tag-right {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-left: 30px;
  }
}

.img-test {
}

img {
  background-color: #666;
  height: 20rem;
  width: 3rem;
  margin: 1rem;
  border-radius: 20rem;

  object-fit: cover;
  // 展开
  --expand-width: 45rem;
  --expand-height: 21rem;
  --expand-radius: 2rem;
  // 缩小
  --shrink-width: 3rem;
  --shrink-height: 20rem;
  --shrink-radius: 20rem;
}

img.swiper-out {
  animation: swiper-out 1s forwards;
}

img.swiper {
  animation: swiper 1s forwards;
}

@keyframes swiper {
  from {
    border-radius: var(--shrink-width);
    width: var(--shrink-width);
    height: var(--shrink-height);
  }
  to {
    border-radius: var(--expand-radius);
    width: var(--expand-width);
    height: var(--expand-height);
  }
}

@keyframes swiper-out {
  from {
    border-radius: var(--expand-radius);
    width: var(--expand-width);
    height: var(--expand-height);
  }
  to {
    border-radius: var(--shrink-width);
    width: var(--shrink-width);
    height: var(--shrink-height);
  }
}

</style>
