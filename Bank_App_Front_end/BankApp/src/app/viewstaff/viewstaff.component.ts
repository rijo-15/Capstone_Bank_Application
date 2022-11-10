import { Component, OnInit } from '@angular/core';
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

readStaff(){
  this.signupService.getstaffList()
    .subscribe(data =>
      {this.users=data},error=>console.log(error));
      
}
}
