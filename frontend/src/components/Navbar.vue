<template lang="pug">
  div
    el-menu.custom-menu(
      :default-active="activeIndex"
      mode="horizontal" 
      class="el-menu-demo" 
      text-color="aliceblue"
      background-color="blueviolet"
      active-text-color="#000"
      router
      @select="handleSelect")
      el-menu-item(index="CadastroUsuario") Usuário
      el-menu-item(index="CadastroDiretor") Diretor
      el-menu-item(index="CadastroFilme") Filme
</template>

<script>
export default {
  name: 'Navbar',
  data() {
      return {
        activeIndex: 'CadastroUsuario',
      };
    },
    methods: {
      handleSelect(key) {
        this.$router.push(key)
    }
  }
}
</script>

<style scoped>
  @import url("//unpkg.com/element-ui@2.15.1/lib/theme-chalk/index.css");
  
  .custom-menu{
    display: flex;
    justify-content: center;
    align-items: center;
  }

</style>
