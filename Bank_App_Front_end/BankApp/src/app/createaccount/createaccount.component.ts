import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Account } from '../account';
import { CreateaccountService } from '../createaccount.service';
 
@Component({
  selector: 'app-createaccount',
  templateUrl: './createaccount.component.html',
  styleUrls: ['./createaccount.component.css']
})
export class CreateaccountComponent implements OnInit {
 
  //constructor() { }
 
  user : Account= new Account();
  users: any;
  acknowledgement: any;
 
  constructor(private signupService:CreateaccountService, private router:Router) { }
 
 
  ngOnInit(): void {
  }
 
  profileForm = new FormGroup({
 
    accountBalance: new FormControl('',),
    accountType: new FormControl('',),
    //dept: new FormControl('', [Validators.required]),
    //salary: new FormControl('', [Validators.required]),
   
   });
 
   get f(){
    return this.profileForm.controls;
   }
   
   
   submit() {
       
    this.user.accountBalance=this.f['accountBalance'].value;         //Angular
    this.user.accountType=this.f['accountType'].value;
 
   console.log("Amit",this.user.accountBalance);
   
    console.log(this.profileForm.value);
    //Post Operationwill be executed here
    if(this.user.accountBalance!='' && this.user.accountBalance!=null){
    this.addUser();
    this.router.navigate(['/dashboard'])
    }
    //this.signupService.createuserlist(this.user)
    //Here logic will be there Develop your application can add logic here to call API Hit
   
   }
    addUser() {
      this.signupService.createuserlist(this.user).subscribe(data => console.log(data),error=>console.log(error));
      this.user= new Account();
      this.acknowledgement = "Record added successfully";
    }
 
}
