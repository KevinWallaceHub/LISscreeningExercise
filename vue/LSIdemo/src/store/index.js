
import { createStore } from 'vuex'



const store = createStore({
  state: {
    entries: []
  },
  mutations: {
    addEntry(state, entry) {
      state.entries.push(entry);
      console.log(store.state)
    },
  }


});

export default store