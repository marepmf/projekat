import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CitiesService } from '../cities.service';
import { ObjekatService } from '../objekat.service';
@Component({
  selector: 'app-objekat',
  templateUrl: './objekat.component.html',
  styleUrls: ['./objekat.component.css']
})
export class ObjekatComponent implements OnInit {

  constructor(private router: Router, private service: ObjekatService, private cityService: CitiesService) { }
  objectTypes: any;
  cities: any;

  formControl = new FormGroup({
    naziv: new FormControl(''),
    tip: new FormControl(''),
    grad: new FormControl('')
  })
  ngOnInit(): void {
    this.service.getTipObjekta().subscribe(data => this.objectTypes = data);
    this.cityService.getAllCities().subscribe((data: any) => this.cities = data);

  }

  create() {
    var objekat = {
      naziv: this.formControl.value.naziv,
      tip: this.formControl.value.tip,
      grad: this.formControl.value.grad
    };
    this.service.dodajObjekat(objekat);
    console.log(objekat);
  }

  idiNazad() {
    this.router.navigate(['dodajEntitet'])
  }


}
