import Vue from 'vue'
import Router from 'vue-router'
import CadastroUsuario from '@/components/CadastroUsuario.vue'
import CadastroDiretor from '@/components/CadastroDiretor.vue'
import CadastroFilme from '@/components/CadastroFilme.vue'

Vue.use(Router)

const router = new Router({
    routes: [
    
    {
      name: "CadastroUsuario",
      path: "/",
      component: CadastroUsuario,
    },
    {
      name: "CadastroDiretor",
      path: "/CadastroDiretor",
      component: CadastroDiretor,
    },
    {
      name: "CadastroFilme",
      path: "/CadastroFilme",
      component: CadastroFilme,
    },
  ],
});

export default router