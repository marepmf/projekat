import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  
  constructor(private userService: UserService, private route:Router) { }

  ngOnInit(): void {
  }

  inputData = new FormGroup({
    firstName: new FormControl(''),
    surname: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    password1: new FormControl('')
  });
  showHidePassword(event: any) {
    console.log(event)
    if (event.checked == true) {
      this.passwordType = "text";
      this.password_status = "Hide password";
    }
    else {
      this.password_status = "Show password";
      this.passwordType = "password";
    }
  }

  registration() {
    if (this.inputData.controls.password.value == this.inputData.controls.password1.value) {
      if (this.userService
  .isUsersAvailable(this.inputData.controls.firstName.value))
        this.userService
  .addUser({
          id: 0,
          name: this.inputData.controls.firstName.value,
          email: this.inputData.controls.email.value,
          surname: this.inputData.controls.surname.value,
          password: this.inputData.controls.password.value
          
        });
        this.goToHomePage();
    }
    else {
      console.log("greska");
    }
    
    console.log(this.userService
.USERS);
  }
  password_status = "Show passwords";
  passwordType = "password";
  registration_message = "neki text";

  
  goToHomePage(){
    this.route.navigate(['/']);
  }
  

}
