import { createStore } from "vuex";

const store = createStore({
    state: {
        user: null,
        users: null,
    },
    mutations: {
        SET_USER: function (state, data) {
            state.user = data;
        },

        SET_USERS: function (state, data) {
            state.users = data;
        },
    },
    actions: {
        setUser: function (context, data) {
            context.commit("SET_USER", data);
        },
        setUsers: function (context, data) {
            context.commit("SET_USERS", data);
        },
    },
    getters: {
        getUser: function (state) {
            return state.user;
        },
        getUsers: function (state) {
            return state.users;
        },
    },
});

export default store;
