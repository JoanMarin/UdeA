import Controller from '@ember/controller';

export default Controller.extend({
    actions: {
        async adivinar(){
            const options = {
                method: 'GET',
                headers: {'Content-Type': 'application/json'},
            };
            //cambiar por uno generico
            var numero = this.get('numero');
            //https://codebreakerdojo.herokuapp.com/api/codebreaker/
            var result = await getSearch(options,'http://localhost:5000/api/codebreaker/' + numero);
            var resultado = [];

            resultado.push(result);
            
            this.set('model',resultado);
        },
    },
});

function getSearch(options, url) {
    //var proxyUrl = 'https://cors-anywhere.herokuapp.com/';
    return fetch(url, options).then(blob => blob.json()).then(data => {
        return data;
    }).catch(e => {
        return e;
    });
}