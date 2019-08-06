import React, {Component} from 'react';
import './Carta.css';
import FlipCard from '@kennethormandy/react-flipcard';
import '@kennethormandy/react-flipcard/dist/Flipcard.css';
import Flipcard from '@kennethormandy/react-flipcard';

export default class Carta extends Component {
    render(){
        return(
            <div className="carta" onClick={this.props.seleccionarCarta}>
                <Flipcard 
                    flipped = {this.props.estaSiendoComparada || this.props.fueAdivinada}
                >
                    <div className="portada"></div>
                    <div className="contenido">
                        <i className={`fa ${this.props.icono} fa-5x`}></i>
                    </div>
                </Flipcard>
            </div>
        )
    }
};