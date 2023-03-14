import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Villas } from 'src/app/shared/interfaces/villas';

@Component({
  selector: 'app-villas-listado',
  templateUrl: './villas-listado.component.html',
  styleUrls: ['./villas-listado.component.css']
})
export class VillasListadoComponent {

  @Input() public villa!: Villas;
  static villa_seeMore: Villas;

  constructor(private router: Router) {
    this.villa = {
      id_villa: 0,
      nombre: '',
      fundador: '',
      nacion: '',
      kage: '',
      descripcion: ''
    }
  }

  ngOnInit(): void {

  }

  seeMore(): void {
    VillasListadoComponent.villa_seeMore = this.villa;
    this.router.navigate(['/villas', this.villa.nombre]);
  }
}
