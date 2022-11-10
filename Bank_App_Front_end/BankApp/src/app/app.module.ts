import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ProfileComponent } from './profile/profile.component';
import { StaffdashboardComponent } from './staffdashboard/staffdashboard.component';
import { StaffloginComponent } from './stafflogin/stafflogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { AddbeneficiaryComponent } from './addbeneficiary/addbeneficiary.component';
import { RemovebeneficiaryComponent } from './removebeneficiary/removebeneficiary.component';
import { TransfermoneyComponent } from './transfermoney/transfermoney.component';
import { ViewstatementComponent } from './viewstatement/viewstatement.component';
import { RegisterstaffComponent } from './registerstaff/registerstaff.component';
import { ViewstaffComponent } from './viewstaff/viewstaff.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewaccountComponent } from './viewaccount/viewaccount.component';
import { ApprovebeneficiaryComponent } from './approvebeneficiary/approvebeneficiary.component';
import { TransferpageComponent } from './transferpage/transferpage.component';
import { ApproveaccountComponent } from './approveaccount/approveaccount.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
    ProfileComponent,
    StaffdashboardComponent,
    StaffloginComponent,
    AdminloginComponent,
    AdmindashboardComponent,
    DashboardComponent,
    CreateaccountComponent,
    AddbeneficiaryComponent,
    RemovebeneficiaryComponent,
    TransfermoneyComponent,
    ViewstatementComponent,
    ForgotPasswordComponent,
    UpdatepasswordComponent,
    RegisterstaffComponent,
    ViewstaffComponent,
    ViewaccountComponent,
    ApprovebeneficiaryComponent,
    TransferpageComponent,
    ApproveaccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

