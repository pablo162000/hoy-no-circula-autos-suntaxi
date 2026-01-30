import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root',
})
export class Auto {

  private apiUrl = 'http://localhost:8080/vehiculos'; // AJUSTA TU URL

  constructor(private http: HttpClient) { }

  guardarAuto(auto: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/registrar`, auto);
  }

}
