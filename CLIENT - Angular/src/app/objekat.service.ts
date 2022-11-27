import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ObjekatService {

  constructor(private http: HttpClient) { }

  API= 'http://localhost:8080/objekat';


  postObjekat(objekat: any){
    return this.http.post(this.API + '/postObjekat', objekat)
  }

  dodajObjekat(objekat: any){
    this.postObjekat(objekat).subscribe(()=>
    console.log("objekat dodat"))
  }
}
