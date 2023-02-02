import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HysModel } from 'src/app/model/hysModel';
import { HysService } from 'src/app/service/hys.service';

@Component({
  selector: 'app-edit-hy-s',
  templateUrl: './edit-hy-s.component.html',
  styleUrls: ['./edit-hy-s.component.css']
})
export class EditHySComponent implements OnInit {

  hySModel: HysModel = null;

  constructor(private hySService: HysService, private activatedRouter:
    ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.hySService.detail(id).subscribe(
      data=>{
        this.hySModel= data;
      },err=>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }
  onUpdate(){
    const id = this.activatedRouter.snapshot.params['id'];
    this.hySService.update(id, this.hySModel).subscribe(
      data=>{
        this.router.navigate(['']);
      }, err=>{
        alert("Error al modificar!!!");
        this.router.navigate(['']);
      }
    )
  }

}
