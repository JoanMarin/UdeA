import Controller from '@ember/controller';

export default Controller.extend({
    resultado: '',
    actions: {
        convertirToRomano(numero){
            var decimas = Math.floor(numero/10);
            var unidades = numero % 10;
            var dec = ['X', 'XX', 'XXX', 'XL', 'L', 'LX', 'LXX', 'LXXX', 'XC', 'C'];
            var uni = ['I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX'];
            var str1;
            var str2;

            if (decimas === 0){
                str1 = "";
            }
            else{
                str1 = dec[decimas - 1];
            }

            if (unidades === 0){
                str2 = "";
            }
            else{
                str2 = uni[unidades - 1];
            }

            var resul = str1+str2;
            this.set('resultado', resul);
        } 
    }
});
