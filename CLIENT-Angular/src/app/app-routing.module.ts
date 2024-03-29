import { PrefixNot } from '@angular/compiler';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminEntityViewComponent } from './admin-entity-view/admin-entity-view.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { DodajDrzavuComponent } from './dodaj-drzavu/dodaj-drzavu.component';
import { DodajEntitetComponent } from './dodaj-entitet/dodaj-entitet.component';
import { DodajGradComponent } from './dodaj-grad/dodaj-grad.component';
import { DodajKomentarComponent } from './dodaj-komentar/dodaj-komentar.component';
import { EventComponent } from './event/event.component';
import { LoginComponent } from './login/login.component';
import { ObjavaComponent } from './objava/objava.component';
import { ObjekatComponent } from './objekat/objekat.component';
import { RegistrationComponent } from './registration/registration.component';
import { TipObjektaComponent } from './tip-objekta/tip-objekta.component';
import { UserComponent } from './user/user.component';
import { IzmeniGradComponent } from './izmeni-grad/izmeni-grad.component';
import { IzmeniDrzavuComponent } from './izmeni-drzavu/izmeni-drzavu.component';


const routes: Routes = [
  {path:'user' , component: UserComponent, data:{}},
  {path:'login', component: LoginComponent},
  {path:'registration', component: RegistrationComponent},
  {path:'adminPanel', component:AdminPanelComponent},
  {path:'adminEntityView', component:AdminEntityViewComponent},
  {path:'dodajEntitet', component:DodajEntitetComponent},
  {path:'dodajKomentar', component:DodajKomentarComponent},
  {path:'dodajDrzavu', component:DodajDrzavuComponent},
  {path:'dodajObjekat', component: ObjekatComponent},
  {path:'event/:id', component: EventComponent},
  {path:'events', component: AdminPanelComponent},
  {path:'dodajObjavu', component: ObjavaComponent},
  {path:'dodajGrad', component:DodajGradComponent},
  {path:'dodajTipObjekta', component: TipObjektaComponent},
  {path:'izmeniGrad/:element.id', component: IzmeniGradComponent},
  {path:'izmeniDrzavu/:element.id', component: IzmeniDrzavuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
