import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contacto } from '../model/contacto';

@Injectable({
  providedIn: 'root'
})
export class ContactoService {

  URL = 'http://campodom.us-east-1.elasticbeanstalk.com/contacto/';
  constructor(private httpClient: HttpClient) { 

  }

  public save(contactoS: Contacto): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'send', contactoS);
   }
}
