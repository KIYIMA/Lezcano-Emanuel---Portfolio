import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AcercaDe } from 'src/app/model/acerca-de';
import { AcercaDeService } from 'src/app/service/acerca-de.service';


@Component({
  selector: 'app-new-acerca-de',
  templateUrl: './new-acerca-de.component.html',
  styleUrls: ['./new-acerca-de.component.css']
})
export class NewAcercaDeComponent implements OnInit {

  profecion: string;
  descripcion: string;

  constructor(private acercaDeS: AcercaDeService, private router: Router ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const acercaDe = new AcercaDe(this.profecion, this.descripcion);
    this.acercaDeS.save(acercaDe).subscribe(
      data=>{
        alert("Iformacion añadida!!");
        this.router.navigate(['']);
      }, err=>{
        alert("Fallo");
        this.router.navigate(['']);
      }
    )
  }
}
