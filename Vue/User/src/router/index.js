import { createRouter, createWebHistory } from "vue-router";
import User1Main from "../components/user1/User1Main.vue";
import User1Register from "../components/user1/User1Register.vue";
import User1Modify from "../components/user1/User1Modify.vue";
import User1List from "../components/user1/User1List.vue";

import User2Main from "../components/user2/User2Main.vue";
import User2Register from "../components/user2/User2Register.vue";
import User2List from "../components/user2/User2List.vue";
import User2Modify from "../components/user2/User2Modify.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/user1",
            name: "User1Main",
            component: User1Main,
            children: [
                { path: "", component: User1Register },
                { path: "list", component: User1List },
                { path: "register", component: User1Register },
                {
                    path: "modify",
                    name: "User1Modify",
                    component: User1Modify,
                    props: true,
                },
            ],
        },
        {
            path: "/user2",
            name: "User2Main",
            component: User2Main,
            children: [
                { path: "", component: User2Register },
                { path: "register", component: User2Register },
                { path: "list", component: User2List },
                { path: "modify", component: User2Modify },
            ],
        },
    ],
});

export default router;
