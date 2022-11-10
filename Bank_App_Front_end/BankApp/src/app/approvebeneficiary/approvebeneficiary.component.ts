import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Beneficiary } from '../beneficiary';

@Component({
  selector: 'app-approvebeneficiary',
  templateUrl: './approvebeneficiary.component.html',
  styleUrls: ['./approvebeneficiary.component.css']
})
export class ApprovebeneficiaryComponent implements OnInit {
  acknowledgement: any;
  constructor() { }

  ngOnInit(): void {
  }
  user: Beneficiary = new Beneficiary();
  Users: any;
//  we need to write the logic here to bind the data which is comming from the form.
    // also we need to write the logic to connect with registration service once data is ready.
     
    profileForm = new FormGroup({
     
      status: new FormControl('', [Validators.required, Validators.minLength(4)]),
      customerid: new FormControl('', [Validators.required,Validators.minLength(4)]),
      date_of_creation: new FormControl('', [Validators.required,Validators.minLength(4)]),
      bfirstName: new FormControl('', [Validators.required,Validators.minLength(4)]),
      //dept: new FormControl('', [Validators.required]),
      //salary: new FormControl('', [Validators.required]),
      
     });
      
      
     get f(){
      return this.profileForm.controls;
     }
      
      
     submit() {
      
      //console.log('Name:' + this.somedata.name);
      //console.log('Series:' + this.somedata.series);
      this.user.customer_id=this.f['customerid'].value;     
      // this.user.status=this.f['status'].value;
      // this.user.date_of_creation=this.f['date_of_creation'].value;
      this.user.bfirstName=this.f['bfirstName'].value;
     
     
      //this.user.dept=this.f['dept'].value;
      //this.user.salary=this.f['salary'].value;
      
    //  console.log("Amit",this.user.username);
      
    //   console.log(this.profileForm.value);
      //Post Operationwill be executed here
      // if(this.user.username!='' && this.user.username!=null && this.user.username.length>=4){
      // this.addUser();
      // //this.router.navigate(['/dashboard'])
      // this.router.navigate([''])
      // }
      //this.signupService.createuserlist(this.user)
      //Here logic will be there Develop your application can add logic here to call API Hit
      
     }
      // addUser() {
      //   this.signupService.createuserlist(this.user).subscribe(data => console.log(data),error=>console.log(error));
      //   this.user= new Beneficiary();
      //   this.acknowledgement = "Record added successfully";
      // }
      
      
      
     }