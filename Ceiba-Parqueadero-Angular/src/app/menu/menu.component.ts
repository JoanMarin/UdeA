import { Component, OnInit } from '@angular/core';
import { VehiculoService } from '../vehiculo.service';
import { DetallesService } from '../detalles.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  trm: any;

  constructor(private vehiculoService: VehiculoService, private detallesService: DetallesService) {}

  ngOnInit() {
    if(this.detallesService.trm){
      this.trm = this.detallesService.trm
    }else{
      this.vehiculoService.obtenerTRM().subscribe(
        data => {
          this.trm = data
          this.trm = this.trm.USD_COP.val
          this.detallesService.trm = this.trm;
         }
        )
    }
    
    
  }

}
