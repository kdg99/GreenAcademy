import { createStore } from "vuex";
import axios from "axios";
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
        },
        CLEAR_TODO(state) {
            state.todos = [];
        },
    },
    actions: {
        setTodo(context, todolog) {
            context.commit("SET_TODO", todolog);
        },
        addTodo(context, todo) {
            let vo = {
                content: todo,
            };
            axios
                .post("http://52.78.87.169:8103/TodoAppBackend/todo", vo)
                .then((response) => {
                    console.log(response.data);
                    context.commit("ADD_TODO", response.data);
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        removeTodo(context, no) {
            axios
                .delete(`http://52.78.87.169:8103/TodoAppBackend/todo/${no}`)
                .then((response) => {
                    console.log(response);
                    context.commit("SET_TODO", response.data);
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        clearTodo(context) {
            context.commit("CLEAR_TODO");
            axios
                .delete("http://52.78.87.169:8103/TodoAppBackend/clear")
                .then((response) => {
                    console.log(response);
                    context.commit("CLEAR_TODO");
                })
                .catch((error) => {
                    console.log(error);
                });
        },
    },
    getters: {
        getTodos(state) {
            return state.todos;
        },
    },
});

export default store;
