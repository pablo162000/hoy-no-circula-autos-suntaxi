import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root',
})
export class Auto {

  private apiUrl = `${environment.apiUrl}/vehiculos`;

  constructor(private http: HttpClient) { }

  guardarAuto(auto: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/registrar`, auto).pipe(
      catchError((error: HttpErrorResponse) => {
        return throwError(() => error);
      })
    );
  }

  consultarCirculacion(placa: string, fechaHora: string): Observable<any> {
    const params = new HttpParams()
      .set('placa', placa)
      .set('fechaHora', fechaHora);

    return this.http.get<any>(`${this.apiUrl}/consultar`, { params }).pipe(
      catchError((error: HttpErrorResponse) => {
        return throwError(() => error);
      })
    );
  }

  listarAutos(): Observable<Auto[]> {
    return this.http.get<Auto[]>(this.apiUrl);
  }

}
