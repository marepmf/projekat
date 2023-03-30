import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class KomentarServiceService {

  constructor(private http: HttpClient) { }

  API= 'http://localhost:8080/komentar';
  
  

  KOMENTAR = [{ id: "1", tekst: "asdasdasdasdasdasdasd", vreme: "18:00", lajkovi: "2" },
              { id: "2", tekst: "dsada", vreme: "12:00", lajkovi: "50"}]
  

  dodajKomentar(komentar: any){
    this.postKomentar(komentar).subscribe(()=>{
      console.log("komentar dodat");
    });
  }
  
 

  dodeliId(){
    return this.KOMENTAR.length+1;
  }

  postKomentar(komentar: any){
    return this.http.post(this.API + '/postKomentar', komentar);
  }

}
