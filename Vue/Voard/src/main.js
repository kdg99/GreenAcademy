/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from "./App.vue";

// Composables
import { createApp } from "vue";

// Plugins
import { registerPlugins } from "@/plugins";
import router from "./routers/index.js";
import userStore from "./store/user.js";
import CKEditor from "@ckeditor/ckeditor5-vue";

const app = createApp(App);
registerPlugins(app);

app.use(router).use(userStore).use(CKEditor).mount("#app");
