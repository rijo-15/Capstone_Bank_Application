import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Beneficiary } from '../beneficiary';
import { BeneficiaryService } from '../beneficiary.service';
 
@Component({
  selector: 'app-removebeneficiary',
  templateUrl: './removebeneficiary.component.html',
  styleUrls: ['./removebeneficiary.component.css']
})
export class RemovebeneficiaryComponent implements OnInit {
 
  beneficiary : Beneficiary= new Beneficiary();
  beneficiarys: any;
  acknowledgement: any;
  deleteMessge: any;
 
  constructor(private signupService:BeneficiaryService, private router:Router) { }
 
  ngOnInit(): void {
  }
 
  profileForm = new FormGroup({
 
    bfirstName: new FormControl('',),
    lastName: new FormControl('',),
    ssn: new FormControl('',),
   
   });
 
 
   readUser() {  
    this.signupService.getuserList()
      .subscribe(data=>
        {this.beneficiarys=data},error=>console.log(error)) ;
 
  }
 
  deleteUser(id: number, customerId: number) {
    this.signupService.deleteuserList(id, customerId)
      .subscribe(
        (      data: any) => {
          console.log(data);
          this.deleteMessge=true;
          this.signupService.getuserList().subscribe(data =>{
            this.beneficiarys =data
            })
        },
        (      error: any) => console.log(error));
  }
 
 
}
