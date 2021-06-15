<template lang="pug">
div
  .container
    .container-cadastro 
      h1 Cadastro de Filmes
      el-row
        el-col
          el-form
            el-row
              h3 Nome do filme
              el-input(placeholder="Digite o nome do filme" v-model="filme.nome").custom-input()
            el-row
              h3 Gênero do filme
              el-select(v-model="filme.genero" placeholder="Selecione o gênero do filme") 
                el-option(value="TERROR")
                el-option(value="DRAMA")
            el-row
              h3 Data de lançamento
              el-date-picker(placeholder="Selecione uma data" v-model="filme.lancamento").custom-input()
            el-row
              h3 Diretor do Filme
              el-select(placeholder="Selecione o Diretor" v-model="filme.diretor.id")
                el-option(v-for="diretor in diretores" :key="diretor.id" :value="diretor.id" :label="diretor.nome")
            el-row.spacing
              el-button.custom-button(type="primary", @click="salvarFilme")
                span Salvar Filme
                  i.el-icon-check
    .container-tabela
      h2 Tabela de Filmes
        el-row
          el-table(:data="filmes" empty-text='Não existem filmes cadastrados!')
            el-table-column(prop="id" label="Id" width="100")
            el-table-column(prop="nome" label="Filme" width="300")
            el-table-column(prop="genero" label="Gênero" width="100")
            el-table-column(prop="diretor.nome" label="Diretor" width="150")
            el-table-column(label="Ações" width="150")
              template(slot-scope="scope")
                el-button(@click="atualizarFilme(filmes[scope.$index])" type="text").custom-button2 Editar
                el-button(@click="removerFilme(filmes[scope.$index])" type="text").custom-button2 Excluir
</template>

<script>

import Filme from "../services/filmeService";
import Diretor from "../services/diretorService";


export default {
    name: 'CadastroFilme',
    data() {
      return {
        filme: {
          id: "",
          nome: "",
          genero: "",
          lancamento: "",
          diretor: {
            id: ""
          }
        },
        filmes: [],
        diretores: []
      };
    },
    methods: {
      async salvarFilme() {
        if (!this.filme.id) {
          Filme.salvarFilme(this.filme).then((resposta) => {
            alert("Filme cadastrado com sucesso!");
            this.respota = resposta;
            this.listarFilmes();
          });
        } else {
            Filme.atualizarFilme(this.filme).then((resposta) => {
              alert("Filme atualizado!");
              this.resposta = resposta;
              this.listarFilmes();
            });
        }
      },
      listarFilmes() {
      Filme.retornarFilmes().then((resposta => {
        this.filmes = resposta.data
      }))
    },
      atualizarFilme(filme) {
        this.filme = filme
      },
      removerFilme(filme) {
        Filme.deletarFilme(filme.id).then((resposta) => {
          this.resposta = resposta;
          this.listarFilmes();
        });
      },
      listarDiretores() {
        Diretor.retornarDiretores().then((resposta) => {
          this.diretores = resposta.data
        })
      }
    },
    mounted() {
      this.listarFilmes(),
      this.listarDiretores()
    }
}
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

.custom-button {
  border-color: black;
  background-color: blueviolet;
  color: black;
  font-family: monospace;
  font-size: 15px;
}

.custom-table {
  width: 100%;
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

.container-tabela {
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

</style>