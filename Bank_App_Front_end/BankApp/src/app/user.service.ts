import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
 providedIn: 'root'
})
export class UserService {
 
 
 // getuserList() {
 //   throw new Error('Method not implemented.');
 // }
 
 
 private baseUrl = 'http://localhost:9090';
 
 constructor(private http:HttpClient) { }
 
 createuserlist(user: object): Observable<object> {
   console.log("success");
   return this.http.post(`${this.baseUrl}` + '/api/customer/register', user);
 }
 
 //Read Operation
 getuserList(): Observable<any> {
 
   return this.http.get(`${this.baseUrl}` + '/api/customer/getcustomers');  //will change
 
 }
 
 // deleteuserList(id: number): Observable<any> {
 
 //   return this.http.delete(`${this.baseUrl}` + `/api/employee/deleteemployee/`+ `${id}`, {responseType: 'text'});  //will change
 
 // }
 
 
 }

