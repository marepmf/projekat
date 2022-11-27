import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputData = new FormGroup({
    firstName: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private route:Router, private userService : UserService ) { }
  
  login_message = "";

  ngOnInit( ): void {
  }
  login() {
    let user = {
      "username": this.inputData.controls.firstName.value,
      "password": this.inputData.controls.password.value,
      
    }
    console.log(user);
    for (var el of this.userService.USERS) {
      if (el.name == user.username || el.email == user.username && el.password == user.password) {
        this.login_message = "Ima takvog korisnika";
        this.userService.loginUser(el);
        if(el.role == "User")
        this.goToHomePage();
       // if(el.role=="Admin")
        else this.goToAdminPage();
      }
      else
        this.login_message = "Nema takvog korisnika";
    }
    // FOREACH KAO LAMBDA FUKCIJA
    // this.users.forEach( el =>{
    //   if( el.name == user.name && el.password == user.password){
    //     console.log("ima takav korisnik");
    //   }
    // })
  }

  goToHomePage(){
    this.route.navigate(['/']);
  }
  goToAdminPage(){
    this.route.navigate(['adminPanel']);
    
  }
}
