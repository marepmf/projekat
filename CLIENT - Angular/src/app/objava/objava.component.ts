import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObjavaService } from '../objava.service';
import { FormControl, FormGroup } from '@angular/forms';
import { getLocaleTimeFormat } from '@angular/common';

@Component({
  selector: 'app-objava',
  templateUrl: './objava.component.html',
  styleUrls: ['./objava.component.css']
})
export class ObjavaComponent implements OnInit {

  constructor(private service: ObjavaService , private router: Router) { }

  ngOnInit(): void {
  }

  create(){
    var time = new Date();
    var objava = {tekst: this.formControl.value.tekst ,
                  naslov: this.formControl.value.naslov ,
                  vreme: time.toString()}
    // this.service.dodajObjavu(objava);
    console.log(objava);
  }

  idiNazad(){
    this.router.navigate(['dodajEntitet'])
  }

  formControl = new FormGroup({
    tekst: new FormControl(''),
    naslov: new FormControl(''),
    
  })


}


