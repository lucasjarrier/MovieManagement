<template lang="pug">
  div
  .container
    .container-cadastro
      h1 Cadastro de Diretor
      el-row
        el-col
          el-form.custom-form
            el-row
              h3 Nome do diretor:
              el-input.custom-input(placeholder="Fulano...", v-model="nomeDiretor", clearable)
            el-row
              h3 Sobrenome do diretor:
              el-input.custom-input(placeholder="...da Silva", v-model="sobrenomeDiretor", clearable)
            el-row.spacing
              el-button.custom-button(type="round", @click="salvarDiretor")
                span Salvar Diretor
                 i.el-icon-check
      .container-tabela
        h2 Tabela de Diretores
        el-row
          el-col
            el-table.custom-table(:data="tableData" empty-text='Não existem diretores cadastrados!')
              el-table-column(fidex prop="id" label="Id" width="100")
              el-table-column(fidex prop="nome" label="Nome" width="120")
              el-table-column(fidex prop="sobrenome" label="Sobrenome" width="100")
                template(slot-scope="scope")
                  el-button(@click="atualizarDiretor(tableData[scope.$index])" type="text").custom-button2 Editar
                  el-button(@click="removerDiretor(tableData[scope.$index])" type="text").custom-button2 Excluir
</template>

<script>
import Diretor from "../services/diretorService";

export default {
    name: 'CadastroDiretor',
    data() {
      return {
        diretor: {
          nomeDiretor: '',
          sobrenomeDiretor: ''
        },
        tableData: []        
      };
    },
    methods: {
      async salvarDiretor() {
        if (!this.diretor.id) {
          Diretor.salvarDiretor(this.diretor).then((resposta) => {
            alert("Diretor cadastrado com sucesso!");
            this.resposta = resposta;
            this.listarDiretores();
          });  
        } 
        else {
          Diretor.atualizarDiretor(this.diretor).then((resposta) => {
            alert("Diretor atualizado!");
            this.resposta = resposta;
            this.listarDiretores();
          });
        }
      },
      listarDiretores() {
        Diretor.retornarDiretores().then((resposta) => {
          this.tableData = resposta.data;
        });
      },
      atualizarDiretor(diretor) {
        this.diretor = diretor;
      },
      removerDiretor(diretor) {
        Diretor.deletarDiretor(diretor.id).then((resposta) => {
          this.resposta = resposta;
          this.listarDiretores();
        });
      }
    },
    mounted() {
      this.listarDiretores();
    }
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
  font-size: 15px;
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