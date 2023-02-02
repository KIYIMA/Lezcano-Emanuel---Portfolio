import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-newproyecto',
  templateUrl: './newproyecto.component.html',
  styleUrls: ['./newproyecto.component.css']
})
export class NewproyectoComponent implements OnInit {

  nombreP: string;
  descripcionP: string;
  urlP: string;
  img: string;
  constructor(private proyectoS: ProyectoService, private router: Router) { }

  ngOnInit(): void {

  }

  onCreate(): void {
    const proyecto = new Proyecto(this.nombreP, this.descripcionP, this.urlP, this.img);
    this.proyectoS.save(proyecto).subscribe(
      data=>{
        alert("Proyecto añadido exitosamente!!");
        this.router.navigate(['']);
      }, err=>{
        alert("Falló!!");
        this.router.navigate(['']);
      }
    )
  }
}
