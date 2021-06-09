<template lang="pug">
  div
    h1 Esse é o cadastro de diretor
    el-row
      el-cow
        el-form
          el-row
            h3 Nome do diretor:
            el-input(placeholder="Fulano..." v-model="nomeDiretor").custom-input()
          el-row
            h3 Sobrenome do diretor:
            el-input(placeholder="...da Silva" v-model="sobrenomeDiretor").custom-input()
</template>

<script>
export default {
    name: 'CadastroDiretor',
    data() {
      return {
        nomeDiretor: '',
        sobrenomeDiretor: ''
      }
    }
}
</script>

<style scoped>
.custom-input{
  max-width: 40%;
}

</style>