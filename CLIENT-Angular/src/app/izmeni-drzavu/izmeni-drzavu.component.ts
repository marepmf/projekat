import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CountryServiceService } from '../country-service.service';

@Component({
  selector: 'app-izmeni-drzavu',
  templateUrl: './izmeni-drzavu.component.html',
  styleUrls: ['./izmeni-drzavu.component.css']
})
export class IzmeniDrzavuComponent implements OnInit {

  constructor(private router: Router, private countryservice: CountryServiceService
    ,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(
      params => { this.id = params.get('element.id')}
    );
    console.log(this.id);
  }

  id: any;

  formControl = new FormGroup({
    naziv : new FormControl('')
  })

  izmeni(){
    var drzava = {
      naziv: this.formControl.value.naziv
    }
    this.countryservice.izmeniDrzavu(drzava,this.id);
    this.idiNazad();
  }

  idiNazad(){
    this.router.navigate(['adminEntityView']);
  }

}
