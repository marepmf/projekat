import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventService } from '../event.service';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  constructor(private route: ActivatedRoute, private eventService: EventService) { }
CURRENT_EVENT:any;
  ngOnInit(): void {

    this.route.paramMap.subscribe(
      (id: any) => {
        console.log(id);
      this.eventService.getEventById(id.get('id')).subscribe( data =>{
        this.CURRENT_EVENT= data;
      })
      }
    ); 
      
    
  
  }

}
