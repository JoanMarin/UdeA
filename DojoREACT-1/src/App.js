import React, { Component } from 'react';
import logo from './logo.svg';
import Resultado from './Resultado';
import './App.css';

class App extends Component {
  constructor(props){
    super(props);
    this.buscar('Audifonos');
    this.state={
      resultados:[]
    }
  }

  cambioInput(elemento){
    console.log('Valor:', elemento.target.value);
    this.buscar(elemento.target.value);
  }

  buscar(busqueda){
    fetch('https://api.mercadolibre.com/sites/MCO/search?q='+busqueda)
    .then(function(resultado){
      console.log('then'); //imprime en consola
      console.log(resultado);
      return resultado.json()
    }).then((json)=>{
      this.setState({
        resultados: json.results
      })
    })
    console.log('Despues del fetch');
  }

  render() {
    return (
      <div>
      <h2>David Parra Valencia cc 1036621544</h2>
      <input type="text" placeholder="Búsqueda"
      onChange={this.cambioInput.bind(this)}></input>
      {this.state.resultados.map(function(resultado){
        return <Resultado resultado={resultado}></Resultado>
      })}

      </div>
    );
  }
}

export default App;
