<template lang="pug">
  div.custom-background
    h1 Cadastro de Usuário
    el-row
      el-col
        el-form
          el-row
            h3 Nome do usuário
            el-input(placeholder="Digite o nome" v-model="nome").custom-input()
          el-row
            h3 Sobrenome do usuário
            el-input(placeholder="Digite o sobrenome" v-model="sobrenome").custom-input()
          el-row
            h3 Email do usuário
            el-input(placeholder="Digite o email" v-model="email").custom-input()
          el-row
            h3 Sexo
            el-select(v-model="value" placeholder="Selecione o sexo")
              el-option(value='masculino' label="Masculino")
              el-option(value='feminino' label="Feminino")
              el-option(value='naoEspecificado' label="Não especificado")
          el-row
            h3 Data de nascimento
            el-date-picker(v-model="nascimento" type="date" placeholder="Selecione a data")

</template>

<script>
export default {
  name: 'CadastroUsuario',
  data() {
    return {
      nome: '',
      sobrenome: '',
      sexo: '',
      nascimento: '',
      value: ''
    }
  }
}
</script>

<style scoped>
.custom-input{
  max-width: 40%;
}

</style>