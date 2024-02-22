<script setup lang="ts">
import {onMounted, ref} from "vue"
import * as echarts from 'echarts';

const category = "http://192.168.100.100:9000/images/2023-11/%E6%9D%A8%E8%B6%85%E8%B6%8A4K%E7%94%B5%E8%84%91%E6%A1%8C%E9%9D%A2_%E5%BD%BC%E5%B2%B8%E5%9B%BE%E7%BD%91.jpg"
const main = ref() // 使用ref创建虚拟DOM引用，使用时用main.value
type EChartsOption = echarts.EChartsOption;
const option: EChartsOption = {
  title: {
    text: '文章分类统计图',
    left: 'center',
    textStyle: {
      color: '#000000',
      fontWeight: 'normal',
      fontSize: 18
    }
  },
  legend: {
    //
    top: 'bottom'
  },
  series: [
    {
      name: 'Nightingale Chart',
      type: 'pie',
      // 大小
      radius: [20, 150],
      // 位置 居中
      center: ['50%', '50%'],
      // 南丁格尔玫瑰图
      roseType: 'area',
      itemStyle: {
        borderRadius: 8
      },
      // 数据
      data: [
        {value: 10, name: 'rose 11'},
        {value: 38, name: 'rose 2'},
        {value: 32, name: 'rose 3'},
        {value: 30, name: 'rose 4'},
        {value: 28, name: 'rose 5'},
        {value: 26, name: 'rose 6'},
        {value: 22, name: 'rose 7'},
        {value: 18, name: 'rose 8'}
      ].map((item) => ({
        ...item,
        label: {
          show: true,
          formatter: '{b}: {c} ({d}%)' // 显示name和value
        }
      }))
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
  <!--文章分类---》https://www.qcqx.cn/categories/  -->
  <div>
    <div class="category-banner">
      <div :style="{ 'background-image': `url(${category})` }" class="banner-img">
      </div>
    </div>
    <div class="category">
      <el-card>
        文章分类
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
