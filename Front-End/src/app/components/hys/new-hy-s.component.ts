import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HysModel } from 'src/app/model/hysModel';
import { HysService } from 'src/app/service/hys.service';


@Component({
  selector: 'app-new-hy-s',
  templateUrl: './new-hy-s.component.html',
  styleUrls: ['./new-hy-s.component.css']
})
export class NewHySComponent implements OnInit {

   nombre: string;
   porcentaje: string;

  constructor(private hySService: HysService, private activatedRouter:
    ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const hyS = new HysModel(this.nombre,this.porcentaje);
    this.hySService.save(hyS).subscribe(
      data=>{
        alert("Tecnología añadida con éxito!!");
        this.router.navigate(['']);
      }, err=>{
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }

}
