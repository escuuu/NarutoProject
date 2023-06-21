import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/entitys/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent implements OnInit {

  token: any = localStorage.getItem('token');
  usuario:User|any = localStorage.getItem('user');
  constructor() {}

  ngOnInit(): void {

    this.usuario = JSON.parse(this.usuario);

  }

  eliminarSesion(): void{
    localStorage.clear();
    location.reload();
  }
}
