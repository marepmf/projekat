import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { KomentarServiceService } from '../komentar-service.service';
@Component({
  selector: 'app-dodaj-komentar',
  templateUrl: './dodaj-komentar.component.html',
  styleUrls: ['./dodaj-komentar.component.css']
})
export class DodajKomentarComponent implements OnInit {

  constructor(private ks: KomentarServiceService , private router: Router) { }

  ngOnInit(): void {
  }

  

  formControl = new FormGroup({
    tekst: new FormControl(''),
    vreme : new FormControl(''),
    lajkovi : new FormControl('')
  })

  create(){
    var komentar = { //id: this.ks.dodeliId(),
                     tekst: this.formControl.value.tekst ,
                     vreme: this.formControl.value.vreme ,
                     lajkovi: this.formControl.value.lajkovi
                    }
    this.ks.dodajKomentar(komentar);
    console.log(komentar);
  }

  idiNazad(){
    this.router.navigate(["dodajEntitet"]);
  }

}
