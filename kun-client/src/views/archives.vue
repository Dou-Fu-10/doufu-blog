<script setup lang="ts">
import {onMounted, ref} from "vue"
import {CalendarComponent, TitleComponent, TooltipComponent, VisualMapComponent} from 'echarts/components';
import * as echarts from 'echarts/core';
import {HeatmapChart} from 'echarts/charts';
import {CanvasRenderer} from 'echarts/renderers';
import Article from "@/components/article.vue";
const currentPage3 = ref(5)
const pageSize3 = ref(100)
const small = ref(false)
const background = ref(false)
const disabled = ref(false)

const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val: number) => {
  console.log(`current page: ${val}`)
}
const tags = "http://192.168.100.100:9000/images/2023-11/%E6%9D%A8%E8%B6%85%E8%B6%8A4K%E7%94%B5%E8%84%91%E6%A1%8C%E9%9D%A2_%E5%BD%BC%E5%B2%B8%E5%9B%BE%E7%BD%91.jpg"
const main = ref() // 使用ref创建虚拟DOM引用，使用时用main.value
type EChartsOption = echarts.EChartsOption;

echarts.use([
  TitleComponent,
  CalendarComponent,
  TooltipComponent,
  VisualMapComponent,
  HeatmapChart,
  CanvasRenderer
]);

function getVirtualData(year) {
  const date = +echarts.time.parse(year + '-01-01');
  const end = +echarts.time.parse(+year + 1 + '-01-01');
  const dayTime = 3600 * 24 * 1000;
  const data = [];
  for (let time = date; time < end; time += dayTime) {
    data.push([
      echarts.time.format(time, '{yyyy}-{MM}-{dd}', false),
      Math.floor(Math.random() * 10000)
    ]);
  }
  console.log(data)
  return data;
}

const option: EChartsOption = {
  title: {
    top: 30,
    left: 'center',
    text: 'Daily Step Count'
  },
  tooltip: {},
  visualMap: {
    min: 0,
    max: 10000,
    type: 'piecewise',
    orient: 'horizontal',
    left: 'center',
    top: 65,
    inRange: {
      color: ["#c6e48b","#7bc96f","#49af5d","#2e8840","#196127"] // 更改颜色范围
    }
  },
  calendar: {
    top: 120,
    left: 30,
    right: 30,
    cellSize: ['auto', 13],
    range: '2016',
    itemStyle: {
      borderWidth: 0,
      // borderRadius: 5  // 设置圆角半径，可以根据需要调整数值
    },
    splitLine: {
      show: false  // 取消分隔线显示
    },
    dayLabel: {
      firstDay: 1,
      nameMap: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
    },
    monthLabel: {
      show: true,
      nameMap: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
    },
    yearLabel: {show: false}
  },
  series: {
    type: 'heatmap',
    coordinateSystem: 'calendar',
    data: getVirtualData('2016')
  }
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
        <div>
          <h1>2024</h1>
          <Article v-for="i in 3"></Article>
          <h1>2023</h1>
          <Article v-for="i in 5"></Article>
          <div class="demo-pagination-block">
            <div class="demonstration">Jump to</div>
            <el-pagination
                v-model:current-page="currentPage3"
                v-model:page-size="pageSize3"
                :small="small"
                :disabled="disabled"
                :background="background"
                layout="prev, pager, next, jumper"
                :total="1000"
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
            />
          </div>
        </div>

      </el-card>
    </div>

  </div>
</template>

<style scoped lang="scss">
.category {
  width: 70%;
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
