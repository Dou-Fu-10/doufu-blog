<script setup lang="ts">
import {onMounted, ref} from "vue"
import * as echarts from 'echarts';

const tags = "http://192.168.100.100:9000/images/2023-11/%E6%9D%A8%E8%B6%85%E8%B6%8A4K%E7%94%B5%E8%84%91%E6%A1%8C%E9%9D%A2_%E5%BD%BC%E5%B2%B8%E5%9B%BE%E7%BD%91.jpg"
const main = ref() // 使用ref创建虚拟DOM引用，使用时用main.value
type EChartsOption = echarts.EChartsOption;

const option:EChartsOption = {
  xAxis: {
    type: 'category',
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [120, 200, 150, 80, 70, 110, 130],
      type: 'bar'
    }
  ]
};


onMounted(() => {
  init()
});

function init() {
  // 基于准备好的dom，初始化echarts实例
  const myChart = echarts.init(main.value);
  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
}
</script>

<template>
  <!--文章分类---》https://www.qcqx.cn/tags/  -->
  <div>
    <div class="category-banner">
      <div :style="{ 'background-image': `url(${tags})` }" class="banner-img">
      </div>
    </div>
    <div class="category">
      <el-card>
        标签
        <div ref="main" style="width: 100%; height: 400px"></div>
      </el-card>
    </div>
  </div>
</template>

<style scoped lang="scss">
.category {
  width: 50%;
  margin: 70px auto 0;
}

.category-banner {
  width: 100%;
  height: 40vh;
  position: relative;

  .banner-img {
    width: inherit;
    height: inherit;
    background-size: cover;
  }
}
</style>
