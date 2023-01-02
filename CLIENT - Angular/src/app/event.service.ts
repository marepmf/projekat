import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EventService {


  constructor(private http: HttpClient) { }

  API = 'http://localhost:8080/dogadjaj';

  getAllEvent(){
    return this.http.get(this.API + "/sve");
  }
  getPostsForEventById( id: number){
    return this.http.get("http://localhost:8080/objava/za_dogadjaj/" + id)
  }
  getEventById(id: any) {
    return this.http.get(this.API + "/nesto/" + id);
  }
  addComment( tekst:string, objava: any){
    
    return this.http.post("http://localhost:8080/objava/dodaj_komentar/" +objava.id, tekst);
  }
}
