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
  
  getEventById(id: any) {
    return this.http.get(this.API + "/nesto/" + id);
  }
}
