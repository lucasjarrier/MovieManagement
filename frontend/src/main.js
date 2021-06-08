import Vue from 'vue'
import Home from './Home.vue'
import Element from 'element-ui'
import router from './routes'

Vue.config.productionTip = false
Vue.use(Element)
    
export default new Vue({
    router,
    render: h => h(Home),
  }).$mount('#app')
