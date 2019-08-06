const codebreaker = require('./codebreaker');
let chai = require('chai');
let assert = require('chai').assert;
const expect = require('chai').expect;
let chaiHttp = require('chai-http');
let app = require('./app');

chai.use(chaiHttp);
const url= 'http://localhost:5000/api/';

let instanceCodeBreaker = new codebreaker("1234");

describe('CODEBREAKER', function(){
    it('todos iguales' , function (){
        let res = instanceCodeBreaker.compare("1234");
        assert.equal(res, "xxxx"); 
    });

    it('todos distintos' , function (){
        let res = instanceCodeBreaker.compare("5678");
        assert.equal(res, ""); 
    });

    it('todos en desorden' , function (){
        let res = instanceCodeBreaker.compare("2143");
        assert.equal(res, "____"); 
    });

    it('dos iguales, dos en desorden' , function (){
        let res = instanceCodeBreaker.compare("1243");
        assert.equal(res, "xx__"); 
    });

    it('uno igual, tres en desorden' , function (){
        let res = instanceCodeBreaker.compare("2314");
        assert.equal(res, "x___"); 
    });

    it('tamaño menor' , function (){
        let res = instanceCodeBreaker.compare("231");
        assert.equal(res, "ingrese un numero de cuatro digitos"); 
    });
    it('tamaño mayor' , function (){
        let res = instanceCodeBreaker.compare("23145");
        assert.equal(res, "ingrese un numero de cuatro digitos"); 
    });

    it('algun caracter no numerico' , function (){
        let res = instanceCodeBreaker.compare("2a14");
        assert.equal(res, "algun caracter no es un numero"); 
    });

    it('algun caracter repetido' , function (){
        let res = instanceCodeBreaker.compare("1212");
        assert.equal(res, "no se aceptan numeros repetidos"); 
    });
    
});

describe('api/codebreaker ',()=>{
	it('todos iguales', (done) => {
		chai.request(app)
			.get('/api/codebreaker/1234')
			.end( function(err,res){
				//console.log("res: "+res.body)
                expect(res.body).to.have.property('resultado').to.be.equal("xxxx");
                expect(res).to.have.status(200);                
				done();
			});
    });
    
   it('todos distintos', (done) => {
		chai.request(app)
			.get('/api/codebreaker/5678')
			.end( function(err,res){
				//console.log("res: "+res.body)
                expect(res.body).to.have.property('resultado').to.be.equal("");
                expect(res).to.have.status(200);                
				done();
			});
    });
    
    it('todos en desorden', (done) => {
		chai.request(app)
			.get('/api/codebreaker/2143')
			.end( function(err,res){
				//console.log("res: "+res.body)
                expect(res.body).to.have.property('resultado').to.be.equal("____");
                expect(res).to.have.status(200);                
				done();
			});
    });
    
    it('dos iguales, dos en desorden', (done) => {
		chai.request(app)
			.get('/api/codebreaker/1243')
			.end( function(err,res){
				//console.log("res: "+res.body)
                expect(res.body).to.have.property('resultado').to.be.equal("xx__");
                expect(res).to.have.status(200);                
				done();
			});
    });
    
    it('uno igual, tres en desorden', (done) => {
		chai.request(app)
			.get('/api/codebreaker/2314')
			.end( function(err,res){
				//console.log("res: "+res.body)
                expect(res.body).to.have.property('resultado').to.be.equal("x___");
                expect(res).to.have.status(200);                
				done();
			});
    });
    
    it('tamaño menor' , (done) => {
        chai.request(app)
        .get('/api/codebreaker/231')
        .end( function(err,res){
            //console.log("res: "+res.body)
            expect(res.body).to.have.property('resultado').to.be.equal("ingrese un numero de cuatro digitos");
            expect(res).to.have.status(200);                
            done();
        });
    });

    it('tamaño mayor' , (done) => {
        chai.request(app)
        .get('/api/codebreaker/23145')
        .end( function(err,res){
            //console.log("res: "+res.body)
            expect(res.body).to.have.property('resultado').to.be.equal("ingrese un numero de cuatro digitos");
            expect(res).to.have.status(200);                
            done();
        }); 
    });

    it('algun caracter no numerico' , (done) => {
        chai.request(app)
        .get('/api/codebreaker/2a14')
        .end( function(err,res){
            //console.log("res: "+res.body)
            expect(res.body).to.have.property('resultado').to.be.equal("algun caracter no es un numero");
            expect(res).to.have.status(200);                
            done();
        }); 
    });

    it('algun caracter repetido' ,  (done) => {
        chai.request(app)
        .get('/api/codebreaker/1212')
        .end( function(err,res){
            //console.log("res: "+res.body)
            expect(res.body).to.have.property('resultado').to.be.equal("no se aceptan numeros repetidos");
            expect(res).to.have.status(200);                
            done();
        }); 
    });

});


describe('api/Secret', function(){

    it('tamaño menor' , (done) => {
        chai.request(app)
        .get('/api/codebreaker/secret/231')
        .end( function(err,res){
            //console.log("res: "+res.body)
            expect(res.body).to.have.property('resultado').to.be.equal("ingrese un numero de cuatro digitos");
            expect(res).to.have.status(200);                
            done();
        });  
    });
     it('tamaño mayor' ,  (done) => {
        chai.request(app)
        .get('/api/codebreaker/secret/23145')
        .end( function(err,res){
            //console.log("res: "+res.body)
            expect(res.body).to.have.property('resultado').to.be.equal("ingrese un numero de cuatro digitos");
            expect(res).to.have.status(200);                
            done();
        });   
    });

    it('algun caracter no numerico' ,  (done) =>{
        chai.request(app)
        .get('/api/codebreaker/secret/2a14')
        .end( function(err,res){
            //console.log("res: "+res.body)
            expect(res.body).to.have.property('resultado').to.be.equal("algun caracter no es un numero");
            expect(res).to.have.status(200);                
            done();
        });   
    });

    it('algun caracter repetido' ,  (done) =>{
        chai.request(app)
        .get('/api/codebreaker/secret/1212')
        .end( function(err,res){
            //console.log("res: "+res.body)
            expect(res.body).to.have.property('resultado').to.be.equal("no se aceptan numeros repetidos");
            expect(res).to.have.status(200);                
            done();
        });   
    }); 
    
});


describe('Secret', function(){

    it('tamaño menor' , function (){
        let res = instanceCodeBreaker.setSecret("231");
        assert.equal(res, "ingrese un numero de cuatro digitos"); 
    });
    it('tamaño mayor' , function (){
        let res = instanceCodeBreaker.setSecret("23145");
        assert.equal(res, "ingrese un numero de cuatro digitos"); 
    });

    it('algun caracter no numerico' , function (){
        let res = instanceCodeBreaker.setSecret("2a14");
        assert.equal(res, "algun caracter no es un numero"); 
    });

    it('algun caracter repetido' , function (){
        let res = instanceCodeBreaker.setSecret("1212");
        assert.equal(res, "no se aceptan numeros repetidos"); 
    });
    
}); 


