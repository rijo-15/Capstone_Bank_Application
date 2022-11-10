import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StaffregistrationService {
  private baseUrl = 'http://localhost:9090';
 
 
  constructor(private http:HttpClient) { }
 
  //connect to the server and get the data from the server  object
  //CRUD service
  //connect point to the server and UI
 
  //we need to define method to post the data
  //Post the data to the server
 
  createstafflist(user: object): Observable<object> {
    console.log("success");
    return this.http.post(`${this.baseUrl}` + '/api/admin/staff', user);
  }
 
  //Read Operation
  getstaffList(): Observable<any> {
 
    return this.http.get(`${this.baseUrl}` + '/api/admin/getstaffs');  //will change
 
  }
  // we need to create method to perform delete operation
  // inside the method we need to call delete method in REST API
  
 
 
}
