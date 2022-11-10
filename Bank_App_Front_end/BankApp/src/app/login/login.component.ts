import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user';
import { LoginService } from '../login.service';
 
 
@Component({
 selector: 'app-login',
 templateUrl: './login.component.html',
 styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
 ack: any;
 user: User = new User();
 users: any;
 constructor(private signupService: LoginService, private router: Router) { }
 
 ngOnInit(): void {
   this.ack = "Please type the Id and Dept!"
 }
 
 profileForm = new FormGroup({
 
   username: new FormControl('', [Validators.required, Validators.minLength(4)]),
   password: new FormControl('', [Validators.required]),
 
 });
 
 get f() {
   return this.profileForm.controls;
 }
 
 login() {
 
   this.user.username = this.f['username'].value;         //Angular
   this.user.password = this.f['password'].value;
 
 
   console.log("userId", this.user.username);
   console.log("userpass", this.user.password);
 
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
         if (this.user.username == this.users[i].userName && this.user.password == this.users[i].password) {
           // this.loginack = "Record added successfully";
           console.log("success")
           this.router.navigate(['/dashboard']);
           break;
         } else {
 
           // this.router.navigate(['']);
           this.ack = "Id or Password Incorrect!"
 
         }
       }
     }, error => console.log(error));
   //now the database record is in the users and data
   //here we have to make the match between this.user.id, this.user.dept with the record coming from the db.
 
 
 
 
   //}
 
 
 }
 
 
}
