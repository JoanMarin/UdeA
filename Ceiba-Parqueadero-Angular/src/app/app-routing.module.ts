import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaVehiculosComponent } from './lista-vehiculos/lista-vehiculos.component';
import { DetallesVehiculoComponent } from './detalles-vehiculo/detalles-vehiculo.component';
import { FormularioComponent } from './formulario/formulario.component';

const routes: Routes = [
  { path:'', component: FormularioComponent },
  { path:'detalles/:placa', component: DetallesVehiculoComponent },
  { path:'detalles', component: DetallesVehiculoComponent },
  { path:'lista', component: ListaVehiculosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
