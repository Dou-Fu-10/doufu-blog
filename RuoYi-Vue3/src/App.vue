<template>
  <router-view/>
</template>

<script setup>
import useSettingsStore from '@/store/modules/settings'
import {handleThemeStyle} from '@/utils/theme'

onMounted(() => {
  nextTick(() => {
    // 初始化主题样式
    handleThemeStyle(useSettingsStore().theme)
  })
})
</script>
<style>
.kun-search {
  display: flex;
  margin-bottom: 10px;

  .input {
    width: 20%;
    margin-right: 20px;
    min-width: 200px;
  }

  .m-4 {
    margin-right: 20px;
  }

}
</style>
