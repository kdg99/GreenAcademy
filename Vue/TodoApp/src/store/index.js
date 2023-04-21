import { createStore } from "vuex";
const store = createStore({
    state: {
        todos: [],
    },
    mutations: {
        SET_TODO(state, todolog) {
            state.todos = todolog;
        },
        ADD_TODO(state, todo) {
            state.todos.push(todo);
            localStorage.setItem("todolog", state.todos);
        },
        REMOVE_TODO(state, index) {
            state.todos.splice(index, 1);
            localStorage.setItem("todolog", state.todos);
        },
        CLEAR_TODO(state) {
            state.todos = [];
            localStorage.setItem("todolog", state.todos);
        },
    },
    actions: {
        setTodo(context, todolog) {
            context.commit("SET_TODO", todolog);
        },
        addTodo(context, todo) {
            context.commit("ADD_TODO", todo);
        },
        removeTodo(context, index) {
            context.commit("REMOVE_TODO", index);
        },
        clearTodo(context) {
            context.commit("CLEAR_TODO");
        },
    },
    getters: {
        getTodos(state) {
            return state.todos;
        },
    },
});

export default store;
