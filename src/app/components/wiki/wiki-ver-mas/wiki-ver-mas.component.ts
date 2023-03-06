import { Component, OnInit, ViewChild } from '@angular/core';
import { WikiIntroComponent } from '../wiki-intro/wiki-intro.component';
import { WikiListadoComponent } from '../wiki-listado/wiki-listado.component';
import { NgbCarousel, NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-wiki-ver-mas',
  templateUrl: './wiki-ver-mas.component.html',
  styleUrls: ['./wiki-ver-mas.component.css']
})
export class WikiVerMasComponent implements OnInit{

  @ViewChild('carousel')
  carousel!: NgbCarousel;

  selectedPersonaje = WikiListadoComponent.personaje_seeMore;

  listaPersonajes = WikiIntroComponent.listaEstatica;

  idMenos: any

  activeId: string = '';

  constructor(private router: Router) {

  }

  ngOnInit(): void {
    this.refresh();
    console.log(this.selectedPersonaje.id_personaje);
  }

  refresh(): void {
    if(this.listaPersonajes != undefined && this.selectedPersonaje != undefined) {
      localStorage.setItem('personaje', JSON.stringify(this.selectedPersonaje));
      localStorage.setItem('listaPersonajes', JSON.stringify(this.listaPersonajes));
    }
    this.selectedPersonaje = JSON.parse(localStorage.getItem('personaje') || "[]");
    this.listaPersonajes = JSON.parse(localStorage.getItem('listaPersonajes') || "[]");

    this.idMenos = this.selectedPersonaje.id_personaje - 1;
    this.activeId = this.idMenos.toString();

  }

  onItemChange(event: any) {
    console.log(event);
  }
}
