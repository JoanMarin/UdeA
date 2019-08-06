module.exports={

    cb:function(cadena) {
        var clave = "4321"
        var resultado = "";
        var equis="";
        var guiones="";
        var mensageValidacion=this.validarCadena(cadena);
        if(mensageValidacion != true){
            return mensageValidacion;
        }

        for (i = 0; i < 4; i++){
            for (j = 0; j < 4; j++) {
                if(clave[i]==cadena[j]){
                    if(i==j){
                        equis=equis+"X";
                    }else{
                        guiones=guiones+"-";
                    }
                }
            }
            
        }
        resultado=equis+guiones;
        return resultado;
    },

    validacionRepetidos:function(cadena) {
        for (i = 0; i < 4; i++){
            var count = 0;
            for (j = 0; j < 4; j++) {
                if(cadena[i] == cadena[j]){
                    count++;
                }
            }
            if(count >= 2){
                return false;
            }   
        }
        return true;
    },
    validacionTamaño: function(cadena){
        if(cadena.length!=4){
            return false;
        }
        return true;
    },
    validacionTipo:function(cadena){
        return /^\d+$/.test(cadena); 
    },
    validarCadena:function(cadena){
        if (!this.validacionTipo(cadena)) {
            return "La cadena solo puede contener caracteres numericos";
        } else if(!this.validacionTamaño(cadena)){
            return "La cadena solo puede contener 4 digitos exactos";
        } else if(!this.validacionRepetidos(cadena)){
            return "La cadena no puede contener digitos repetidos";
        }
        return true;
    }
     
}