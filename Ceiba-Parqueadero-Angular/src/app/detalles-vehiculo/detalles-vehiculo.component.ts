import { Component, OnInit } from '@angular/core';
import { VehiculoService } from '../vehiculo.service';
import { DetallesService } from "../detalles.service"
import {Router} from "@angular/router"
import swal from 'sweetalert';


@Component({
  selector: 'app-detalles-vehiculo',
  templateUrl: './detalles-vehiculo.component.html',
  styleUrls: ['./detalles-vehiculo.component.scss']
})
export class DetallesVehiculoComponent implements OnInit {

  vehiculo;
  loading = false;
  respuesta: any = {messsage:""};

  constructor(private vehiculosService: VehiculoService, private detallesServices: DetallesService, private router : Router) {
    console.log("%c contructor","color:orange;font-size:16px;")
    !this.detallesServices.serviceData && this.router.navigate(['lista']); 
   }

  ngOnInit() {
    console.log("%c onInit","color:orange;font-size:16px;")
    console.log(this.detallesServices.serviceData)
    this.vehiculo = this.detallesServices.serviceData;
  }

  salidaVehiculo(){
    this.loading = true;
    this.vehiculosService.salidaVehiculos(this.vehiculo.placa).subscribe(
      (data) => {
        this.respuesta =  data;
        swal( "Valor a pagar: "+this.respuesta,"Vehiculo Borrado Exitosamente","success").then(()=>{
          this.router.navigate(['lista']); 
        });
        console.log(data) 
        this.loading = false;
      },
      (error) => { 
        if(error.status == 0){
          this.respuesta = error.error;
          swal( "Intenta mas tarde..","","error").then(()=>{
          });
        }else{
          this.respuesta = error.error;
          swal( this.respuesta.message,"","error").then(()=>{
          });
        }
        console.log("%c error","color:orange;font-size:16px;")
        console.log(error)
        this.loading = false;
      }
    )
  }

}
