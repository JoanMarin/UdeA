
var assert = require('assert');
var request = require('supertest')
var codebreaker=require('../domain/cb');
var chaiHttp = require('chai-http');
var app = require('../app');
var chai = require('chai');
var should = chai.should();
chai.use(chaiHttp);
var expect = chai.expect;


    describe('Code breaker',function(){
        describe('Funcionalidades',function(){
            codebreaker.setSecret("4321");
            it('Todos los parametros son X',function(){
                assert.equal(codebreaker.cb("4321"),"XXXX");        
            });
            it('Todos los parametros son _',function(){
                assert.equal(codebreaker.cb("1234"),"----");        
            });
            it('Todos los parametros son incorrectos',function(){
                assert.equal(codebreaker.cb("5678"),"");        
            });
            it('3 parametros en posiciones correctas',function(){
                assert.equal(codebreaker.cb("4329"),"XXX");        
            });
            it('3 parametros en posiciones correctas',function(){
                assert.equal(codebreaker.cb("4120"),"XX-");        
            });
        });
        describe('Restricciones',function(){
            codebreaker.setSecret("4321");
            it('Validacion de digitos repetidos',function(){
                assert.equal(codebreaker.validacionRepetidos("4331"),false);        
            });
            it('Validacion de digitos diferentes entre si',function(){
                assert.equal(codebreaker.validacionRepetidos("1568"),true);        
            });
            it('Validacion de la cadena de mayor tamaño',function(){
                assert.equal(codebreaker.validacionTamaño("156834"),false);        
            });
            it('Validacion de la cadena de menor tamaño',function(){
                assert.equal(codebreaker.validacionTamaño("156"),false);        
            });
            it('Validacion de la cadena de menor tamaño',function(){
                assert.equal(codebreaker.validacionTamaño(""),false);        
            });
            it('Validacion tipo de caracter numerico',function(){
                assert.equal(codebreaker.validacionTipo("45d2"),false);        
            });
            it('Validacion tipo de caracter numerico',function(){
                assert.equal(codebreaker.validacionTipo("4532"),true);        
            });
            it('Validacion en general error tipo de dato',function(){
                assert.equal(codebreaker.validarCadena("13*2"),"La cadena solo puede contener caracteres numericos");        
            });
            it('Validacion en general error tamaño cadena',function(){
                assert.equal(codebreaker.validarCadena("134092"),"La cadena solo puede contener 4 digitos exactos");        
            });
            it('Validacion en general error numeros repetidos',function(){
                assert.equal(codebreaker.validarCadena("1334"),"La cadena no puede contener digitos repetidos");        
            }); 
        });

        
        
        describe('Pruebas de servicio', function() {
            describe('POST', function(){
                it('Should return OK', function(done){
                    let req = {secret: "4321"}
                    chai.request(app)
                        .post('/setsecreto/')
                        .send(req)
                        .end(function(err,res){
                            res.should.have.status(200);
                            assert.equal(res.text, 'OK');
                        done();
                        })
                })
            })
            describe('GET', function(){
                it('Should return XXXX', function(done){
                    codebreaker.setSecret("4321");
                    chai.request(app)
                        .get('/adivinarsecreto/4321')
                        .end(function(err,res) {
                            res.should.have.status(200);
                            assert.equal(res.text,'XXXX');
                        done(); 
                        }
                    );
                });
            });
        }); 
    });


