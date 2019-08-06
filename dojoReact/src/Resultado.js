import React, {Component} from 'react';

class Resultado extends Component {
  resutado={};
  constructor(props){
    super(props);
    this.resultado = props.resultado
  }


  render(){
    return(

      <div className="Item">
      <table width="100%" border="1" >
      <tr >
      <td width="150">
      <div className="Imagen" align="center"><img role="presentacion" src={this.resultado.thumbnail}/></div>
      </td>
      <td >
        <tr>
        <div className="Titulo"><h4>Titulo: </h4>{this.resultado.title}</div>
        <div className="Precio"><h4>Precio:</h4>{this.resultado.price}</div>
        <div className="link"><h4>Link:&nbsp;</h4> {this.resultado.permalink}</div>
        </tr>

        </td>
        </tr>

        </table>

      </div>
    );
  }
}

export default Resultado;
