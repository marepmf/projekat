import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ObjavaService {

  constructor(private http: HttpClient) { }

  API = 'http://localhost:8080/objava'

  dodajObjavu(objava: any){
    this.postObjava(objava).subscribe(()=>
    console.log('objava dodata')
    )
  }

  postObjava(objava:any){
    return this.http.post(this.API+'/postObjava', objava);
  }

}
