import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { StaffdashboardComponent } from './staffdashboard/staffdashboard.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AddbeneficiaryComponent } from './addbeneficiary/addbeneficiary.component';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RemovebeneficiaryComponent } from './removebeneficiary/removebeneficiary.component';
import { TransfermoneyComponent } from './transfermoney/transfermoney.component';
import { ViewstatementComponent } from './viewstatement/viewstatement.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { StaffloginComponent } from './stafflogin/stafflogin.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { RegisterstaffComponent } from './registerstaff/registerstaff.component';
import { ViewstaffComponent } from './viewstaff/viewstaff.component';
import { ApprovebeneficiaryComponent } from './approvebeneficiary/approvebeneficiary.component';
import { ApproveaccountComponent } from './approveaccount/approveaccount.component';
import { ViewaccountComponent } from './viewaccount/viewaccount.component';
import { TransferpageComponent } from './transferpage/transferpage.component';

const routes: Routes = [
  {path: ' ', component: LoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'staffdashboard', component: StaffdashboardComponent},
  { path: 'registration', component: RegistrationComponent},
  { path: 'stafflogin', component: StaffloginComponent},
  { path: 'adminlogin', component: AdminloginComponent},
  {path: 'forgotpassword', component: ForgotPasswordComponent},
  {path: 'updatepassword', component: UpdatepasswordComponent},
  {path: 'dashboard', component:DashboardComponent},
  {path: 'createaccount', component:CreateaccountComponent},
  {path: 'addbeneficiary', component:AddbeneficiaryComponent},
  {path: 'removebeneficiary', component:RemovebeneficiaryComponent},
  {path: 'transfermoney', component:TransfermoneyComponent},
  {path: 'viewstatement', component:ViewstatementComponent},
  {path: 'admindashboard', component:AdmindashboardComponent},
  {path: 'registerstaff', component:RegisterstaffComponent},
  {path: 'viewstaff', component:ViewstaffComponent},
  {path: 'transferpage', component:TransferpageComponent},
  {path: 'viewaccount', component:ViewaccountComponent},
  {path: 'approveaccount', component:ApproveaccountComponent},
  {path: 'approvebeneficiary', component:ApprovebeneficiaryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
