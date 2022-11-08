import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { StaffloginComponent } from './stafflogin/stafflogin.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';


const routes: Routes = [
  { path: 'registration', component: RegistrationComponent},
  { path: '', component: LoginComponent},
  { path: 'stafflogin', component: StaffloginComponent},
  { path: 'adminlogin', component: AdminloginComponent},
  {path: 'forgotpassword', component: ForgotPasswordComponent},
  {path: 'updatepassword', component: UpdatepasswordComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
