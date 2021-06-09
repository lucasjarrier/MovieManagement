<template lang="pug">
  div
    .container
     h1 Cadastro de Usuário
     el-row
       el-col
        el-form.custom-form()
          el-row
            h3 Nome do usuário
            el-input(placeholder="Digite o nome" v-model="usuario.nome").custom-input()
          el-row
            h3 Sobrenome do usuário
            el-input(placeholder="Digite o sobrenome" v-model="usuario.sobrenome").custom-input()
          el-row
            h3 Email do usuário
            el-input(placeholder="Digite o email" v-model="usuario.email").custom-input()
          el-row
            h3 Sexo
            el-select(v-model="usuario.sexo" placeholder="Selecione o sexo")
              el-option(value='MASCULINO' label="Masculino")
              el-option(value='FEMININO' label="Feminino")
              el-option(value='NAO_INFORMADO' label="Não especificado")
          el-row
            h3 Data de nascimento
            el-date-picker(v-model="usuario.dataNascimento" type="date" placeholder="Selecione a data")
          el-row.spacing()
            el-button(type="primary" @click="salvarUsuario").custom-button
              span Criar Usuário
                i.el-icon-arrow-right

</template>

<script>

import Usuario from '../services/usuarioService'

export default {
  name: 'CadastroUsuario',
  data() {
    return {
      usuario: {
        nome: '',
        sobrenome: '',
        sexo: '',
        dataNascimento: '',
        email: ''
      }
    }
  },
  methods: {
    async salvarUsuario() {
     Usuario.salvarUsuario(this.usuario).then(resposta => {
       alert('Usuario Salvo!')
       this.resposta = resposta
     })
    }
  }
}
</script>

<style scoped>

@import url("//unpkg.com/element-ui@2.15.2/lib/theme-chalk/index.css");

h1 {
  font-family: monospace;
}

h3 {
  font-family: monospace;
  font-size: 15px;
}

i {
  margin-left: 10px;
}

.custom-button{
  border-color: black;
  background-color: blueviolet;
  color: black;
  font-family: monospace;
  font-size: 15px;
}

.custom-button:hover{
  background-color: rgb(157, 88, 221);
}

.container {
  border-width: 20px;
  border-color: black;
}

.custom-input{
  max-width: 40%;
}

.spacing{
  padding-top: 20px;
}

</style>