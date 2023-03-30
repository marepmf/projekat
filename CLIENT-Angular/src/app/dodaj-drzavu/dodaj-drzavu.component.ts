import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CountryServiceService } from '../country-service.service';
import { FormGroup, FormControl, NgForm } from '@angular/forms';
import { CitiesService } from '../cities.service';

@Component({
  selector: 'app-dodaj-drzavu',
  templateUrl: './dodaj-drzavu.component.html',
  styleUrls: ['./dodaj-drzavu.component.css']
})
export class DodajDrzavuComponent implements OnInit {

  constructor(private router: Router , private countryService: CountryServiceService , private cityservice: CitiesService) { }

  ngOnInit(): void {
    this.cityservice.getAllCities().subscribe((data:any)=>{this.Gradovi = data});
  }

  Gradovi: any;

  formControl = new FormGroup({
    naziv: new FormControl(''),
    gradovi: new FormControl('')
  })

  create(){
    var drzava = {
      naziv: this.formControl.value.naziv,
      gradovi: this.formControl.value.gradovi
    }
    console.log(drzava);
    this.countryService.addCountry(drzava)
  }

  idiNazad(){
    this.router.navigate(["dodajEntitet"]);
  }

}
