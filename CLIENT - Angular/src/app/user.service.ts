import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public USERS = [
    { id: "0", name: "Admin", email: "", password: "admin", role: "Admin" },
    { id: "1", name: "Ana", email: "Anaperic123@gmail.com", surname: "Peric", password: "123", role: "User" }
  ];
  loggedUser: any; // ulogovani korisnik/admin
  isUserLogged = false;

  constructor(private http: HttpClient) { }

  API= 'localhost:8080/korisnici';

  loginUser(user: any) {
    this.loggedUser = user;
    if (this.loggedUser != null)
      this.isUserLogged = true;
  }
  isLoggedUserAdmin() {
    if (this.isUserLogged)
      if (this.loggedUser.role == "Admin")
        return true;

    return false;
  }

  isUsersAvailable(user: any) {
    var available = true;
    this.USERS.forEach(element => {
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
    this.USERS.push(user);
  }

  getKorisnici(){
    this.http.get(this.API + '/sve');
  }

  getPropertyColumns(){
    return ['id','name','email','surname','password','role','brisi','izmeni']
  }
  getFullColumns() {
    return [
    { property: 'id'      , display: 'Sifra '},
    { property: 'name'    , display: 'Naziv grada ' },
    { property: 'email'   , display: 'Elektronska adresa' },
    { property: 'surname' , display: "Prezime" }, 
    { property: 'password', display: "Sifra" },
    { property: 'role'    , display: "Tip korisnika" }];
  }

  deleteUserByID(element:any){
    var index = this.USERS.findIndex(el => { return el.id === element.id});
    this.USERS.splice( index,1);
    console.log(this.USERS);
  }

  

}
