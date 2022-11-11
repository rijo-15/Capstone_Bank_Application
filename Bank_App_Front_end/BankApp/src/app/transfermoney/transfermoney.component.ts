import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Transfer } from '../transfer';
import { TransferService } from '../transfer.service';
 
@Component({
  selector: 'app-transfermoney',
  templateUrl: './transfermoney.component.html',
  styleUrls: ['./transfermoney.component.css']
})
export class TransfermoneyComponent implements OnInit {
 
  transfer: Transfer= new Transfer();
  transfers: any;
  acknowledgement: any;
  deleteMessge: any;
 
  constructor(private signupService:TransferService, private router:Router) { }
 
  ngOnInit(): void {
  }
 
  profileForm = new FormGroup({
 
    payloadId: new FormControl('',),
    fromAccNumber: new FormControl('',),
    toAccNumber: new FormControl('',),
    amount: new FormControl('',),
    reason: new FormControl('',),
    byCustomerId: new FormControl('',),
    byStaffId: new FormControl('',),
   
   });
 
   get f(){
    return this.profileForm.controls;
   }
   
   
   submit() {
       
    this.transfer.fromAccNumber=this.f['fromAccNumber'].value;         //Angular
    this.transfer.toAccNumber=this.f['toAccNumber'].value;
    this.transfer.amount=this.f['amount'].value;
    this.transfer.reason=this.f['reason'].value;
 
   console.log("Amit",this.transfer.reason); // for testing
   
    console.log(this.profileForm.value);
    //Post Operationwill be executed here
    if(this.transfer.fromAccNumber!='' && this.transfer.fromAccNumber!=null&&
       this.transfer.toAccNumber!='' && this.transfer.toAccNumber!=null&&
       this.transfer.amount!='' && this.transfer.amount!=null){
        console.log("in if statement");
    this.putUser();
    this.router.navigate(['/dashboard'])
    }
    //this.signupService.createuserlist(this.user)
    //Here logic will be there Develop your application can add logic here to call API Hit
   
   }
    putUser() {
      console.log("in putUser", this.transfer.reason);
      this.signupService.putuserList(this.transfer).subscribe(data => console.log(data),error=>console.log(error));
      this.transfer= new Transfer();
      this.acknowledgement = "Record added successfully";
    }
 
}
