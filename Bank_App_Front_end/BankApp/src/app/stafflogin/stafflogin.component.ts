import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Staff } from '../staff';
import { StaffloginService } from '../stafflogin.service';

@Component({
  selector: 'app-stafflogin',
  templateUrl: './stafflogin.component.html',
  styleUrls: ['./stafflogin.component.css']
})
export class StaffloginComponent implements OnInit {

  ack: any;
  user: Staff = new Staff();
  users: any;
  constructor(private signupService: StaffloginService,private router: Router) { }

  ngOnInit(): void {
    this.ack = "please type username and password!"
  }
profileForm = new FormGroup({
  username: new FormControl('', [Validators.required, Validators.minLength(4)]),
  password: new FormControl('', [Validators.required]),
});
get f(){
  return this.profileForm.controls;
}
stafflogin(){
  this.user.username=this.f['username'].value;
  this.user.password=this.f['password'].value;

  console.log("username", this.user.username);
  console.log("password", this.user.password);

  console.log(this.profileForm.value)

  this.signupService.getstaffList()
    .subscribe(data =>{
      this.users = data;
      console.log(this.users)
      for(let i=0; i<data.length; i++){
        console.log("Hi staff", this.users[i].username);

        if(this.user.username == "admin@admin.com" && this.user.password == 'secret@123'){
          console.log("uname test",this.users[i].username);
          console.log("password test",this.users[i].password);
          console.log("sucessfully logged in!")
          this.router.navigate(['/admindashboard']);
          break;
        }else if(this.user.username == this.users[i].username && this.user.password == this.users[i].password){
          console.log("sucessfully logged in!")
          this.router.navigate(['/dashboard']);
          break;
        }else{
          this.ack="Username or password is incorret!"
        }
      }
    }, error => console.log(error));
}
}
