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

  constructor(private userService: UserService, private route: Router) { }

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
    console.log( this.inputData);
    if (this.inputData.value.password == this.inputData.value.password1) {
      if (this.userService
        .isUsersAvailable(this.inputData.value.firstName))
        this.userService
          .addUser({
            // id: 0,
            ime: this.inputData.value.firstName,
            email: this.inputData.value.email,
            prezime: this.inputData.value.surname,
            sifra: this.inputData.value.password

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
  registration_message = "";


  goToHomePage() {
    this.route.navigate(['/']);
  }


}
