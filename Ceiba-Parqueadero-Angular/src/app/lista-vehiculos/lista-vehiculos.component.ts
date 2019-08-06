import { Component, OnInit } from '@angular/core';
import { VehiculoService } from '../vehiculo.service';
import {Router} from "@angular/router"
import { DetallesService } from "../detalles.service"

@Component({
  selector: 'app-lista-vehiculos',
  templateUrl: './lista-vehiculos.component.html',
  styleUrls: ['./lista-vehiculos.component.scss']
})
export class ListaVehiculosComponent implements OnInit {

  vehiculos$: any;
  noResults = false;
  error = false;

  constructor(private vehiculoService: VehiculoService, private router: Router, private detallesServices: DetallesService) { }

  ngOnInit() {
    this.vehiculoService.obtenerVehiculos().subscribe(
      data => {
        this.vehiculos$ = data
        if(this.vehiculos$.length === 0){
          this.noResults = true;
        }
      },
      error => {
        console.log(error);
        this.error = true;
      }
    )
  }

  detalles(Object){
    //console.log(JSON.stringify(Object))
    this.detallesServices.serviceData = Object;
    this.router.navigate(['detalles'])
  }



}
