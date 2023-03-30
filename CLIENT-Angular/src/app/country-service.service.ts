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
    return [{ property: "id", display: "Sifra" },
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
    this.http.delete (this.API + '/izbrisi/' + id);
  }

  postDrzava(country: any){
    return this.http.post(this.API+ '/postDrzava', country);
  }

}
