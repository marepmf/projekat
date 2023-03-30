import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public USERS: any = [
  ];
  loggedUser: any; // ulogovani korisnik/admin
  isUserLogged = false;

  constructor(private http: HttpClient, private route: Router) { }

  API = 'localhost:8080/korisnici';

  error_message =""
  loginUser(user: any) {
    return this.http.post("http://localhost:8080/korisnici/login", user);
  }

  isLoggedUserBasicUser() {

    if (this.isUserLogged)
      if (this.loggedUser.tip.id == 2)
        return true;

    return false;
  }
  isLoggedUserAdmin() {
    if (this.isUserLogged)
      if (this.loggedUser.tip.id == 1)
        return true;

    return false;
  }

  isUsersAvailable(user: any) {
    var available = true;
    this.USERS.forEach((element: any) => {
      if (element.name == user) {
        available = false;
      }
    });
    return available;
  }
  logOut() {
    this.isUserLogged = false;
    this.loggedUser = null;

  }
  addUser(user: any) {
    this.http.post("http://localhost:8080/korisnici/dodaj", user).subscribe();
  }

  getKorisnici() {
    this.http.get(this.API + '/sve');
  }

  getPropertyColumns() {
    return ['id', 'name', 'email', 'surname', 'password', 'role', 'brisi', 'izmeni']
  }
  getFullColumns() {
    return [
      { property: 'id', display: 'Sifra ' },
      { property: 'name', display: 'Naziv grada ' },
      { property: 'email', display: 'Elektronska adresa' },
      { property: 'surname', display: "Prezime" },
      { property: 'password', display: "Sifra" },
      { property: 'role', display: "Tip korisnika" }];
  }

  deleteUserByID(element: any) {
    var index = this.USERS.findIndex((el: any) => { return el.id === element.id });
    this.USERS.splice(index, 1);
    console.log(this.USERS);
  }



}
