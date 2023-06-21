import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../entitys/user';
import { Personaje } from '../entitys/personaje';
import { Clan } from '../entitys/clan';
import { Villa } from '../entitys/villa';
import { Organizacion } from '../entitys/organizaciones';
import { Elementos } from '../entitys/elementos';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  api_url: string = 'http://localhost:8080/';

  constructor(private http: HttpClient, private router: Router) { }

//Usuario
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




  //Personaje**********************************************************
  añadirPersonaje(personaje: Personaje): Observable<Personaje>{

    return this.http.post<Personaje>(`${this.api_url}naruto/personajes`, personaje);
  }

  listaPersonaje(): Observable<Personaje>{

    return this.http.get<Personaje>(`${this.api_url}naruto/personajes`);
  }

  eliminarPersonaje(id:number): Observable<Personaje>{
    
    return this.http.delete<Personaje>(`${this.api_url}naruto/personajes/` + id);
  }
  findByidPersonaje(id:number): Observable<Personaje>{
    
    return this.http.get<Personaje>(`${this.api_url}naruto/personajes/` + id);
  }
  editarPersonaje(id:number, personaje:Personaje): Observable<Personaje>{
    
    return this.http.put<Personaje>(`${this.api_url}naruto/personajes/` + id, personaje);
  }




  //Clan****************************************************************
  añadirClan(clan: Clan): Observable<Clan>{

    return this.http.post<Clan>(`${this.api_url}naruto/clan`, clan);
  }

  listaClan(): Observable<Clan>{

    return this.http.get<Clan>(`${this.api_url}naruto/clan`);
  }
  eliminarClan(id:number): Observable<Clan>{
    
    return this.http.delete<Clan>(`${this.api_url}naruto/clan/` + id);
  }
  findByidClan(id:number): Observable<Clan>{
    
    return this.http.get<Clan>(`${this.api_url}naruto/clan/` + id);
  }
  editarClan(id:number, clan:Clan): Observable<Clan>{
    
    return this.http.put<Clan>(`${this.api_url}naruto/clan/` + id, clan);
  }




  //Villas*********************************************************************
  añadirVilla(villa: Villa): Observable<Villa>{

    return this.http.post<Villa>(`${this.api_url}naruto/villa`, villa);
  }
  
  listaVilla(): Observable<Villa>{
  
    return this.http.get<Villa>(`${this.api_url}naruto/villa`);
  }
  eliminarVilla(id:number): Observable<Villa>{
    
    return this.http.delete<Villa>(`${this.api_url}naruto/villa/` + id);
  }
  findByidVilla(id:number): Observable<Villa>{
    
    return this.http.get<Villa>(`${this.api_url}naruto/villa/` + id);
  }
  editarVilla(id:number, villa:Villa): Observable<Villa>{
    
    return this.http.put<Villa>(`${this.api_url}naruto/villa/` + id, villa);
  }



  //Organizaciones***************************************************************
  añadirOrg(org: Organizacion): Observable<Organizacion>{

    return this.http.post<Organizacion>(`${this.api_url}naruto/organizacion`, org);
  }
  
  listaOrg(): Observable<Organizacion>{
  
    return this.http.get<Organizacion>(`${this.api_url}naruto/organizacion`);
  }
  eliminarOrg(id:number): Observable<Organizacion>{
    
    return this.http.delete<Organizacion>(`${this.api_url}naruto/organizacion/` + id);
  }
  findByidOrg(id:number): Observable<Organizacion>{
    
    return this.http.get<Organizacion>(`${this.api_url}naruto/organizacion/` + id);
  }
  editarOrg(id:number, org:Organizacion): Observable<Organizacion>{
    
    return this.http.put<Organizacion>(`${this.api_url}naruto/organizacion/` + id, org);
  }




  //Elementos***************************************************************************
  añadirElemento(ele: Elementos): Observable<Elementos>{

    return this.http.post<Elementos>(`${this.api_url}naruto/elemento`, ele);
  }
  
  listaElementos(): Observable<Elementos>{
  
    return this.http.get<Elementos>(`${this.api_url}naruto/elemento`);
  }
  eliminarElemento(id:number): Observable<Elementos>{
    
    return this.http.delete<Elementos>(`${this.api_url}naruto/elemento/` + id);
  }
  findByidElemento(id:number): Observable<Elementos>{
    
    return this.http.get<Elementos>(`${this.api_url}naruto/elemento/` + id);
  }
  eliditarElemento(id:number, elemento:Elementos): Observable<Elementos>{
    
    return this.http.put<Elementos>(`${this.api_url}naruto/elemento/` + id, elemento);
  }



}
