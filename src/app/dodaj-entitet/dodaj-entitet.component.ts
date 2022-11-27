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

  Countries :any;
  
  formControl = new FormGroup({
    naziv: new FormControl(''),
    opstina : new FormControl(''),
    country : new FormControl('')
  })

  constructor(private route: Router , private citiesService: CitiesService, private countryService: CountryServiceService) { }  

  ngOnInit(): void {
    this.countryService.getAllCountries().subscribe((data:any)=>{this.Countries = data});

  }
  create(){
    var city ={
      naziv: this.formControl.value.naziv,
      opstina : this.formControl.value.opstina,
      country: this.formControl.value.country
    }
    this.citiesService.addCity(city);
    console.log("entitet je kreiran : " + city.naziv);
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

}
