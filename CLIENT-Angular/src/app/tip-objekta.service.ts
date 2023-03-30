import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TipObjektaService {

  constructor(private http: HttpClient) { }

  API = 'http://localhost:8080/tipObjekta'

  dodajTipObjekta(tip: any){
    this.postTipObjekta(tip).subscribe(()=>
    console.log("tip objekta dodat"))
  }

  postTipObjekta(tip:any){
    return this.http.post(this.API+'/postTipObjekta', tip);
  }

}
