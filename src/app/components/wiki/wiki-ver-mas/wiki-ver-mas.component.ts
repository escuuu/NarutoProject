import { Component, OnInit } from '@angular/core';
import { WikiListadoComponent } from '../wiki-listado/wiki-listado.component';

@Component({
  selector: 'app-wiki-ver-mas',
  templateUrl: './wiki-ver-mas.component.html',
  styleUrls: ['./wiki-ver-mas.component.css']
})
export class WikiVerMasComponent implements OnInit{

  selectedPersonaje = WikiListadoComponent.personaje_seeMore;

  constructor() {

  }

  ngOnInit(): void {
    this.refresh();
    console.log(this.selectedPersonaje);
  }

  refresh(): void {

    if(this.selectedPersonaje != undefined) {
      localStorage.setItem('personaje', JSON.stringify(this.selectedPersonaje));
    }

    this.selectedPersonaje = JSON.parse(localStorage.getItem('personaje') || "[]");
  }
}
