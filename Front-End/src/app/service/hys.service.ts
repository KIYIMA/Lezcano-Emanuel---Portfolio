import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HysModel } from '../model/hysModel';

@Injectable({
  providedIn: 'root'
})
export class HysService {

  URL = 'http://campodom.us-east-1.elasticbeanstalk.com/hys/';
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<HysModel[]>{
    return this.httpClient.get<HysModel[]>(this.URL + 'lista');
   }
   public detail(id: number): Observable<HysModel>{
    return this.httpClient.get<HysModel>(this.URL + `detail/${id}`);
   }
   public save(hyS: HysModel): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', hyS);
   }
   public update(id: number, hyS: HysModel): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, hyS);
   }
   public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
   }
}
