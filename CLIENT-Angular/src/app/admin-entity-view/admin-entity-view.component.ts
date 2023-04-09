import { Component, OnInit } from '@angular/core';
import { CitiesService } from '../cities.service';
import { CountryServiceService } from '../country-service.service';
import { UserService } from '../user.service';
import { Router, RouterModule } from '@angular/router';
import { ObjekatService } from '../objekat.service';

@Component({
  selector: 'app-admin-entity-view',
  templateUrl: './admin-entity-view.component.html',
  styleUrls: ['./admin-entity-view.component.css']
})
export class AdminEntityViewComponent implements OnInit {

  constructor(private citiesService: CitiesService, 
                private userService :UserService,
                private countryService: CountryServiceService,
                private objekatService: ObjekatService,
                private router: Router) { }
  selectedEntity:any;
  dataSource :any;
  displayedColumns:any;
  displayPropertyColumns:any;
  entity_list = ['Gradovi', 'Korisnici','Drzave','Objekti'];
  
  
  showEntity(){
    console.log(this.selectedEntity);
   
    if(this.selectedEntity=='Gradovi')
      this.showCities();
    if(this.selectedEntity=='Korisnici')
      this.showUsers();
    if(this.selectedEntity == 'Drzave')
      this.showCountries();
    if(this.selectedEntity== 'Objekti')
      this.showObjects();
      
      console.log(this.displayedColumns)
  }
  showCities(){
    this.citiesService.getAllCities().subscribe((data :any)=>{
      this.citiesService.CITIES = data;
      console.log(data);
      this.displayedColumns = this.citiesService.getFullColumns();
      this.displayPropertyColumns = this.citiesService.getPropertyColumns();      
      this.dataSource = this.citiesService.CITIES;
  })
  }
  showUsers(){
    this.displayedColumns = this.userService.getFullColumns();
    this.displayPropertyColumns = this.userService.getPropertyColumns();
    this.dataSource = this.userService.getKorisnici();
  }
  showCountries(){
    this.displayedColumns = this.countryService.getFullColumns();
    this.displayPropertyColumns = this.countryService.getPropertyColumns();
    this.dataSource = this.countryService.getAllCountries();
  }
  showObjects(){
    this.displayedColumns = this.objekatService.getFullColumns();
    this.displayPropertyColumns = this.objekatService.getPropertyColumns();
    this.dataSource = this.objekatService.getObjekte();
  }
  deleteRow(target : any){
    if(this.selectedEntity=='Gradovi'){
      this.citiesService.deleteCityByID(target.id);
      this.dataSource = this.dataSource.filter( (x:any)=> x.id !== target.id);
    }
    if(this.selectedEntity=='Korisnici'){
      this.userService.deleteUserByID(target.id);
      this.dataSource = this.dataSource.filter( (x:any)=> x.id !== target.id);
    }
    if(this.selectedEntity=='Drzave'){
      this.countryService.deleteCountryByID(target.id);
      this.dataSource = this.dataSource.filter( (x:any)=> x.id !== target.id);
    }
 
  }

  changeRow(target : any){
    if(this.selectedEntity=='Gradovi'){
      this.router.navigate(['izmeniGrad/'+target.id])
    }
    if(this.selectedEntity=='Drzave'){
      this.router.navigate(['izmeniDrzavu/'+target.id])
    }
  }

  ngOnInit(): void {
  }

}
