<!--搜索-->
<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { Edit } from '@element-plus/icons-vue'


const state = ref('')
const links = ref([])

const querySearch = (queryString: string, cb) => {
  const results = queryString
      ? links.value.filter(createFilter(queryString))
      : links.value
  // call callback function to return suggestion objects
  cb(results)
}
const createFilter = (queryString) => {
  return (restaurant) => {
    return (
        restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0
    )
  }
}
const loadAll = () => {
  return [
    { value: 'vue' },
    { value: 'element'},
    { value: 'cooking'},
    { value: 'mint-ui' },
    { value: 'vuex' },
    { value: 'vue-router'},
    { value: 'babel' },
  ]
}
const handleSelect = (item) => {
  console.log(item)
}

const handleIconClick = (ev: Event) => {
  console.log(ev)
}

onMounted(() => {
  links.value = loadAll()
})
</script>

<template>
    <el-card class="search">
      <h3>搜索</h3>
      <el-autocomplete
          v-model="state"
          :fetch-suggestions="querySearch"
          popper-class="my-autocomplete"
          placeholder="搜索文章"
          @select="handleSelect"
      >
        <template #suffix>
          <el-icon class="el-input__icon" @click="handleIconClick">
            <el-icon><Search /></el-icon>
          </el-icon>
        </template>
        <template #default="{ item }">
          <div class="value">{{ item.value }}</div>
        </template>
      </el-autocomplete>
    </el-card>
</template>

<style scoped lang="scss">

</style>
