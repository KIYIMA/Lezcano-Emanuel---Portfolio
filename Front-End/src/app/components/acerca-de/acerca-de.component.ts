import { Component, OnInit } from '@angular/core';
import { AcercaDe } from 'src/app/model/acerca-de';
import { persona } from 'src/app/model/persona.model';
import { AcercaDeService } from 'src/app/service/acerca-de.service';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {

  persona: persona = new persona("","","");
  acercaDe: AcercaDe[]=[];

  constructor(public personaService:PersonaService, private acercaDeS: AcercaDeService, private tokenService: TokenService) { 

  }
  isLogged= false; 

  ngOnInit(): void {
    this.cargarAcercaDe();
    this.existeInformacion();
    this.personaService.getPersona().subscribe(data => {this.persona = data});
    if(this.tokenService.getToken()){
      this.isLogged= true;
    }else{
      this.isLogged= false;
    }
  }

  cargarAcercaDe(): void{
    this.acercaDeS.lista().subscribe(
      data=>{
        this.acercaDe = data;
      }
    );
  }
  delete(id?: number){
    if(id!= undefined){
      this.acercaDeS.delete(id).subscribe(
        data=>{
          this.cargarAcercaDe();
        }, err=> {
          alert("No se pudo eliminar!!");
        }
      )
    }
  }
  existeInformacion(): boolean{
    if(this.acercaDeS.traerInformacion()){
      return true;
    }else{
      return false;
    }
  }
}
