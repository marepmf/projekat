import { Component, OnInit } from '@angular/core';
import { throwToolbarMixedModesError } from '@angular/material/toolbar';
import { Router } from '@angular/router';
import { EventService } from '../event.service';
import { ImageService } from '../image.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  constructor(private route: Router,
              private userService : UserService,
              private eventService: EventService,
              private imageService: ImageService) { }
  EVENTS:any;
  ngOnInit(): void {
    this.eventService.getAllEvent().subscribe(data => {
      this.EVENTS  = data;
    })
  }
  selectedFile:any;
  onFileChanged(event:any) {
    this.selectedFile = event.target.files[0]
  }
  
  isAdmin(){
    return this.userService.isLoggedUserAdmin();
  }
  onUpload() {
   this.imageService.upolaodImage(this.selectedFile);
  }
  // goToEventPage(id:any){
  //     this.route.navigate(['event',[id]]);
    
  // }
}
