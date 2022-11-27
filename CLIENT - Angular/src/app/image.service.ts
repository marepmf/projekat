import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
API = 'http://localhost:8080/slike/'
  constructor(private http:HttpClient) { }
  upolaodImage(file:string) {
   
    this.http.post(this.API, file)
      .subscribe(()=>{});
  }
}
