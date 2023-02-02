import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AcercaDe } from 'src/app/model/acerca-de';
import { AcercaDeService } from 'src/app/service/acerca-de.service';

@Component({
  selector: 'app-edit-acerca-de',
  templateUrl: './edit-acerca-de.component.html',
  styleUrls: ['./edit-acerca-de.component.css']
})
export class EditAcercaDeComponent implements OnInit {

  acercaDe: AcercaDe = null;
  constructor(private acercaDeS: AcercaDeService, private activatedRouter:
    ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.acercaDeS.detail(id).subscribe(
      data=>{
        this.acercaDe= data;
      },err=>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }
  onUpdate(){
    const id = this.activatedRouter.snapshot.params['id'];
    this.acercaDeS.update(id, this.acercaDe).subscribe(
      data=>{
        this.router.navigate(['']);
      }, err=>{
        alert("Error al modificar!!!");
        this.router.navigate(['']);
      }
    )
  }

}
