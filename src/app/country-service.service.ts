import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CountryServiceService {
API= 'http://localhost:8080/drzave';
  COUNTRY = [{'id':"436546", 'name':"23wwraf"}]
  constructor(private http: HttpClient) { }


  getPropertyColumns() {
    return ['id', 'nazivDrzave','brisi','izmeni'];
  }
  getFullColumns() {
    return [{ property: "id", display: "Sifra" },
    { property: 'nazivDrzave', display: "Naziv" }]
  }

  addCountry(country: any){
    this.COUNTRY.push(country);
    this.postDrzava(country).subscribe(()=>{
      console.log("drzava dodata");
    });
  }
  getAllCountries():any{
    return this.http.get(this.API+'/sve');
  }
  deleteCountryByID( id : any){
    var index = this.COUNTRY.findIndex(el => { return el.id === id});
    this.COUNTRY.splice( index,1);
    console.log(this.COUNTRY);
  }

  dodeliId(){
    return this.COUNTRY.length+1;
  }

  postDrzava(country: any){
    return this.http.post(this.API+ '/postDrzava', country);
  }

}
