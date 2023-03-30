import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { EventService } from '../event.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  constructor(private route: ActivatedRoute, private eventService: EventService, private userService: UserService) { }
  
  CURRENT_EVENT: any;
  komentar: string = '';

  dodajKOmentar(objava: any) {
    this.eventService.addComment(this.komentar, objava).subscribe();
  }
  objavaForm = new FormGroup({
    naziv: new FormControl(''),
    tekst: new FormControl(''),
    vreme : new FormControl('')
  })
  dodajObjavu() {
    var objava = {
      naslov: this.objavaForm.value.naziv,
      tekst: this.objavaForm.value.tekst,
      vreme: this.objavaForm.value.vreme,
      autor: this.userService.loggedUser,
      dogadjaj: this.CURRENT_EVENT.id
    }
    
    this.eventService.postObjavu(objava).subscribe( data=>{
      console.log(data); 
      this.CURRENT_EVENT = data;
    });
  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(
      (id: any) => {        
        this.eventService.getEventById(id.get('id')).subscribe(data => {
          this.CURRENT_EVENT = data;
        })
      }
    );
  }
  isUserLogged() {
    return this.userService.isUserLogged;
  }
}
