import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ObjekatService {

  constructor(private http: HttpClient) { }

  API_object= 'http://localhost:8080/objekat';
  API_type_object= 'http://localhost:8080/tipObjekta';
  getObjekte(){
    return this.http.get(this.API_object + '/sve');
  }
  getTipObjekta(){
    return this.http.get(this.API_type_object + '/sve');
  }
  dodajObjekat(objekat: any){
    this.postObjekat(objekat).subscribe(()=>
    console.log("objekat dodat"))
  }
  postObjekat(objekat: any){
    return this.http.post(this.API_object + '/postObjekat', objekat)
  }

  
}
