import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import { AdminloginService } from '../adminlogin.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  ack: any;
  user: Admin = new Admin();
  users: any;

  constructor(private signupService: AdminloginService, private router: Router) { }

  ngOnInit(): void {
    this.ack = "please type username and password"
  }

  profileForm = new FormGroup({

    username: new FormControl('', [Validators.required, Validators.minLength(4)]),
    password: new FormControl('', [Validators.required]),
  });

  get f(){
    return this.profileForm.controls;
  }

  adminlogin(){
    this.user.username = this.f['username'].value;
    this.user.password = this.f['password'].value;

    console.log("username", this.user.username);
    console.log("password", this.user.password);

    console.log(this.profileForm.value)
console.log("Test1");
    this.signupService.getadminList()
    .subscribe(data =>{
      this.users = data;
      console.log(this.users)
      console.log("Test2");
      for(let i=0; i<data.length; i++){
        console.log("Test3");
        console.log("Hi staff", this.users[i].username);
        if(this.user.username == this.users[i].username && this.user.password == this.users[i].password){
          console.log("sucessfully logged in!")
          this.router.navigate(['/admindashboard']);
          break;
        }else{
          this.ack="Username or password is incorret!"
        }
      }
    }, error => console.log("error"));
  }
}
