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
    return ['id', 'naziv','opstina','drzava','brisi','izmeni'];
  }
  
  getFullColumns() {
    return [
    { property: "id", display: "Sifra"},
    { property: "opstina", display: "Opstina"},
    { property: "drzava", display: "Drzava"},
    { property: 'naziv', display: "Naziv" }];
  }

  getAllCities(){
    return this.http.get(this.API+"/sve");
  }

  deleteCityByID( id : any){
    //var index = this.CITIES.findIndex(el => { return el.id === id});
    //this.CITIES.splice( index,1);
    //this.http.delete(this.API+"'' maping za delte)
  }

  addCity(city: any){
    
    this.postGrad(city).subscribe(()=>{
      console.log("citu added" );
    }); 
  
  }

 

  postGrad(grad: any){
    return this.http.post(this.API + '/postGrad',grad);
  }

}