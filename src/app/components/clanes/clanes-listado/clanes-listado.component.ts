import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Clanes } from 'src/app/shared/interfaces/clanes';

@Component({
  selector: 'app-clanes-listado',
  templateUrl: './clanes-listado.component.html',
  styleUrls: ['./clanes-listado.component.css']
})
export class ClanesListadoComponent {
  @Input() public clan!: Clanes;
  static clan_seeMore: Clanes;

  constructor(private router: Router) {
    this.clan = {
      id_clan: 0,
      nombre: '',
      descripcion: '',
      habilidades: '',
      imagen: ''
    }
  }

  ngOnInit(): void {

  }

  seeMore(): void {
    ClanesListadoComponent.clan_seeMore = this.clan;
    this.router.navigate(['/clanes', this.clan.nombre]);
  }
}
