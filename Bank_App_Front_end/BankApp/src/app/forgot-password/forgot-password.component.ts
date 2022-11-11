import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../user';
 
@Component({
 selector: 'app-forgot-password',
 templateUrl: './forgot-password.component.html',
 styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
 
 ack: any;
 user: User = new User();
 users: any;
 pak: any;
 constructor(private signupService: LoginService, private router: Router) { }
  ngOnInit(): void {
  
 }
  profileForm = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.minLength(4)]),
   password: new FormControl('', [Validators.required]),
   securityQuestion: new FormControl('', [Validators.required,Validators.minLength(4)])
  });
  get f() {
   return this.profileForm.controls;
 }
  resetpassword() {
    this.user.username = this.f['username'].value;         //Angular
   //this.user.password = this.f['password'].value;
   this.user.securityQuestion=this.f['securityQuestion'].value;
 
   console.log("userId", this.user.username);
   console.log("userpass", this.user.securityQuestion);
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
         if (this.user.username == this.users[i].userName && this.user.securityQuestion == this.users[i].securityQuestion) {
           // this.loginack = "Record added successfully";
           console.log("success")
           this.router.navigate(['/updatepassword']);
           break;
         } if(this.user.username != this.users[i].userName){
          this.ack="Username doesn't exsist"
          break;
         }if(this.user.securityQuestion != this.users[i].securityQuestion){
          this.ack="Wrong Anwer"
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
