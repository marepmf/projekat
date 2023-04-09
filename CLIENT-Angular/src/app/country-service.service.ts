import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CountryServiceService {
API= 'http://localhost:8080/drzave';
  constructor(private http: HttpClient) { }

  Countries: any;

  getPropertyColumns() {
    return ['id', 'naziv','brisi','izmeni'];
  }
  getFullColumns() {
    return [
    { property: "id", display: "Sifra" },
    { property: 'naziv', display: "Naziv" }]
  }

  addCountry(country: any){
    this.postDrzava(country).subscribe(()=>{
      console.log("drzava dodata");
    });
  }
  getAllCountries():any{
    return this.http.get(this.API+'/sve');
  }
  deleteCountryByID( id : any){
    return this.http.delete (this.API + '/izbrisi/' + id);
  }

  getCountryById(id: any){
    return this.http.get(this.API +"/nadji/"+ id);
  }

  postDrzava(country: any){
    return this.http.post(this.API+ '/postDrzava/',country);
  }

  izmeniDrzavu(country: any,id:any){
    return this.http.put(this.API+ '/izmena/'+id, country).subscribe();
  }

}
