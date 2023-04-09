import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CitiesService{

  CITIES:any;

  constructor(private http: HttpClient) { }

  API= 'http://localhost:8080/gradovi';

  getPropertyColumns() {
    return ['id', 'naziv','opstina','drzavaNaziv','brisi','izmeni'];
  }
  
  getFullColumns() {
    return [
    { property: "id", display: "Sifra"},
    { property: "opstina", display: "Opstina"},
    { property: "drzavaNaziv", display: "Drzava"},
    { property: 'naziv', display: "Naziv" }];
  }

  getAllCities() :any{
    return this.http.get(this.API+"/sve");
  }

  deleteCityByID( id : any){
    return this.http.delete(this.API+"/izbrisi/"+id,id).subscribe(
      ()=> console.log("obrisan grad sa id-jem : " + id)
    )
  }

  addCity(city: any){
    
    this.postGrad(city).subscribe(()=>{
      console.log("city added" );
    }); 
  
  }

  izmeniGrad(id:number,naziv:any,opstina:any,drzava:any){
    this.changeCity(id,naziv,opstina,drzava).subscribe(
      () => {
        console.log("grad izmenjen", id);
      }
    )
  }

  changeCity(id:number, naziv:any,opstina:any,drzava:any){
    return this.http.put(this.API+"/izmena/"+id+"/"+naziv+"/"+opstina,drzava);
  }

 

  postGrad(city: any){
    return this.http.post(this.API + '/postGrad',city);
  }

  
}