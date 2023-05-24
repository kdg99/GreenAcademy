var express = require("express");
const User1 = require("../schemas/user1");
var router = express.Router();

router.get("/list", (req, res) => {
    const users = User1.find();
    res.send(users);
    res.render("user1/list", users);
});

router.get("/register", (req, res) => {
    res.render("user1/register");
});

router.post("/register", async (req, res) => {
    //mongoDB Insert
    const user = await User1.create({
        uid: req.body.uid,
        name: req.body.name,
        hp: req.body.hp,
        age: req.body.age,
    });

    res.redirect("/user1/list");
});

module.exports = router;
