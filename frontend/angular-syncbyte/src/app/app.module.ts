import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { Routes,RouterModule} from '@angular/router';


import { AppComponent } from './app.component';
import { RegisterComponent } from './component/register/register.component';
import { EmployeeService } from './Services/employee.service';
import { CheckinComponent } from './component/checkin/checkin.component';
import { Route } from '@angular/compiler/src/core';
import { ModifyComponent } from './component/modify/modify.component';
import { HomeComponent } from './component/home/home.component';
import { UpdateComponent } from './component/update/update.component';

const routes: Routes=[
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  {path:'update/:employeecode', component:UpdateComponent},
  { path:'home', component: HomeComponent},
  { path: 'home/:value', component: HomeComponent},
  { path:'checkin', component: CheckinComponent},
  { path:'register', component:RegisterComponent},
  { path:'modify/:value', component:ModifyComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    CheckinComponent,
    ModifyComponent,
    HomeComponent,
    UpdateComponent
  ],
  imports: [
    [RouterModule.forRoot(routes)],
    BrowserModule,
    FormsModule,
    RouterModule,
    HttpClientModule
  ],  
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
