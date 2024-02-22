<!--  -->
<script lang="ts" setup>
import {mavonEditor} from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import {ref} from 'vue';

const content = ref("### 三级标题 ###")
const navigation = true
function test(){
  console.log("!111")
}

</script>

<template>
  <div>
    <mavonEditor v-model="content" :boxShadow="false" :editable="true" :navigation="navigation" :subfield="false"
                 :toolbarsFlag="false" class="mavon-editor" defaultOpen="preview" placeholder="文本为空"
                 previewBackground="#00000000" :navigationToggle="test">
    </mavonEditor>
  </div>
</template>

<style lang="scss" scoped></style>
