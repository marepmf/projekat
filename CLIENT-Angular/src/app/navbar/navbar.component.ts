import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';


@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private route:Router , private userService: UserService) { }

  isUserLogged(){
    return this.userService.isLoggedUserBasicUser();
  }
  isAdminLogged(){
    return this.userService.isLoggedUserAdmin();
  }

  goToLogin(){
    this.route.navigate(['login']);
  }
  goToHomePage(){
    this.route.navigate(['/']);
  }
  goToUser(){
    this.route.navigate(['user']);
  }

  goToRegistration(){
    this.route.navigate(["registration"])
  }
  goToAdminPanel(){
    this.route.navigate(["adminPanel"])
  }
  goToAdminEntityView(){
    
    this.route.navigate(["adminEntityView"])
  }
  goToEventsPage(){
    this.route.navigate(["events"]);
  }

  logout(){
    this.userService.logOut();
  }

  goToDodajEntitet(){
    this.route.navigate(["dodajEntitet"]);
  }

  ngOnInit(): void {
  }

  

}
