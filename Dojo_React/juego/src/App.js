import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import construirBaraja from './utils/construirBaraja';
import Header from './Header';
import Tablero from './Tablero';

class App extends Component {
  constructor(props){
    super(props);
    this.state = getEstadoInicial();
  }

  seleccionarCarta(carta){
    if(this.state.estaComparando||
      this.state.parejaSeleccionada.indexOf(carta)>-1||
      carta.fueAdivinada
    ){
      return;
    }

    const parejaSeleccionada = [...this.state.parejaSeleccionada, carta]
    
    this.setState({
      parejaSeleccionada
    })

    if(parejaSeleccionada.length === 2){
      this.compararPareja(parejaSeleccionada)
    }
  }

  compararPareja(parejaSeleccionada){
    this.setState({estaComparando: true});
    setTimeout(() => {
      const [primeraCarta, segundaCarta] = parejaSeleccionada;
      let baraja = this.state.baraja;

      if(primeraCarta.icono === segundaCarta.icono){
        baraja = baraja.map((carta) => {
          if(carta.icono !== primeraCarta.icono){
            return carta;
          }
          return {...carta,fueAdivinada: true};
        });
      }

      this.setState({
        baraja,
        estaComparando: false,
        parejaSeleccionada: [],
        numeroDeIntentos: this.state.numeroDeIntentos + 1
      })
      this.verificarSihayGanador(baraja);
    },1000);
  }

  verificarSihayGanador(baraja){
    if(baraja.filter((carta) => !carta.fueAdivinada).length === 0){
      alert(`Ganaste en ${this.state.numeroDeIntentos} intentos`);
    }
  }

  resetearPartida(){
    this.setState(
      getEstadoInicial()
    );
  }

  render(){
    return(
      <div className="App">
        <Header
          numeroDeIntentos = {this.state.numeroDeIntentos}
          resetearPartida = {() => this.resetearPartida()}
        />
        <Tablero
          baraja = {this.state.baraja}
          parejaSeleccionada = {this.state.parejaSeleccionada}
          seleccionarCarta = {(carta) => this.seleccionarCarta(carta)}
        />
      </div>
    );
  }
}

const getEstadoInicial = () => {
  const baraja = construirBaraja();
  return{
    baraja,
    parejaSeleccionada: [],
    estaComparando: false,
    numeroDeIntentos: 0
  };
}

export default App;
