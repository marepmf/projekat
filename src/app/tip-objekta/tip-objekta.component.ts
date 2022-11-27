import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TipObjektaService } from '../tip-objekta.service';

@Component({
  selector: 'app-tip-objekta',
  templateUrl: './tip-objekta.component.html',
  styleUrls: ['./tip-objekta.component.css']
})
export class TipObjektaComponent implements OnInit {

  constructor(private router: Router , private service: TipObjektaService) { }

  ngOnInit(): void {
  }

  formControl = new FormGroup({
    tip: new FormControl('')
  })

  create(){
    var tipObjekta = {tip: this.formControl.value.tip } ;
    this.service.dodajTipObjekta(tipObjekta);
    console.log(tipObjekta);
  }

  idiNazad(){
    this.router.navigate(['dodajEntitet'])
  }

}
