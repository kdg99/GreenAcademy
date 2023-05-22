/*
날짜 : 2023/05/22
이름 : 김동근
내용 : Express 실습
*/
const express = require("express");
const app = express();

//template engine
app.set("views", __dirname + "/views"); //views prefix설정
app.set("view engine", "ejs");

//route
app.get("/", (req, res) => {
    const data = {
        tit1: "Node.js Express",
        tit2: "EJS Template Engine",
        result1: true,
        result2: false,
        score: 86,
        user: {
            uid: "a101",
            name: "홍길동",
            hp: "010-1234-1234",
            age: 21,
        },
        users: [
            { uid: "p101", name: "김유신1", hp: "010-1234-1001", age: 21 },
            { uid: "p102", name: "김유신2", hp: "010-1234-1002", age: 22 },
            { uid: "p103", name: "김유신3", hp: "010-1234-1003", age: 23 },
            { uid: "p104", name: "김유신4", hp: "010-1234-1004", age: 24 },
        ],
    };
    res.render("index", data);
});

app.get("/hello", (req, res) => {
    res.send("hello...");
});

app.get("/sub/hello", (req, res) => {
    res.render("sub/hello"); // 렌더시 시작 / 생략
});
app.get("/sub/welcome", (req, res) => {
    res.render("sub/welcome"); // 렌더시 시작 / 생략
});

app.listen(3000, () => {
    console.log("3000 실행");
});
