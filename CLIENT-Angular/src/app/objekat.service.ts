import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ObjekatService {

  constructor(private http: HttpClient) { }

  getPropertyColumns() {
    return ['id', 'naziv','grad','tipObjekta','brisi','izmeni'];
  }
  

  getFullColumns() {
    return [
    { property: "id", display: "Sifra"},
    { property: "naziv", display: "Naziv"},
    { property: "grad", display: "Grad"},
    { property: 'tipObjekta', display: "Tip objekta" }];
  }

  API_object= 'http://localhost:8080/objekat';
  API_type_object= 'http://localhost:8080/tipObjekta';

  getObjekte():any{
    return this.http.get(this.API_object + '/sve');
  }

  getTipObjekta(){
    return this.http.get(this.API_type_object + '/sve');
  }

  dodajObjekat(objekat: any){
    this.postObjekat(objekat).subscribe(()=>
    console.log("objekat dodat"));
  }

  postObjekat(objekat: any){
    return this.http.post(this.API_object + '/postObjekat', objekat)
  }

  

  
}
