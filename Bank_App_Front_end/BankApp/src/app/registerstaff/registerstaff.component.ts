import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Staffregistration } from '../staffregistration';
import { StaffregistrationService } from '../staffregistration.service';

@Component({
  selector: 'app-registerstaff',
  templateUrl: './registerstaff.component.html',
  styleUrls: ['./registerstaff.component.css']
})
export class RegisterstaffComponent implements OnInit {

  user: Staffregistration = new Staffregistration();
  users: any;
  acknowledgement: any;

  constructor(private signupService: StaffregistrationService, private router:Router) { }


  ngOnInit(): void {
    this.acknowledgement = "Add a staff"
  }
  profileForm = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.minLength(4)]),
    password: new FormControl('', [Validators.required,Validators.minLength(4)]),
    fname: new FormControl('', [Validators.required]),
    lname: new FormControl('', [Validators.required])
    
  });
  get f(){
    return this.profileForm.controls;
   }
   submit(){
    this.user.username=this.f['username'].value;
    this.user.password=this.f['password'].value;
    this.user.fname=this.f['fname'].value;
    this.user.lname=this.f['lname'].value;

    console.log("Tsi", this.user.username);

    console.log(this.profileForm.value);
    if(this.user.username!='' && this.user.username!=null && this.user.username.length>=4){
      this.addUser();
      //this.router.navigate(['/dashboard'])
      this.router.navigate([''])
      }
      //this.signupService.createuserlist(this.user)
      //Here logic will be there Develop your application can add logic here to call API Hit
      
     }
      addUser() {
        this.signupService.createstafflist(this.user).subscribe(data => console.log(data),error=>console.log(error));
        this.user= new Staffregistration();
        this.acknowledgement = "Record added successfully";
   }
}
