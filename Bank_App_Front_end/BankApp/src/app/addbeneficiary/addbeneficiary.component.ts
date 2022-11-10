import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Beneficiary } from '../beneficiary';
import { BeneficiaryService } from '../beneficiary.service';
 
@Component({
  selector: 'app-addbeneficiary',
  templateUrl: './addbeneficiary.component.html',
  styleUrls: ['./addbeneficiary.component.css']
})
export class AddbeneficiaryComponent implements OnInit {
 
  //constructor() { }
 
  user : Beneficiary= new Beneficiary();
  users: any;
  acknowledgement: any;
 
  constructor(private signupService:BeneficiaryService, private router:Router) { }
 
  ngOnInit(): void {
  }
 
  profileForm = new FormGroup({
 
    bfirstName: new FormControl('',),
    lastName: new FormControl('',),
    ssn: new FormControl('',),
   
   });
 
   get f(){
    return this.profileForm.controls;
   }
   
   
   submit() {
       
    this.user.bfirstName=this.f['bfirstName'].value;         //Angular
    this.user.lastName=this.f['lastName'].value;
    this.user.ssn=this.f['ssn'].value;
 
   console.log("Amit",this.user.bfirstName); // for testing
   
    console.log(this.profileForm.value);
    //Post Operationwill be executed here
    if(this.user.bfirstName!='' && this.user.bfirstName!=null&&
       this.user.lastName!='' && this.user.lastName!=null&&
       this.user.ssn!='' && this.user.ssn!=null){
    this.addUser();
    this.router.navigate(['/dashboard'])
    }
    //this.signupService.createuserlist(this.user)
    //Here logic will be there Develop your application can add logic here to call API Hit
   
   }
    addUser() {
      this.signupService.createuserlist(this.user).subscribe(data => console.log(data),error=>console.log(error));
      this.user= new Beneficiary();
      this.acknowledgement = "Record added successfully";
    }
 
 
}

