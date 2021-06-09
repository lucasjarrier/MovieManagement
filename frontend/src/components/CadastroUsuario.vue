<template lang="pug">
div
  .container
    .container-cadastro
      h1 Cadastro de Usuário
      el-row
        el-col
          el-form.custom-form
            el-row
              h3 Nome do usuário
              el-input.custom-input(placeholder="Digite o nome", v-model="usuario.nome", clearable)
            el-row
              h3 Sobrenome do usuário
              el-input.custom-input(
                placeholder="Digite o sobrenome",
                v-model="usuario.sobrenome",
                clearable
              )
            el-row
              h3 Email do usuário
              el-input.custom-input(placeholder="Digite o email", v-model="usuario.email", clearable)
            el-row
              h3 Sexo
              el-select(v-model="usuario.sexo", placeholder="Selecione o sexo", clearable)
                el-option(value="MASCULINO", label="Masculino")
                el-option(value="FEMININO", label="Feminino")
                el-option(value="NAO_INFORMADO", label="Não especificado")
            el-row
              h3 Data de nascimento
              el-date-picker(
                v-model="usuario.dataNascimento",
                type="date",
                placeholder="Selecione a data",
                clearable
              )
            el-row.spacing
              el-button.custom-button(type="primary", @click="salvarUsuario")
                span Criar Usuário
                  i.el-icon-arrow-right
      .container-tabela
        h2 Tabela de Usuários
        el-row
          el-col
            el-table(:data="tableData")
              el-table-column(fixed prop="nome" label="Nome" width="120")
              el-table-column(fixed prop="sobrenome" label="Sobrenome" width="250")
              el-table-column(fixed prop="email" label="E-mail" width="250")
              el-table-column(fixed prop="sexo" label="Sexo" width="250")
              el-table-column(fixed prop="dataNascimento" label="Data de Nascimento" width="250")
              el-table-column(fixed label="Ações" width="150")
                el-button(@click="handleClick" type="text").custom-button2 Editar
                el-button(@click="handleClick" type="text").custom-button2 Excluir

</template>

<script>
import Usuario from "../services/usuarioService";

export default {
  name: "CadastroUsuario",
  data() {
    return {
      usuario: {
        nome: "",
        sobrenome: "",
        sexo: "",
        dataNascimento: "",
        email: "",
      },
      tableData: [{
          dataNascimento: '2016-05-03',
          nome: 'Lucas',
          sobrenome: 'Jarrier',
          sexo: 'Masculino',
          email: 'lucas@gmail.com'
        }, {
          dataNascimento: '2016-05-03',
          nome: 'Vitor',
          sobrenome: 'California',
          sexo: 'Masculino',
          email: 'vitor@gmail.com'
        }, {
          dataNascimento: '2016-05-03',
          nome: 'Julia',
          sobrenome: 'Gobbo',
          sexo: 'Feminino',
          email: 'ju@gmail.com'
        }, 
        {
          dataNascimento: '2016-05-03',
          nome: 'Ivan',
          sobrenome: 'Borba',
          sexo: 'Masculino',
          email: 'ivan@gmail.com'
        }, 
        {
          dataNascimento: '2016-05-03',
          nome: 'Caio',
          sobrenome: 'Papa',
          sexo: 'Masculino',
          email: 'papa@gmai.com'
          
        }]
    };
  },
  methods: {
    async salvarUsuario() {
      Usuario.salvarUsuario(this.usuario).then((resposta) => {
        alert("Usuario Salvo!");
        this.resposta = resposta;
      });
    },
  },
};
</script>

<style scoped>
@import url("//unpkg.com/element-ui@2.15.2/lib/theme-chalk/index.css");

h1 {
  padding-top: 20px;
  font-family: monospace;
}

h2{
  font-family: monospace;
  padding-top: 15px;
}

h3 {
  font-family: monospace;
  font-size: 15px;
}

i {
  margin-left: 10px;
}

.custom-button {
  border-color: black;
  background-color: blueviolet;
  color: black;
  font-family: monospace;
  font-size: 15px;
}

.custom-button2 {
  border-color: black;
  background-color: blueviolet;
  color: rgb(243, 236, 236);
  font-family: monospace;
}

.custom-button2:hover {
  background-color: rgb(157, 88, 221);
}

.custom-button:hover {
  background-color: rgb(157, 88, 221);
}

.container {
  border-width: 2px;
  border-radius: 20px;
  border-style: solid;
  border-color: rgb(202, 176, 226);
}

.container-tabela{
  padding-top: 50px;
  padding-bottom: 50px;
  
}

.custom-input {
  max-width: 50%;
}

.spacing {
  padding-top: 20px;
}
</style>
