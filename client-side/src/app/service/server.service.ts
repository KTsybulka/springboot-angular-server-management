import { HttpBackend, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomResponse } from '../interfac/custom-response';
import { catchError, Observable, tap, throwError } from 'rxjs';

@Injectable({  providedIn: 'root'})

export class ServerService {


  private readonly apiUrl = 'any';

  constructor(private http: HttpClient) { }

  severs$ = <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/server/list`)
  .pipe(
    tap(console.log),
    catchError(this.handlerError)
  );


  handlerError(error: any): Observable<never> {
    return throwError ('Method not implemented.');
  }
}
