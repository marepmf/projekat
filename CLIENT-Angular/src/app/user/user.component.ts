import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'email', "surname"];
  rezultat: any;
  public statusLogovanja: any;

  constructor(private userService: UserService, private router :Router) {
    
    //this.statusLogovanja = this.userService.isUserLogged;
    //console.log(this.router.getCurrentNavigation());
  }

  ngOnInit(): void {
    
  }

}
