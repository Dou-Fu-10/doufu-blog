<script setup>
const test = [
  {
    prop: "date",
    label: "Date"
  },
  {
    prop: "name",
    label: "Name"
  },
  {
    prop: "address",
    label: "Address"
  }
]
const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
</script>

<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column v-for="t in test" :label="t.label" :prop="t.prop" width="180"/>
  </el-table>
</template>

<style lang="scss" scoped>

</style>
