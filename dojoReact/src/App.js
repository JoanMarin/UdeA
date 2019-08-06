import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Resultado from './Resultado';

class App extends Component {

constructor(props){
  super(props);
  this.state={resultados:[]}
}

buscar(articulo){
  fetch('https://api.mercadolibre.com/sites/MCO/search?q='+articulo.target.value)
    .then(function(resultado){
      return resultado.json()
    }).then((json)=>{
      this.setState({resultados: json.results})
      })
}


  render() {
    return (
      <div>
      <h1>Que quiero comprar?</h1>
      <input type="text" placeholder="Búsqueda"
        onChange={this.buscar.bind(this)}
        ></input>
        {this.state.resultados
          .map(function(resultado){
            return <Resultado resultado={resultado}></Resultado>
                  })
                }
      </div>
    );
  }
}

export default App;
