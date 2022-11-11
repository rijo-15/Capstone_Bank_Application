import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-viewstaff',
  templateUrl: './viewstaff.component.html',
  styleUrls: ['./viewstaff.component.css']
})
export class ViewstaffComponent implements OnInit {

  

  ngOnInit(): void {
  }
user: Staff = new Staff();
users: any;

constructor(private signupService: StaffService) { }
/*
profileForm = new FormGroup({
  id: new FormControl('',),
  status: new FormControl('',),

});
get f(){
  return this.profileForm.controls;
}
submit(){
  this.user.id=this.f['id'].value;
  this.user.status=this.f['status'].value;

  console.log("id", this.user.id);
  console.log("status", this.user.status);


  console.log(this.profileForm.value);
  this.signupService.getstaffList()
  .subscribe(data => {
    this.users = data;
    console.log(this.users)
    for (let i = 0; i < data.length; i++) {
      console.log("id", this.users[i].id); //use i instead of 0
      console.log("status", this.users[i].status);
      
      if (this.users[i].status == "active" && ) {
        this
}
*/
/*
this.signupService.getstaffList()
     .subscribe(data => {
       this.users = data;
       console.log(this.users)
       for (let i = 0; i < data.length; i++) {
         console.log("Hi Rijo", this.users[i].id); //use i instead of 0
         if (this.user.status == "active") {
           // this.loginack = "Record added successfully";
           
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
*/

readStaff(){
  this.signupService.getstaffList()
    .subscribe(data =>
      {this.users=data},error=>console.log(error));
      
}
// enableStaff(){
//   this.signupService.enableadmin(this.user).subscribe
// }
}
