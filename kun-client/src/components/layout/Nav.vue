<!--  -->
<script lang="ts" setup>
import {RouterLink} from 'vue-router';
import {ArrowDown, Plus,} from '@element-plus/icons-vue'

let prevScrollPos: number = 0;


window.addEventListener('scroll', debounce(handleScroll, 200));

function handleScroll() {
  const currentScrollPos = window.pageYOffset || document.documentElement.scrollTop;

  if (currentScrollPos > prevScrollPos) {
    console.log('下滑');
  } else {
    console.log('上滑');
  }

  prevScrollPos = currentScrollPos;
}

function debounce(func: Function, delay: number) {
  let timeoutId: any;
  return function () {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => {
      func.apply(arguments);
    }, delay);
  };
}


</script>

<template>
  <div class="nav">
    <div class="nav-logo new-left">
      <RouterLink to="/">i-kun</RouterLink>
    </div>
    <div class="nav-menus new-right">
      <ul class="nav-list">
        <!--首页-->
        <li>
          <RouterLink to="/">首页</RouterLink>
        </li>
        <!--博文-->
        <li>
          <el-dropdown popper-class="custom-dropdown">
            <span class="el-dropdown-link">博文<el-icon class="el-icon--right"><arrow-down/></el-icon></span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item :icon="Plus">
                  <RouterLink to="/archives">归档</RouterLink>
                </el-dropdown-item>
                <el-dropdown-item :icon="Plus">
                  <RouterLink to="/category">分类</RouterLink>
                </el-dropdown-item>
                <el-dropdown-item :icon="Plus">
                  <RouterLink to="/tags">标签</RouterLink>
                </el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </li>
        <!--留言板-->
        <li>
          <RouterLink to="/messageBoard">留言板</RouterLink>
        </li>
        <!--关于我-->
        <li>
          <RouterLink to="/about">关于我</RouterLink>
        </li>
      </ul>
    </div>
  </div>
</template>

<style lang="scss" scoped>
$nav-background: rgba(0, 0, 0, 0.36);
$link-hover-color: #aaa;
$underline: #f40;

.nav {
  // 全局 头部高度 默认 70px
  height: $header-height;
  // 全屏
  width: $header-width;
  // 动画效果
  transition: all 0.5s ease-out;
  display: flex;

  &:hover {
    // 移入 背景颜色
    background: $nav-background;
  }

  // 导航logo
  .nav-logo {
    // 全大写
    text-transform: uppercase;
    line-height: $header-height;

    a {
      // 字号
      font-size: $nav-font-size;
      // 字体颜色
      color: $font-color;
      // 粗体
      font-weight: bold;
    }
  }

  .nav-menus {
    ul {
      // 移除默认的内边距、外边距，并去除列表项的默认样式
      padding: 0;
      margin: 0;
      list-style: none;

      li {
        // 让它们向左浮动 排列成一排
        float: left;
        // 保证移入下划线位置
        position: relative;
        margin: 0 10px;


        a, div {
          // 设置行高让他上下居中 并且把移入下划线 放置到底部
          line-height: $header-height;
          // 字号
          font-size: $nav-menus-font-size;
          // 下拉菜单
          span {
            // 取消 下拉菜单点击框
            outline: none;
          }

          // 移入动画
          transition: all 0.3s ease;
          padding: 0 9px 0 3px;
          // 字体颜色
          color: $font-color;

          // 移入效果
          &:before,
          &:after {
            content: '';
            position: absolute;
            width: 0%;
            height: 4px;
            bottom: -2px;
            margin-top: -0.5px;
            background: $underline;
          }

          &:before {
            left: -2.5px;
          }

          &:after {
            right: 2.5px;
            background: $underline;
            transition: width 0.8s cubic-bezier(0.22, 0.61, 0.36, 1);
          }

          &:hover {
            color: $underline;

            &:before {
              background: $underline;
              width: 100%;
              transition: width 0.5s cubic-bezier(0.22, 0.61, 0.36, 1);
            }

            &:after {
              background: transparent;
              width: 100%;
              transition: 0s;
            }
          }
        }
      }
    }
  }

  // 菜单在左边
  .new-left {
    padding-left: 30px;
    margin-right: auto;
  }

  // 菜单在右边
  .new-right {
    padding-right: 40px;
    margin-left: auto;
  }
}

// 下拉框样式修改
.custom-dropdown {
  .el-dropdown-menu__item {

    a {
      font-size: 16px;
      line-height: 26px;
      color: black;
    }
  }
}
</style>
