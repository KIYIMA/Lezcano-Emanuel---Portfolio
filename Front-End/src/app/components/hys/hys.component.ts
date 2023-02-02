import { Component, OnInit } from '@angular/core';
import { HysModel } from 'src/app/model/hysModel';
import { HysService } from 'src/app/service/hys.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hys',
  templateUrl: './hys.component.html',
  styleUrls: ['./hys.component.css']
})

export class HysComponent implements OnInit {

  hySModel: HysModel[] = [];

  constructor(private hySService: HysService ,private tokenService: TokenService) { }

  isLogged= false;

  ngOnInit(): void {
    this.cargarTecnología();
    if(this.tokenService.getToken()){
      this.isLogged= true;
    }else{
      this.isLogged= false;
    }
  }

  cargarTecnología(): void{
    this.hySService.lista().subscribe(
      data=>{
        this.hySModel = data;
      }
    )
  }

  delete(id?: number){
    if(id != undefined){
      this.hySService.delete(id).subscribe(
        data=>{
          this.cargarTecnología();
        }, err=>{
          alert("No se pudo eliminar");
        }
      )
    }
  }
}
