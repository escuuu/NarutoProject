import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Personajes } from 'src/app/shared/interfaces/personajes';

@Component({
  selector: 'app-wiki-listado',
  templateUrl: './wiki-listado.component.html',
  styleUrls: ['./wiki-listado.component.css']
})
export class WikiListadoComponent implements OnInit{

  @Input() public personaje!: Personajes;
  static personaje_seeMore: Personajes;

  constructor(private router: Router) {
    this.personaje = {
      id_personaje: 0,
      nombre: '',
      apellido: '',
      descripcion: '',
      rango: '',
      imagen: ''
    }
  }

  ngOnInit(): void {

  }

  seeMore(): void {
    WikiListadoComponent.personaje_seeMore = this.personaje;
    this.router.navigate(['/wiki', this.personaje.nombre]);
  }
}
