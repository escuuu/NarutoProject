import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  api_url: string = 'http://localhost:8080/';

  constructor(private http: HttpClient, private router: Router) { }


  login(user: string, password: string): Observable<any> {

    const logueo = this.http.get<any>(`${this.api_url}login?nick=`+ user + '&pass=' + password);

    // const token: string = '1234';
    // if(token) {
    //   localStorage.setItem('token', token);
    //   this.router.navigate(['/wiki']);
    // }

    return logueo;
  }

  registro(nombre: string, apellidos: string, nick: string, email: string, password: string): Observable<any> {

    const new_user = {nombre, apellidos, nick, email, password};
    const registro = this.http.post<any>(`${this.api_url}register`, new_user);

    return registro;
  }
}
