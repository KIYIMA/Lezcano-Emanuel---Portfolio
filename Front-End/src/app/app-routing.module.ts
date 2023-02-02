import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditAcercaDeComponent } from './components/acerca-de/edit-acerca-de.component';
import { NewAcercaDeComponent } from './components/acerca-de/new-acerca-de.component';
import { EditeducacionComponent } from './components/educacion/editeducacion.component';
import { NeweducacionComponent } from './components/educacion/neweducacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { EditHySComponent } from './components/hys/edit-hy-s.component';
import { NewHySComponent } from './components/hys/new-hy-s.component';
import { LoginComponent } from './components/login/login.component';
import { EditproyectosComponent } from './components/proyecto/editproyectos.component';
import { NewproyectoComponent } from './components/proyecto/newproyecto.component';


const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexp', component: NewExperienciaComponent},
  {path:'editexp/:id', component: EditExperienciaComponent},
  {path:'nuevaedu', component: NeweducacionComponent},
  {path:'editedu/:id', component: EditeducacionComponent},
  {path:'nuevoproyecto', component: NewproyectoComponent},
  {path:'editproyecto/:id', component: EditproyectosComponent},
  {path:'nuevoacercade', component: NewAcercaDeComponent},
  {path:'editacercade/:id', component: EditAcercaDeComponent},
  {path:'editHyS/:id', component: EditHySComponent},
  {path:'newTech', component: NewHySComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
