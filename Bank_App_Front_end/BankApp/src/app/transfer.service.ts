import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class TransferService {
 
  private baseUrl = 'http://localhost:9090';
 
  constructor(private http:HttpClient) { }
 
  //Put Operation
  putuserList(transfer: object): Observable<any> {
 
    console.log(transfer);
    return this.http.put(`${this.baseUrl}` + '/api/customer/transfer', transfer);  //will change
 
  }
 
}
