<template lang="pug">
  div 
    h1 Cadastro de Filmes
    el-row
      el-cow
        el-form
          el-row
            h3 Nome do filme:
            el-input(placeholder="Digite o nome do filme" v-model="nomeFilme").custom-input()
          el-row
            h3 Gênero do filme:
            el-select(placeholder="Selecione o gênero do filme" v-model="generoFilme")
              el-option(value='terror' label="Terror")
              el-option(value='drama' label="Drama")
              el-option(value='fantasia' label="Fantasia")
          el-row
            h3 Data de lançamento:
            el-date-picker(placeholder="Selecione uma data" v-model="lancamento").custom-input()
          el-row
            h3 Nome do diretor:
            el-input(placeholder="Digite o nome do diretor" v-model="diretor").custom-input()    
</template>

<script>
export default {
    name: 'CadastroFilme',
    data() {
      return {
        nomeFilme: '',
        generoFilme: '',
        lancamento: '',
        diretor: ''
      }
    }
}
</script>

<style scoped>
.custom-input{
  max-width: 40%;
}

</style>