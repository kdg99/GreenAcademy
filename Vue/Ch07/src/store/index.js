/*
    vuex 전역 스토어 설정
*/
import { createStore } from "vuex";
import axios from "axios";

const store = createStore({
    state: {
        user: null,
    },
    mutations: {
        SET_USER: function (state, data) {
            state.user = data;
        },
    },
    actions: {
        setUSer: function (context, data) {
            context.commit("SET_USER", data);
        },
        authUser: function (context, token) {
            return axios
                .get("http://localhost:8181/Voard/user/authUser", {
                    headers: { "X-AUTH-TOKEN": token },
                })
                .then((response) => {
                    console.log(response);
                    const rUser = response.data.user;
                    //user 정보 저장(State)
                    context.commit("SET_USER", rUser);
                })
                .catch((error) => {
                    console.log(error);
                    throw error;
                });
        },
        login: function (context, user) {
            //axios 요청 성공값 promise객체
            return axios
                .post("http://localhost:8181/Voard/user/login", user)
                .then((response) => {
                    console.log(response);
                    const token = response.data.accessToken;
                    const rUser = response.data.user;

                    //accessToken 저장(Cookie)
                    localStorage.setItem("accessToken", token);
                    //user 정보 저장(State)
                    context.commit("SET_USER", rUser);
                })
                .catch((error) => {
                    console.log(error);
                    throw error;
                });
        },
    },
    getters: {
        getUser: function (state) {
            return state.user;
        },
    },
});

//store 내보내기 -> main.js 등록 설정
export default store;
