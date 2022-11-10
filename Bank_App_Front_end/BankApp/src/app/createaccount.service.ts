import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class CreateaccountService {
 
  //constructor() { }
 
  private baseUrl = 'http://localhost:9090';
 
 
  constructor(private http:HttpClient) { }
 
  createuserlist(user: object): Observable<object> {
    console.log("success");
    return this.http.post(`${this.baseUrl}` + '/api/customer/1/account', user);
  }
 
}
