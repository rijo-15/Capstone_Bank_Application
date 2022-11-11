import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class ApprovebeneficiaryService {
 
  private baseUrl = 'http://localhost:9090';
 
  constructor(private http:HttpClient) { }
 
  //Read Operation
  getuserList(): Observable<any> {
 
    return this.http.get(`${this.baseUrl}` + '/api/staff/beneficiary');  //will change
 
  }
 
  //Put Operation
  putuserList(approvebeneficiary: object): Observable<any> {
 
    console.log(approvebeneficiary);
    return this.http.put(`${this.baseUrl}` + '/api/staff/beneficiary', approvebeneficiary);  //will change
 
  }
 
}
