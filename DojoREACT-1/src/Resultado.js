import React, {Component} from 'react';

class Resultado extends Component {
  resutado={};//variavle
  constructor(props){ //constructor
    super(props);
    this.resultado=props.resultado
  }

  render(){
    return(
      <div className="Item">
        <div className="Titulo">{this.resultado.title}</div>
        <div className="Imagen"><img role="presentacion" src={this.resultado.thumbnail}/></div>
        <div className="Precio">{this.resultado.price}</div>
        <div className="link">{this.resultado.permalink}</div>
        <div>------------------------------------</div>
      </div>
    );
  }
}

export default Resultado;
