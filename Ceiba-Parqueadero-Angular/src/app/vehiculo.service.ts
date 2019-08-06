import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {
  //options = {headers:{'Content-Type':'application/json','responseType': 'text'}};
  url = "http://localhost:8080/vehiculos/";
  constructor(private http: HttpClient) {}

  obtenerVehiculos(){
    return this.http.get(this.url+"detalles");
  }

  registrarVehiculo(body){
    return this.http.post(this.url,body/*,this.options*/);
  }

  salidaVehiculos(placa){
    return this.http.delete(this.url+placa);
  }

  obtenerTRM(){
    return this.http.get('http://free.currencyconverterapi.com/api/v5/convert?q=USD_COP&compact=y');
  }
}
