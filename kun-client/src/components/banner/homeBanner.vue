<script lang="ts" setup>
import type {WebsiteInfo} from "@/types/home";
import {ref} from "vue";

const websiteInfo: WebsiteInfo = {
  avatar: 'http://192.168.100.100:9000/images/2023-11/ikun.jpg',
  // https://www.iamwawa.cn/home/dujitang/ajax  毒鸡汤文案
  intro: '这么多年没掉入桃色陷阱，靠的就是两个字，没钱。',
  websiteName: 'MG′blog',
  // notice: '及时当勉励，岁月不待人。',
  // desc: '一个It技术的探索者',
  wallpaper: 'http://192.168.100.100:9000/images/2023-11/%E6%91%84%E5%BD%B1%E9%A3%8E%E6%99%AF.jpg',
  isNewYear: false
};
const isHome = ref(true);
</script>

<template>
  <div class="home-banner">
    <div :style="{ 'background-image': `url(${websiteInfo.wallpaper})` }" class="banner-img">
      <template v-if="isHome">
        <!--博主信息-->
        <div class="blogger-info">
          <!-- 头像 -->
          <div class="avatar">
            <router-link to="/">
              <el-avatar :size="80" :src="websiteInfo.avatar" class="avatar-border" shape="circle"/>
            </router-link>
          </div>
          <!-- 简介 -->
          <div class="intro">
            <p>{{ websiteInfo.intro }}</p>
          </div>
        </div>
        <!--左右倾斜-->
        <div class="slant-left"></div>
      </template>
    </div>
    <svg class="waves" preserveAspectRatio="none" shape-rendering="auto"
         viewBox="0 24 150 28"
         xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
      <defs>
        <path id="gentle-wave" d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z"/>
      </defs>
      <g class="parallax">
        <use fill="rgba(255,255,255,0.7" x="48" xlink:href="#gentle-wave" y="0"/>
        <use fill="rgba(255,255,255,0.5)" x="48" xlink:href="#gentle-wave" y="3"/>
        <use fill="rgba(255,255,255,0.3)" x="48" xlink:href="#gentle-wave" y="5"/>
        <use fill="#fff" x="48" xlink:href="#gentle-wave" y="7"/>
      </g>
    </svg>
  </div>
</template>


<style lang="scss" scoped>
@import url(//fonts.googleapis.com/css?family=Lato:300:400);

.home-banner {
  width: 100%;
  height: 100vh;

  .banner-img {

    width: inherit;
    height: inherit;
    background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
    overflow: hidden;
    background-attachment: fixed;
    z-index: -1;
    transition: unset;

    .blogger-info {
      .avatar {
        .avatar-border {
          border: 2px solid #e0cccc;
        }

        position: absolute;
        left: 50%;
        top: 30%;
        transform: translate(-50%, -50%);
      }

      .intro {
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        width: 50%;
        background: rgba(0, 0, 0, 0.56);
        line-height: 30px;
        border-radius: 10px;
        padding: 0 10px;

        p {
          white-space: nowrap;
          overflow: hidden;
          text-overflow: ellipsis;
          text-align: center;
          color: #EAEADF;
        }
      }
    }
  }

  .waves {
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 10vh;
    min-height: 10px;
    max-height: 150px;
  }

  .parallax > use {
    animation: move-forever 25s cubic-bezier(.55, .5, .45, .5) infinite;
  }

  .parallax > use:nth-child(1) {
    animation-delay: -2s;
    animation-duration: 7s;
  }

  .parallax > use:nth-child(2) {
    animation-delay: -3s;
    animation-duration: 10s;
  }

  .parallax > use:nth-child(3) {
    animation-delay: -4s;
    animation-duration: 13s;
  }

  .parallax > use:nth-child(4) {
    animation-delay: -5s;
    animation-duration: 20s;
  }

  @keyframes move-forever {
    0% {
      transform: translate3d(-90px, 0, 0);
    }

    100% {
      transform: translate3d(85px, 0, 0);
    }
  }
}
</style>
