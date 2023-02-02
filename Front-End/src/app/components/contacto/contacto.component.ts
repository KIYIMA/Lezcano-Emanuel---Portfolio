import { formatCurrency } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { from } from 'rxjs';
import { Contacto } from 'src/app/model/contacto';
import { ContactoService } from 'src/app/service/contacto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {


  email!: string;
  asunto!: string;
  cuerpo!: string;
  ngModel!: any;
  miFormulario: FormGroup;


  constructor(private contactoSer: ContactoService, private activatedRouter:
    ActivatedRoute, private router: Router, private builder: FormBuilder) {
    this.miFormulario = this.builder.group({
      emailinput: ['', Validators.compose([Validators.email, Validators.required])],
      asuntoinput: ['', Validators.compose([Validators.minLength(5), Validators.maxLength(15), Validators.required])],
      descripcioninput: ['', Validators.compose([Validators.minLength(5), Validators.required])]
    })
  }

  ngOnInit(): void {

  }

  onCreate(): void {
    if (this.miFormulario.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Error de validación !',
        text: 'Por favor verifica los datos ingresados !!!'
      })
    } else {

      const email = new Contacto(this.email, this.asunto, this.cuerpo);
      Swal.fire(
        'Enviado !!!',
        'Gracias por contactarte!',
        'success'
      );
      this.miFormulario.reset();
      this.contactoSer.save(email).subscribe(
        data => {
          console.log("Email enviado!");
        }, err => {
          Swal.fire({
            icon: 'error',
            title: 'Error al enviar !!!',
            text: 'Error por parte del servidor !!!',
            
          })
        }
      )
    }
  }


}
