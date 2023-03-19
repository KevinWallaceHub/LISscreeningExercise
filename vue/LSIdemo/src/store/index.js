import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)


export default new Vuex.Store({
  state:{
    entries: []
  },
  mutations: {
    addEntry(state, entry) {
      state.entries.push(entry);
    },
  },
});