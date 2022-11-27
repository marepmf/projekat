import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CitiesService } from '../cities.service';
import { CountryServiceService } from '../country-service.service';

@Component({
  selector: 'app-dodaj-grad',
  templateUrl: './dodaj-grad.component.html',
  styleUrls: ['./dodaj-grad.component.css']
})
export class DodajGradComponent implements OnInit {

  constructor(private router :Router, private citiesService: CitiesService, private countryService: CountryServiceService) { }  
  Countries :any;
  formControl = new FormGroup({
    naziv: new FormControl(''),
    opstina : new FormControl(''),
    country : new FormControl('')
  })


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
  
  idiNazad(){
    this.router.navigate(["dodajEntitet"]);
  }

}
