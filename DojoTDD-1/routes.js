'use strict' // convencio de EMC6
const express = require('express');
const codebreaker= require('./codebreaker');
//controlador
const api=express.Router();
const instanceCodeBreaker = new codebreaker("1234");

api.get('/codebreaker/:num',function (req, res) {
    let num = req.params.num;
    let resultado = instanceCodeBreaker.compare(num);
    res.status(200).send({ resultado });
});

api.get('/codebreaker/secret/:num',function (req, res) {
    let num = req.params.num;
    let resultado = instanceCodeBreaker.setSecret(num);
    res.status(200).send({ resultado });
});


module.exports=api;