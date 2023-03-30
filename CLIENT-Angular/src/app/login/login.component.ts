import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { throwToolbarMixedModesError } from '@angular/material/toolbar';
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
    this.login_message = this.userService.error_message;
  }
  login() {
    let user = {
      "username": this.inputData.controls.firstName.value,
      "password": this.inputData.controls.password.value,
      
    }
   this.userService.loginUser(user).subscribe((data)=>{    
      if (data != null) {
        this.userService.loggedUser = data;
        this.userService.isUserLogged = true;
        console.log(data);
        if (this.userService.loggedUser.tip.id == 2)
          this.route.navigateByUrl('/', { state: { data: "Dobro dosli korisnice :)" } });
        if (this.userService.loggedUser.tip.id == 1)
          this.route.navigate(['/adminPanel']);
      }
      else {
        this.userService.loggedUser = null;
        console.log("Neuspela prijava.");
        this.login_message = "Neuspela prijava";
      }
 
      });
    }
   
  

  goToHomePage(){
    this.route.navigate(['/']);
  }
  goToAdminPage(){
    this.route.navigate(['adminPanel']);
    
  }
}
