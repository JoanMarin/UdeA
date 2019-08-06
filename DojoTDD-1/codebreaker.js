
class CodeBreaker {
  constructor(secret) {
    this.secret = secret;
  }

  validarRepetidos(number) {
    let size = number.length
    for(var i = 0; i <= size; i++) {
        for(var j = i; j <= size; j++) {
            if(i != j && number[i] == number[j]) {
                return true;
            }
        }
    }
    return false;
  }

  setSecret(number){
    let reg = new RegExp('^[0-9]*$');
    if(!(number.length == 4)){
        return "ingrese un numero de cuatro digitos";
    }

    if(!reg.test(number)) {
        return "algun caracter no es un numero";
    }

    if(this.validarRepetidos(number)){
        return "no se aceptan numeros repetidos";
    }

    this.secret = number;
  }

  compare(number){
    let size = number.length
    let result = ""
    let equalDigits = 0;
    let containDigits = 0;
    var reg = new RegExp('^[0-9]*$');

    if(!(this.secret.length == size)){
        return "ingrese un numero de cuatro digitos";
    }

    if(!reg.test(number)) {
        return "algun caracter no es un numero";
    }
    

    if(this.validarRepetidos(number)){
        return "no se aceptan numeros repetidos";
    }

    for(let i = 0; i < size; i++){
        if (this.secret.includes(number[i])) {
            if (this.secret[i]===number[i]) {
                equalDigits++;
            } else {
                containDigits++;
            }
        }
        else {
            //result += "";
        }            
    }
    //result = Array(equalDigits+1).join("x") + Array(containDigits+1).join("_");
    result = "x".repeat(equalDigits) + "_".repeat(containDigits);
    return result;
  }
}

module.exports = CodeBreaker;
//export default class {}