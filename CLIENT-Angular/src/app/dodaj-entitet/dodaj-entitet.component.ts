import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, NgForm } from '@angular/forms';
import { CitiesService } from '../cities.service';
import { CountryServiceService } from '../country-service.service';

@Component({
  selector: 'app-dodaj-entitet',
  templateUrl: './dodaj-entitet.component.html',
  styleUrls: ['./dodaj-entitet.component.css']
})
export class DodajEntitetComponent implements OnInit {


  

  constructor(private route: Router ){}
  ngOnInit(): void {
   

  }
 
  dodajKomentar(){
    this.route.navigate(["dodajKomentar"]);
  }

  dodajDrzavu(){
    this.route.navigate(["dodajDrzavu"])
  }

  dodajObjekat(){
    this.route.navigate(['dodajObjekat'])
  }

  dodajObjavu(){
    this.route.navigate(['dodajObjavu'])
  }

  dodajTipObjekta(){
    this.route.navigate(['dodajTipObjekta'])
  }
  dodajGrad(){
    this.route.navigate(['dodajGrad'])
  }

}
