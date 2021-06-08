<template lang="pug">
  div
    h1 Cadastro de Usuário
    el-form
      el-input(placeholder="Digite o nome" v-model="input")
</template>

<script>
export default {
  name: 'CadastroUsuario',
  data() {
    return {
      input: ''
    }
  }
}
</script>

<style scoped>

</style>