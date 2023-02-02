import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AcercaDe } from '../model/acerca-de';

@Injectable({
  providedIn: 'root'
})
export class AcercaDeService {

  URL='http://campodom.us-east-1.elasticbeanstalk.com/acercaDe/'
  //URL='http://localhost:8080/acercaDe/'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<AcercaDe[]>{
    return this.httpClient.get<AcercaDe[]>(this.URL + 'lista');
   }
   public detail(id: number): Observable<AcercaDe>{
    return this.httpClient.get<AcercaDe>(this.URL + `detail/${id}`);
   }
   public traerInformacion(): Observable<Boolean>{
    return this.httpClient.get<Boolean>(this.URL + 'hayinfo');
   }
   public save(educacion: AcercaDe): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', educacion);
   }
   public update(id: number, educacion: AcercaDe): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, educacion);
   }
   public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
   }
}
