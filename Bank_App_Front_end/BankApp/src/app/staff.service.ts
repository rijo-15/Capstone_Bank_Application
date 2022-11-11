import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  private baseUrl='http://localhost:9090';
  
  constructor(private http: HttpClient) { }

  createstaffList(user: object): Observable<object>{
    console.log("sucess");
    return this.http.post(`${this.baseUrl}` + '/api/admin/staff', user);
  }

  getstaffList(): Observable<any>{
    return this.http.get(`${this.baseUrl}` + '/api/admin/getstaffs');
  }
  enableadmin(user: any): Observable<any>{
    return this.http.put(`${this.baseUrl}` + '/api/admin/updatestaff',user );

  }
}
