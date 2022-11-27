import { Component, OnInit } from '@angular/core';
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

  constructor(private userService: UserService) {
    this.rezultat = userService.USERS;
    this.statusLogovanja = this.userService.isUserLogged;
  }

  ngOnInit(): void {
  }

}
