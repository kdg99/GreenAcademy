<template>
    <h3>Ch02.Vue Directive 실습</h3>
    <hr />
    <h4>1)v-text</h4>
    <p v-text="tit1"></p>
    <p>{{ tit2 }}</p>

    <hr />
    <h4>2)v-show</h4>
    <p v-show="result1">show directive1</p>
    <p v-show="result2">show directive2</p>

    <hr />
    <h4>3)v-if</h4>
    <p v-if="result1">if directive1</p>
    <p v-if="result2">if directive2</p>
    <p v-else>if directive3</p>

    <p v-if="score >= 90">A 입니다.</p>
    <p v-else-if="score >= 80">B 입니다.</p>
    <p v-else-if="score >= 70">C 입니다.</p>
    <p v-else-if="score >= 60">D 입니다.</p>
    <p v-else>F 입니다.</p>
    <p v-if="tit3">{{ tit3 }}</p>
    <p v-else>tit3 empty...</p>

    <hr />
    <h4>4)v-for</h4>
    <ul>
        <li v-for="i in 3">i : {{ i }}</li>
    </ul>
    <ul>
        <li v-for="city in cities">{{ city }}</li>
    </ul>

    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>나이</th>
        </tr>
        <tr v-for="people in person">
            <td>{{ people.uid }}</td>
            <td>{{ people.name }}</td>
            <td>{{ people.age }}</td>
        </tr>
    </table>

    <hr />
    <h4>5)v-on</h4>
    <h4>click 예제</h4>
    <button v-on:click="handler1">button1</button>
    <button v-on:click="handler2(10)">button2</button>
    <button @click="handler3">button3</button>

    <h4>count 예제</h4>
    <p>{{ count }}</p>
    <button @click="countHandler">카운터</button>

    <h4>change 예제</h4>
    <select v-on:change="changeHandler">
        <option v-for="city in cities">{{ city }}</option>
    </select>

    <h4>submit 예제</h4>
    <form v-on:submit.prevent="submitHandler1">
        <table border="1">
            <tr>
                <td>아이디</td>
                <td><input name="uid" type="text" /></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input name="name" type="text" /></td>
            </tr>
            <tr>
                <td>나이</td>
                <td><input name="age" type="text" /></td>
            </tr>
            <tr>
                <td>주소</td>
                <td>
                    <select name="addr">
                        <option v-for="city in cities">{{ city }}</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="전송" />
                </td>
            </tr>
        </table>
    </form>

    <hr />
    <h4>6)v-bind</h4>
    <img v-bind:src="path1" />
    <img v-bind:src="path2" />

    <a v-bind:href="url1">네이버</a>
    <br />
    <a :href="url2">카카오</a>
    <br />
    <button @click="oneClick" v-bind:disabled="isActive">
        한 번만 클릭되는 버튼
    </button>

    <hr />
    <h4>7)v-model</h4>
    <h4>input</h4>
    <p>이름 : {{ name }}</p>
    <input v-model="name" type="text" placeholder="이름 입력" />

    <h4>textarea</h4>
    <p>{{ message }}</p>
    <p>문자수 : {{ message.length }}</p>
    <textarea v-model="message" cols="30" rows="10"></textarea>

    <h4>checkbox</h4>
    <p>
        <input v-model="isChecked" type="checkbox" />
        체크상태 : {{ isChecked }}
    </p>
    <p>
        <label
            ><input v-model="hobbies" type="checkbox" value="등산" />등산</label
        >
        <label
            ><input v-model="hobbies" type="checkbox" value="영화" />영화</label
        >
        <label
            ><input v-model="hobbies" type="checkbox" value="독서" />독서</label
        >
        <label
            ><input v-model="hobbies" type="checkbox" value="운동" />운동</label
        >
        <label
            ><input v-model="hobbies" type="checkbox" value="게임" />게임</label
        >
        <br />
        선택값 : {{ hobbies }}
    </p>

    <h4>select</h4>
    <select v-model="country">
        <option>한국</option>
        <option>미국</option>
        <option>일본</option>
        <option>중국</option>
        <option>호주</option>
    </select>
    <p>선택값 : {{ country }}</p>

    <h4>form</h4>
    <form v-on:submit.prevent="submitHandler2">
        <table border="1">
            <tr>
                <td>아이디</td>
                <td><input v-model="user.uid" type="text" /></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input v-model="user.name" type="text" /></td>
            </tr>
            <tr>
                <td>나이</td>
                <td><input v-model="user.age" type="text" /></td>
            </tr>
            <tr>
                <td>주소</td>
                <td>
                    <select v-model="user.addr">
                        <option v-for="city in cities">{{ city }}</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="전송" />
                </td>
            </tr>
        </table>
    </form>
</template>

<script>
/*
날짜 : 2023/04/03
이름 : 김동근
내용 : Ch02.Vue Directvie 실습
프로젝트 생성/실행
    - npm init vite-app Ch02
    - cd Ch02
    - npm install
    - npm run dev
*/
export default {
    name: "App",
    data() {
        return {
            tit1: "Hello",
            tit2: "Welcome",
            tit3: "",
            result1: true,
            result2: false,
            score: 86,
            cities: ["서울", "대전", "대구", "부산", "광주"],
            person: [
                { uid: "a101", name: "김유신", age: 13 },
                { uid: "a102", name: "김춘추", age: 23 },
                { uid: "a103", name: "장보고", age: 33 },
                { uid: "a104", name: "강감찬", age: 43 },
            ],
            count: 0,
            path1: "/img/flower1.jpg",
            path2: "/img/flower2.jpg",
            url1: "https://www.naver.com",
            url2: "https://www.kakao.com",
            isActive: false,
            name: "",
            message: "",
            isChecked: false,
            hobbies: [],
            country: "한국",
            user: {
                uid: "",
                name: "",
                age: 0,
                addr: "",
            },
        };
    }, //data-end

    methods: {
        handler1: function () {
            alert("button1 click!!!");
        },
        handler2: function (value) {
            alert("button2 click : " + value);
        },
        handler3: function (e) {
            alert("button3 click : " + e);
        },
        countHandler: function () {
            this.count++;
        },
        changeHandler: function (e) {
            alert(e.target.value);
        },
        submitHandler1: function (e) {
            let uid = e.target.elements.uid.value;
            let name = e.target.elements.name.value;
            let age = e.target.elements.age.value;
            let addr = e.target.elements.addr.value;

            console.log("uid : " + uid);
            console.log("name : " + name);
            console.log("age : " + age);
            console.log("addr : " + addr);
        },
        oneClick: function () {
            alert("한 번만 클릭할 수 있습니다.");
            this.isActive = true;
        },
        submitHandler2: function (e) {
            console.log("uid : " + this.user.uid);
            console.log("name : " + this.user.name);
            console.log("age : " + this.user.age);
            console.log("addr : " + this.user.addr);
        },
    },
};
</script>
