import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Approvebeneficiary } from '../approvebeneficiary';
import { ApprovebeneficiaryService } from '../approvebeneficiary.service';
 
@Component({
  selector: 'app-approvebeneficiary',
  templateUrl: './approvebeneficiary.component.html',
  styleUrls: ['./approvebeneficiary.component.css']
})
export class ApprovebeneficiaryComponent implements OnInit {
 
  approvebeneficiary : Approvebeneficiary= new Approvebeneficiary();
  approvebeneficiarys: any;
  acknowledgement: any;
  deleteMessge: any;
 
  constructor(private signupService:ApprovebeneficiaryService, private router:Router) { }
 
  ngOnInit(): void {
  }
 
  profileForm = new FormGroup({
 
    bid: new FormControl('',),
    approved: new FormControl('',),
   
   });
 
 
   readUser() {  
    this.signupService.getuserList()
      .subscribe(data=>
        {this.approvebeneficiarys=data},error=>console.log(error)) ;
 
  }
 
  get f(){
    return this.profileForm.controls;
   }
 
  submit() {
       
    this.approvebeneficiary.bid=this.f['bid'].value;         //Angular
    this.approvebeneficiary.approved=this.f['approved'].value;
 
   console.log("Amit",this.approvebeneficiary.approved); // for testing
   
    console.log(this.profileForm.value);
    //Post Operationwill be executed here
    if(this.approvebeneficiary.bid!='' && this.approvebeneficiary.bid!=null&&
       this.approvebeneficiary.approved!='' && this.approvebeneficiary.approved!=null
       ){
        console.log("in if statement");
    this.putUser();
    this.router.navigate(['/dashboard']) //connect to staff dashboard
    }
    //this.signupService.createuserlist(this.user)
    //Here logic will be there Develop your application can add logic here to call API Hit
   
   }
    putUser() {
      console.log("in putUser", this.approvebeneficiary.approved);
      this.signupService.putuserList(this.approvebeneficiary).subscribe(data => console.log(data),error=>console.log(error));
      this.approvebeneficiary= new Approvebeneficiary();
      this.acknowledgement = "Record added successfully";
    }
 
 
 
}

