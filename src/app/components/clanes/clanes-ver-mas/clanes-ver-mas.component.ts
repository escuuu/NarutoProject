import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgbCarousel } from '@ng-bootstrap/ng-bootstrap';
import { ClanesIntroComponent } from '../clanes-intro/clanes-intro.component';
import { ClanesListadoComponent } from '../clanes-listado/clanes-listado.component';

@Component({
  selector: 'app-clanes-ver-mas',
  templateUrl: './clanes-ver-mas.component.html',
  styleUrls: ['./clanes-ver-mas.component.css']
})
export class ClanesVerMasComponent implements OnInit{

  @ViewChild('carousel')
  carousel!: NgbCarousel;

  selectedClan = ClanesListadoComponent.clan_seeMore;

  listaClanes = ClanesIntroComponent.listaEstatica;

  idMenos: any

  activeId: string = '';

  constructor(private router: Router) {

  }

  ngOnInit(): void {
    this.refresh();
    console.log(this.selectedClan.id_clan);
  }

  refresh(): void {
    if(this.listaClanes != undefined && this.selectedClan != undefined) {
      localStorage.setItem('personaje', JSON.stringify(this.selectedClan));
      localStorage.setItem('listaVillas', JSON.stringify(this.listaClanes));
    }
    this.selectedClan = JSON.parse(localStorage.getItem('personaje') || "[]");
    this.listaClanes = JSON.parse(localStorage.getItem('listaVillas') || "[]");

    this.idMenos = this.selectedClan.id_clan - 1;
    this.activeId = this.idMenos.toString();

  }

  onItemChange(event: any) {
    console.log(event);
  }
}
