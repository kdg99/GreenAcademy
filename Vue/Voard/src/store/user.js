import { createStore } from "vuex";

const userStore = createStore({
  state: {
    user: null,
  },
  mutations: {
    SER_USER(state, user) {
      state.user = user;
    },
  },
  actions: {
    setUser(context, user) {
      context.commit("SET_USER", user);
    },
  },
  getters: {
    getUser(state) {
      return state.user;
    },
  },
});

export default userStore;
