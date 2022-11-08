import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { StaffdashboardComponent } from './staffdashboard/staffdashboard.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'staffdashboard', component: StaffdashboardComponent}
  // {path: 'forgotpassword', component: ForgotPasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
