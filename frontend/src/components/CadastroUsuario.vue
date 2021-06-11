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
                span Salvar Usuário
                  i.el-icon-check
      .container-tabela
        h2 Tabela de Usuários
        el-row
          el-table(:data="tableData" empty-text='Não existem usuários cadastrados!')
            el-table-column( prop="id" label="Id" width="80")
            el-table-column( prop="nome" label="Nome" width="120")
            el-table-column( prop="sobrenome" label="Sobrenome" width="250")
            el-table-column( prop="email" label="E-mail" width="200")
            el-table-column( prop="sexo" label="Sexo" width="150")
            el-table-column( prop="dataNascimento" label="Data de Nascimento" width="250")
            el-table-column( prop="filmes" label="Filmes" width="200")
            el-table-column( label="Ações" width="300")
              template(slot-scope="scope")
                el-button(@click="atualizarUsuario(tableData[scope.$index])" type="text").custom-button2 Editar
                el-button(@click="removerUsuario(tableData[scope.$index])" type="text").custom-button2 Excluir
                el-button(v-model='index = scope.$index' @click="dialogTableVisible = true" type="text").custom-button2 Adicionar Filme
  el-dialog(:visible.sync="dialogTableVisible" width="40%" close-on-press-escape)
    h3 Escolha um filme
    el-row
      el-col
        el-select(placeholder="Filmes", v-model="id_filme", clearable)
          el-option(v-for="filme in filmes" :key="filme.id" :value="filme.id" :label="filme.nome")
      el-col.offset
        el-button.custom-button2(@click="" type="text") Adicionar Filme
        

</template>

<script>
import Usuario from "../services/usuarioService";
import Filme from "../services/filmeService";

export default {
  name: "CadastroUsuario",
  data() {
    return {
      usuario: {
        id: "",
        nome: "",
        sobrenome: "",
        sexo: "",
        dataNascimento: "",
        email: ""
      },
      tableData: [],
      filmes: [],
      id_filme: "",
      dialogTableVisible: false
    };
  },
  methods: {
    async salvarUsuario() {
      if (!this.usuario.id) {
        Usuario.salvarUsuario(this.usuario).then((resposta) => {
          alert("Usuario cadastrado!");
          this.resposta = resposta;
          this.listarUsuarios();
        });
      } else {
        Usuario.atualizarUsuario(this.usuario).then((resposta) => {
          alert("Usuario atualizado!");
          this.resposta = resposta;
          this.listarUsuarios();
        });
      }
    },
    listarUsuarios() {
      Usuario.retornarUsuarios().then((resposta) => {
        this.tableData = resposta.data;
      });
    },
    atualizarUsuario(usuario) {
      this.usuario = usuario;
    },
    removerUsuario(usuario) {
      Usuario.deletarUsuario(usuario.id).then((resposta) => {
        this.resposta = resposta;
        this.listarUsuarios();
      })
    },
    listarFilmes() {
      Filme.retornarFilmes().then((resposta => {
        this.filmes = resposta.data
      }))
    },
    adicionarFilme() {

    }
  },
  mounted() {
    this.listarUsuarios(),
    this.listarFilmes()
  },
};
</script>

<style scoped>
@import url("//unpkg.com/element-ui@2.15.2/lib/theme-chalk/index.css");

h1 {
  padding-top: 20px;
  font-family: monospace;
}

h2 {
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

.custom-span{
  color: brown;
  font-size: small;
}

.offset {
  padding-top: 40px;
}

.custom-button {
  border-color: black;
  background-color: blueviolet;
  color: black;
  font-family: monospace;
  font-size: 15px;
}

.custom-button2 {
  padding: 5px;
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

.custom-spacing {
  padding-right: 50%;

}

.container-tabela {
  padding-top: 50px;
  padding-bottom: 50px;
}

.modal-input{
  padding-bottom: 20px;
}

.custom-input {
  max-width: 50%;
}

.spacing {
  padding-top: 20px;
}
</style>
