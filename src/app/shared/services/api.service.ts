import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../classes/user';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  api_url: string = 'http://localhost:8080/';

  constructor(private http: HttpClient, private router: Router) { }


  login(user: string, password: string): Observable<any> {

    const logueo = this.http.get<any>(`${this.api_url}login?gmail=`+ user + '&pass=' + password);

    // const token: string = '1234';
    // if(token) {
    //   localStorage.setItem('token', token);
    //   this.router.navigate(['/wiki']);
    // }

    return logueo;
  }

  registro(usuario: User): Observable<User> {

    const registro = this.http.post<User>(`${this.api_url}register`, usuario);

    return registro;
  }
}
