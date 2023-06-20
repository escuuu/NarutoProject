import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/classes/user';
import { Personajes } from 'src/app/shared/interfaces/personajes';

@Component({
  selector: 'app-wiki',
  templateUrl: './wiki.component.html',
  styleUrls: ['./wiki.component.css']
})
export class WikiComponent implements OnInit{

  usuario:User|any = localStorage.getItem('user');
  constructor() {}

  ngOnInit(): void {
    console.log(this.usuario);
    this.usuario = JSON.parse(this.usuario);
    console.log(this.usuario);

  }

}
