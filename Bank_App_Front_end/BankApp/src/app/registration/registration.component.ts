import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Registration } from '../registration';
import { RegistrationService } from '../registration.service';
//import { User } from '../user';
//import { UserService } from '../user.service';
 
 
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
 
 user : Registration= new Registration();
 users: any;
 acknowledgement: any;
 
 constructor(private signupService:RegistrationService, private router:Router) { }
 
 
 
 ngOnInit(): void {
  this.acknowledgement = "Add record please";
 }
//  we need to write the logic here to bind the data which is comming from the form.
// also we need to write the logic to connect with registration service once data is ready.
 
profileForm = new FormGroup({
 
 userName: new FormControl('', [Validators.required, Validators.minLength(4)]),
 password: new FormControl('', [Validators.required,Validators.minLength(4)]),
//  userid: new FormControl('', )
 ssn : new FormControl('', [Validators.required]),
 firstName: new FormControl('', [Validators.required]),
 lastName: new FormControl('', [Validators.required]),
 //username: any;
 //password: any;
 email : new FormControl('', [Validators.required,]),
 phone : new FormControl('', [Validators.required,]),
 role: new FormControl('', [Validators.required,Validators.minLength(4)]),
 securityQuestion: new FormControl('', [Validators.required,])
 //dept: new FormControl('', [Validators.required]),
 //salary: new FormControl('', [Validators.required]),
 
});
 
 
get f(){
 return this.profileForm.controls;
}
 
 
submit() {
 
 //console.log('Name:' + this.somedata.name);
 //console.log('Series:' + this.somedata.series);
 
 this.user.userName=this.f['userName'].value;         //Angular
 this.user.password=this.f['password'].value;
 this.user.ssn=this.f['ssn'].value;
 this.user.firstName=this.f['firstName'].value;
 this.user.lastName=this.f['lastName'].value;
 this.user.email=this.f['email'].value;
 this.user.phone=this.f['phone'].value;
 //this.user.role=this.f['role'].value;
 this.user.securityQuestion=this.f['securityQuestion'].value;

 //this.user.dept=this.f['dept'].value;
 //this.user.salary=this.f['salary'].value;
 
console.log("Amit",this.user.userName);
 
 console.log(this.profileForm.value);
 //Post Operationwill be executed here
 if(this.user.userName!='' && this.user.userName!=null && this.user.userName.length>=4){
 this.addUser();
 //this.router.navigate(['/dashboard'])
 this.router.navigate([''])
 }
 
 //this.signupService.createuserlist(this.user)
 //Here logic will be there Develop your application can add logic here to call API Hit
 
}
 addUser() {
   this.signupService.createuserlist(this.user).subscribe(data => console.log(data),error=>console.log(error));
   this.user= new Registration();
   this.acknowledgement = "Record added successfully";
 }
 
 
 
}
