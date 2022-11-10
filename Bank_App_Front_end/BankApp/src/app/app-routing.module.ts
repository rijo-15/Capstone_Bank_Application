import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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

const routes: Routes = [
  { path: 'registration', component: RegistrationComponent},
  { path: '', component: LoginComponent},
  { path: 'stafflogin', component: StaffloginComponent},
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
  {path: 'viewstaff', component:ViewstaffComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
