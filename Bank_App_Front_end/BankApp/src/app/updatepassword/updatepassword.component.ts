import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
 selector: 'app-updatepassword',
 templateUrl: './updatepassword.component.html',
 styleUrls: ['./updatepassword.component.css']
})
export class UpdatepasswordComponent implements OnInit {

 
 ack: any;
 user: User = new User();
 users: any;
 
 constructor(private signupService: LoginService, private router: Router) { }
  ngOnInit(): void {
  
 }
  profileForm = new FormGroup({
    password1: new FormControl('', [Validators.required, Validators.minLength(4)]),
   password2: new FormControl('', [Validators.required]),
   securityQuestion: new FormControl('', [Validators.required,Validators.minLength(4)])
  });
  get f() {
   return this.profileForm.controls;
 }
  updatepass() {
    this.user.password1 = this.f['password1'].value;         //Angular
   //this.user.password = this.f['password'].value;
   this.user.password2=this.f['password2'].value;
 
   console.log("password1", this.user.password1);
   console.log("confirmpass", this.user.password2);
    console.log(this.profileForm.value)
   //Post Operationwill be executed here
   //if(this.user.id!='' && this.user.dept!=null){
   //this.addUser();
   //here we need to wirte business logic to match the record enter the data which is coming from database
   this.signupService.getuserList()
     .subscribe(data => {
       this.users = data;
       console.log(this.users)
       for (let i = 0; i < data.length; i++) {
         console.log("Hi Rijo", this.users[i].userName); //use i instead of 0
         if (this.user.password1 == this.user.password2) {
           // this.loginack = "Record added successfully";
           console.log("success")
           this.router.navigate(['']);
           break;
         } if(this.user.password1 != this.users.password2){
          this.ack="Password doesn't match"
          break;
         
         }
         else {
            // this.router.navigate(['']);
           this.ack = " Wrong username and password"
          
          
          }
       }
     }, error => console.log(error));
   //now the database record is in the users and data
   //here we have to make the match between this.user.id, this.user.dept with the record coming from the db.
 
 
   //}
 
 }
 
}
