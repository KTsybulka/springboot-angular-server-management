import { HttpBackend, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomResponse } from '../interfac/custom-response';
import { Observable } from 'rxjs';

@Injectable({  providedIn: 'root'})

export class ServerService {

  constructor(private http: HttpClient) { }

  getServer() : Observable<CustomResponse>{
    return this.http.get<CustomResponse>('http://localhost:8080/server/list');
  }
}
