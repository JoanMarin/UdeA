import shuffle from 'lodash.shuffle';
import FontAwesomeClasses from './fontAwesomeClasses';

const NUMERO_DE_CARTAS = 20//constante con el numero de cartas

export default (params) =>  {
    const fontAwesomeClasses = FontAwesomeClasses();//va importar un array
    let cartas = [];
    while(cartas.length < NUMERO_DE_CARTAS){//aqui vamos agregar cualquier clase de la libreria
        const index = Math.floor(Math.random()*fontAwesomeClasses.length);// numero aleatorio
        const carta = {
            icono: fontAwesomeClasses.splice(index, 1)[0],//extraermos la carta con el indice aleatorio que seleccionamos
            fueAdivinada: false //seleccionatrue cuando el usurio haya encontrado la pareja de la carta
        };
        cartas.push(carta);//ahora debemos empujar estar carta al mazo
        cartas.push({...carta});//volvemos a empujar clonada para que queden las parejas
    }

    return shuffle(cartas);//revolvemos las cartas antes de devolverlas
    //return cartas;
};
