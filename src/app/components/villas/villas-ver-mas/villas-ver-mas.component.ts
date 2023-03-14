import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgbCarousel } from '@ng-bootstrap/ng-bootstrap';
import { VillasIntroComponent } from '../villas-intro/villas-intro.component';
import { VillasListadoComponent } from '../villas-listado/villas-listado.component';

@Component({
  selector: 'app-villas-ver-mas',
  templateUrl: './villas-ver-mas.component.html',
  styleUrls: ['./villas-ver-mas.component.css']
})
export class VillasVerMasComponent implements OnInit{

  @ViewChild('carousel')
  carousel!: NgbCarousel;

  selectedPersonaje = VillasListadoComponent.villa_seeMore;

  listaVillas = VillasIntroComponent.listaEstatica;

  idMenos: any

  activeId: string = '';

  constructor(private router: Router) {

  }

  ngOnInit(): void {
    this.refresh();
    console.log(this.selectedPersonaje.id_villa);
  }

  refresh(): void {
    if(this.listaVillas != undefined && this.selectedPersonaje != undefined) {
      localStorage.setItem('personaje', JSON.stringify(this.selectedPersonaje));
      localStorage.setItem('listaVillas', JSON.stringify(this.listaVillas));
    }
    this.selectedPersonaje = JSON.parse(localStorage.getItem('personaje') || "[]");
    this.listaVillas = JSON.parse(localStorage.getItem('listaVillas') || "[]");

    this.idMenos = this.selectedPersonaje.id_villa - 1;
    this.activeId = this.idMenos.toString();

  }

  onItemChange(event: any) {
    console.log(event);
  }
}
