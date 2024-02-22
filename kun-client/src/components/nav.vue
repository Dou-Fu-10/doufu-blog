<!--  -->
<script lang="ts" setup>
import {RouterLink} from 'vue-router';


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
    <div class="nav-logo">
      <RouterLink to="/">I-KUN</RouterLink>
    </div>
    <div class="nav-menus">
      <ul class="navlist">
        <li>
          <RouterLink to="/">首页</RouterLink>
        </li>
        <li>
          <RouterLink to="/">文章</RouterLink>
        </li>
        <li>
          <RouterLink to="/">分类</RouterLink>
        </li>
        <li>
          <RouterLink to="/">关于/留言</RouterLink>
        </li>
      </ul>
    </div>
  </div>
</template>

<style lang="scss" scoped>
$nav-height: 50px;
$nav-background: #262626;
$logo-color: #fff;
$link-hover-color: #aaa;
$underline: #f40;

a {
  text-decoration: none;
}

.nav {
  height: $nav-height;
  position: fixed;
  width: 100%;
  transition: all 0.3s ease-out;

  &:hover {
    background: $nav-background;
  }

  .nav-logo {
    padding-left: 20px;
    float: left;
    line-height: $nav-height;
    text-transform: uppercase;
    font-size: 1.4em;

    a,
    a:visited {
      color: $logo-color;
      text-decoration: none;
      font-weight: bold;
    }
  }

  .nav-menus {
    float: right;

    ul {
      padding: 0;
      margin: 0;
      list-style: none;

      li {

        float: left;
        text-transform: uppercase;
        position: relative;
        margin: 0 10px;

        a {
          line-height: $nav-height;
          transition: all 0.3s ease;
          padding: 0 9px 0 3px;
          color: $logo-color;

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
}
</style>
