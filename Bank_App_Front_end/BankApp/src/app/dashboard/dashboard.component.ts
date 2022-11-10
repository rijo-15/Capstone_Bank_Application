import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Account } from '../account';
import { DashboardService } from '../dashboard.service';
 
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
 
  //constructor() { }
 
 user : Account= new Account();
 users: any;
 acknowledgement: any;
 
 constructor(private signupService:DashboardService, private router:Router) { }
 
 
 
  ngOnInit(): void {
  }
 
  profileForm = new FormGroup({
 
    accountNumber: new FormControl('', [Validators.required, Validators.minLength(4)]),
    accountBalance: new FormControl('', [Validators.required,Validators.minLength(4)]),
    //dept: new FormControl('', [Validators.required]),
    //salary: new FormControl('', [Validators.required]),
   
   });
 
 
   readUser() {  
    this.signupService.getuserList()
      .subscribe(data=>
        {this.users=data},error=>console.log(error)) ;
 
  }
 
 
}
