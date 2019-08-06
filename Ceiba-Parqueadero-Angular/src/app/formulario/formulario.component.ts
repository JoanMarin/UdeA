import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup,Validators} from '@angular/forms';
import { VehiculoService } from '../vehiculo.service';
import {Router} from "@angular/router";
import swal from 'sweetalert';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.scss']
})
export class FormularioComponent implements OnInit {

  respuesta: any = {messsage:""};
  vehiculoForm: FormGroup;
  submitted = false;
  valor = "";
  loading = false;

  constructor(private vehiculoService : VehiculoService, private router: Router,private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.vehiculoForm = this.formBuilder.group({
      placa: ['', [Validators.required,Validators.maxLength(40),Validators.minLength(6),Validators.pattern('^[a-zA-Z0-9]*$')]],
      tipo: ['carro'],
      cilindraje: ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      modelo: ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      color: ['', [Validators.required,Validators.maxLength(40),Validators.pattern('^[a-zA-Z]*$')]],
      clase: ['', [Validators.required,Validators.maxLength(40),Validators.pattern('^[a-zA-Z]*$')]],
      marca: ['', [Validators.required,Validators.maxLength(40),Validators.pattern('^[a-zA-Z]*$')]]
  });
  }

  get form() { return this.vehiculoForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.vehiculoForm.invalid) {
        return;
    }
    console.warn(this.vehiculoForm.value);
    this.loading = true;
    this.vehiculoService.registrarVehiculo(this.vehiculoForm.value).subscribe(
      (data) => {
        this.respuesta =  data;
        swal( this.respuesta,"","success").then(()=>{
          this.router.navigate(['lista']); 
        });
        console.log("%c data","color:orange;font-size:16px;") 
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
    });
  }


  soloLetras($event: any) {
    const pattern = /^[a-zA-Z]*$/;
    let inputChar = $event.key;
    if (!pattern.test(inputChar)) {
      $event.preventDefault();
    }
  }

  soloNumerosYLetras($event: any) {
    const pattern = /^[a-zA-Z0-9]*$/;
    let inputChar = $event.key;
    if (!pattern.test(inputChar)) {
      $event.preventDefault();
    }
  }

  soloNumeros($event: any) {
    const pattern = /^[0-9]*$/;
    let inputChar = $event.key;
    if (!pattern.test(inputChar)) {
      $event.preventDefault();
    }
  }

}
