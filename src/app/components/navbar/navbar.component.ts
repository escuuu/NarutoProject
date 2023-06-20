import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent implements OnInit {

  token: any = localStorage.getItem('token');

  constructor() {}

  ngOnInit(): void {
    console.log(this.token);
  }


  eliminarSesion(): void{
    localStorage.clear();
    location.reload();
  }
}
