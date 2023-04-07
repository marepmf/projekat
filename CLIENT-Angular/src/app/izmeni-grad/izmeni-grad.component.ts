import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CountryServiceService } from '../country-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CitiesService } from '../cities.service';

@Component({
  selector: 'app-izmeni-grad',
  templateUrl: './izmeni-grad.component.html',
  styleUrls: ['./izmeni-grad.component.css']
})
export class IzmeniGradComponent implements OnInit {

  constructor(private countryService: CountryServiceService , private router: Router,
     private cityService: CitiesService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.countryService.getAllCountries().subscribe((data:any)=>{this.Countries = data}); 
    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('element.id')
      }
    );
    console.log(this.id);
    
  }

  

  id: any;
  Countries: any;
  

  formControl = new FormGroup({
    naziv: new FormControl(''),
    opstina : new FormControl(''),
    country : new FormControl('')
  }
  )

  izmeni(){
    var grad = {
      naziv: this.formControl.value.naziv,
      opstina: this.formControl.value.opstina,
      country: this.formControl.value.country
    }

    
    this.cityService.izmeniGrad(this.id,grad.naziv,grad.opstina,grad.country);
    this.idiNazad();
  }

  idiNazad(){
    this.router.navigate(['adminEntityView'])
  }

}
