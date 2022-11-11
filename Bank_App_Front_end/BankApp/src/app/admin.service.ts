import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:9090';
  constructor(private http:HttpClient) { } 

  createadminList(user: object): Observable<object>{
    console.log("sucess");
    return this.http.post(`${this.baseUrl}` +  '/api/admin/addadmin', user)
  }
  //for admin login purposes
  getadminList(): Observable<any>{
    return this.http.get(`${this.baseUrl}` + '/api/admin/getadmin');
  }
  
}
