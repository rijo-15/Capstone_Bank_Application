import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddbeneficiaryComponent } from './addbeneficiary/addbeneficiary.component';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RemovebeneficiaryComponent } from './removebeneficiary/removebeneficiary.component';
import { TransfermoneyComponent } from './transfermoney/transfermoney.component';
import { ViewstatementComponent } from './viewstatement/viewstatement.component';

const routes: Routes = [
  {path: 'dashboard', component:DashboardComponent},
  {path: 'createaccount', component:CreateaccountComponent},
  {path: 'addbeneficiary', component:AddbeneficiaryComponent},
  {path: 'removebeneficiary', component:RemovebeneficiaryComponent},
  {path: 'transfermoney', component:TransfermoneyComponent},
  {path: 'viewstatement', component:ViewstatementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
