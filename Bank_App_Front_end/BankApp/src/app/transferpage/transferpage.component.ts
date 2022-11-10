import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Account } from '../account';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-transferpage',
  templateUrl: './transferpage.component.html',
  styleUrls: ['./transferpage.component.css']
})
export class TransferpageComponent implements OnInit {
  acknowledgement: any;

  constructor() { }

  ngOnInit(): void {
      this.acknowledgement = "Transfer";
     }
     user:Transaction = new Transaction();
     Users: any;

    //  we need to write the logic here to bind the data which is comming from the form.
    // also we need to write the logic to connect with registration service once data is ready.
     
    profileForm = new FormGroup({
     
     accountNumber: new FormControl('', [Validators.required, Validators.minLength(4)]),
     amount: new FormControl('', [Validators.required,Validators.minLength(4)]),
     //dept: new FormControl('', [Validators.required]),
     //salary: new FormControl('', [Validators.required]),
     
    });
     
     
    get f(){
     return this.profileForm.controls;
    }
     
     
    submit() {
     
     //console.log('Name:' + this.somedata.name);
     //console.log('Series:' + this.somedata.series);
     this.user.tranAccountNumber=this.f['accountNumber'].value;     
     this.user.amount=this.f['amount'].value;
    
    
     //this.user.dept=this.f['dept'].value;
     //this.user.salary=this.f['salary'].value;
     
    // console.log("Amit",this.user.userName);
     
     console.log(this.profileForm.value);
     //Post Operationwill be executed here
    //  if(this.user.userName!='' && this.user.userName!=null && this.user.userName.length>=4){
    //  this.addUser();
    //  //this.router.navigate(['/dashboard'])
    //  this.router.navigate([''])
    //  }
     //this.signupService.createuserlist(this.user)
     //Here logic will be there Develop your application can add logic here to call API Hit
     
    }
    //  addUser() {
    //    this.signupService.createuserlist(this.user).subscribe(data => console.log(data),error=>console.log(error));
    //    this.user= new Transaction();
    //    this.acknowledgement = "Record added successfully";
    //  }
     
     
     
    }
    