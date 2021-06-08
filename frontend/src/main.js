import Vue from 'vue'
import Home from './Home.vue'
import Element from 'element-ui'
import router from './routes'
import locale from 'element-ui/lib/locale/lang/pt-br'

Vue.config.productionTip = false
Vue.use(Element,{locale})
    
export default new Vue({
    router,
    render: h => h(Home),
  }).$mount('#app')
