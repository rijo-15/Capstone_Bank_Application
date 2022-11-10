import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class BeneficiaryService {
 
  //constructor() { }
 
  private baseUrl = 'http://localhost:9090';
 
 
  constructor(private http:HttpClient) { }
 
  createuserlist(user: object): Observable<object> {
    console.log("success");
 
    //type OjbectKey = keyof typeof user;
    //const myVar = 'customerId' as OjbectKey;
    //var customerId = user[myVar];
    //console.log(customerId);
 
    return this.http.post(`${this.baseUrl}` + '/api/customer/1/beneficiary', user);
    //user.userid
    //console.log(user.customerId)
    //${user.customerid}
  }
 
  //Read Operation
  getuserList(): Observable<any> {
 
   return this.http.get(`${this.baseUrl}` + '/api/customer/1/beneficiary');  //will change
 
  }
 
  deleteuserList(id: number, customerId: number): Observable<any> {
 
   return this.http.delete(`${this.baseUrl}` + `/api/customer/`+ `${customerId}` + `/beneficiary/`+ `${id}`, {responseType: 'text'});  //will change
 
  }
 
 
 
}
