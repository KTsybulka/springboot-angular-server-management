import { HttpBackend, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomResponse } from '../interfac/custom-response';
import { catchError, Observable, Subscriber, tap, throwError } from 'rxjs';

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

  save$ = (server: Server) => <Observable<CustomResponse>>
  this.http.post<CustomResponse>(`${this.apiUrl}/server/save`, server)
  .pipe(
    tap(console.log),
    catchError(this.handlerError)
  );

  ping$ = (ipAddress: string) => <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/server/ping/${ipAddress}`)
  .pipe(
    tap(console.log),
    catchError(this.handlerError)
  );

  filter$ = (status: Status, response: CustomResponse) => <Observable<CustomResponse>>
  new Observable<CustomResponse>(
    subscriber => {
      console.log(response);
      subscriber.next(
        status === Status.ALL ? { ...response, message: `Servers filtered by ${status} status`} : 
        {...response,
          message: response.data.servers?
          .filter(server => server.status === status).length > 0 ? `Servers filtered by 
          ${status === Status.SERVEER_UP ? 'Server UP' 
            : 'Server DOWN'} status` : 'No server of ${status} founf', 
            data: {serveers: response.data.servers
              .filter(server => server.status === status)}
        }
      );
      subscriber.complete();
    }
  .pipe(
    tap(console.log),
    catchError(this.handlerError)
  );


  delete$ = (serverId: number) => <Observable<CustomResponse>>
  this.http.delete<CustomResponse>(`${this.apiUrl}/server/delete/${serverId}`)
  .pipe(
    tap(console.log),
    catchError(this.handlerError)
  );

  private handlerError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(`An error occurred - Error code: ${error.status}`);
  }
}
