import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { AddbeneficiaryComponent } from './addbeneficiary/addbeneficiary.component';
import { RemovebeneficiaryComponent } from './removebeneficiary/removebeneficiary.component';
import { TransfermoneyComponent } from './transfermoney/transfermoney.component';
import { ViewstatementComponent } from './viewstatement/viewstatement.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
    DashboardComponent,
    CreateaccountComponent,
    AddbeneficiaryComponent,
    RemovebeneficiaryComponent,
    TransfermoneyComponent,
    ViewstatementComponent,
    ForgotPasswordComponent,
    UpdatepasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
