import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { StaffloginComponent } from './stafflogin/stafflogin.component';

const routes: Routes = [
  { path: 'registration', component: RegistrationComponent},
  { path: '', component: LoginComponent},
  { path: 'stafflogin', component: StaffloginComponent},
  { path: 'adminlogin', component: AdminloginComponent}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
