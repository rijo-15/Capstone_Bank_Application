import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-approveaccount',
  templateUrl: './approveaccount.component.html',
  styleUrls: ['./approveaccount.component.css']
})
export class ApproveaccountComponent implements OnInit {
  acknowledgement: any;


    constructor(private signupService: StaffService, private router: Router) { }

  ngOnInit(): void {
  }
  user: Staff = new Staff();
  Users: any;
//  we need to write the logic here to bind the data which is comming from the form.
    // also we need to write the logic to connect with registration service once data is ready.
     
    profileForm = new FormGroup({
     
      id: new FormControl('', [Validators.required, Validators.minLength(4)]),
      fname: new FormControl('', [Validators.required,Validators.minLength(4)]),
      status: new FormControl('', [Validators.required,Validators.minLength(4)]),
      //dept: new FormControl('', [Validators.required]),
      //salary: new FormControl('', [Validators.required]),
      
     });
      
      
     get f(){
      return this.profileForm.controls;
     }
      
      
     submit() {
      
      //console.log('Name:' + this.somedata.name);
      //console.log('Series:' + this.somedata.series);
      this.user.id=this.f['id'].value;     
      this.user.status=this.f['status'].value;
      this.user.fname=this.f['fname'].value;
       
    
     //this.user.dept=this.f['dept'].value;
     //this.user.salary=this.f['salary'].value;
     
     console.log("Amit",this.user.username);
     
     console.log(this.profileForm.value);
     //Post Operationwill be executed here
    //  if(this.user.username!='' && this.user.username!=null && this.user.username.length>=4){
    //  this.addUser();
    //  //this.router.navigate(['/dashboard'])
    //  this.router.navigate([''])
    //  }
     //this.signupService.createuserlist(this.user)
     //Here logic will be there Develop your application can add logic here to call API Hit
     
    }
    //  addUser() {
    //    this.signupService.createuserlist(this.user).subscribe(data => console.log(data),error=>console.log(error));
    //    this.user= new Staff();
    //    this.acknowledgement = "Record added successfully";
    //  }
     
     
     
    }
    