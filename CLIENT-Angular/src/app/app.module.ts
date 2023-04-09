import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';  
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserComponent } from './user/user.component';
import {MatListModule} from '@angular/material/list';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTableModule} from '@angular/material/table';
import {MatCard, MatCardModule} from '@angular/material/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { AdminEntityViewComponent } from './admin-entity-view/admin-entity-view.component';
import { MatSelectModule } from '@angular/material/select';
import { DodajEntitetComponent } from './dodaj-entitet/dodaj-entitet.component';
import { DodajKomentarComponent } from './dodaj-komentar/dodaj-komentar.component';
import { DodajDrzavuComponent } from './dodaj-drzavu/dodaj-drzavu.component';
import { EventComponent } from './event/event.component';
import { ObjekatComponent } from './objekat/objekat.component';
import { ObjavaComponent } from './objava/objava.component';
import { TipObjektaComponent } from './tip-objekta/tip-objekta.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { DodajGradComponent } from './dodaj-grad/dodaj-grad.component';
import { IzmeniGradComponent } from './izmeni-grad/izmeni-grad.component';
import { IzmeniDrzavuComponent } from './izmeni-drzavu/izmeni-drzavu.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    UserComponent,
    RegistrationComponent,
    AdminPanelComponent,
    AdminEntityViewComponent,
    DodajEntitetComponent,
    DodajKomentarComponent,
    DodajDrzavuComponent,
    EventComponent,
    ObjekatComponent,
    ObjavaComponent,
    TipObjektaComponent,
    DodajGradComponent,
    IzmeniGradComponent,
    IzmeniDrzavuComponent
    
  ],
  imports: [
    MatExpansionModule,
    MatCheckboxModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatCardModule,
    MatToolbarModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MatInputModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule 
  ],
  providers: [AdminEntityViewComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
  
 }
