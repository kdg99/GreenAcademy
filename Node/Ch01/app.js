/*
날짜 : 2023/05/22
이름 : 김동근
내용 : Hello Node.js 실습
*/
const http = require("http");
const url = require("url");

const server = http.createServer((req, res) => {
    //res.write("Hello Node.js");
    //res.end(); // 끝내고 전송요청
    const path = url.parse(req.url, true).pathname;
    if (path == "/") {
        res.end("Hello World!");
    }
    if (path == "/hello") {
        res.end("Hello Node.js");
    }

    if (path == "/welcome") {
        res.end("Welcome Node.js");
    }
});

server.listen(3000, () => {
    console.log("app 실행...");
});
