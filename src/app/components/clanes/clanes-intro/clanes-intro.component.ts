import { Component, OnInit } from '@angular/core';
import { Clanes } from 'src/app/shared/interfaces/clanes';

@Component({
  selector: 'app-clanes-intro',
  templateUrl: './clanes-intro.component.html',
  styleUrls: ['./clanes-intro.component.css']
})
export class ClanesIntroComponent implements OnInit{

  listaClanes!: Clanes[]
  static listaEstatica: Clanes[]


  ngOnInit(): void {
    this.generateVillas();
  }

  generateVillas() {
    this.listaClanes = [{
      id_clan: 1,
      nombre: "Clan Uchiha",
      descripcion: "El Clan Uchiha se encontraba en Konoha. Este clan fue extinto por uno de sus ninjas, Itachi Uchiha, dejando libre solamente a Sasuke Uchiha. Este Clan posee un Kekkei Genkai de Doujutsu. Su doujutsu se basaba en administrar chakra a su ojo activando el Sharingan, el cual era capaz de adelantar e imitar los movimientos del enemigo, su activación tiene distintas fases, por las cuales su desempeño va avanzando, depende de los tipos de chakra del miembro del Clan puede incluso crear los jutsus del enemigo. Estos ojos son considerados uno de los más potentes, ya que son capaces de imitar Taijutsu, Genjutsu, Ninjutsu, a excepción de los Kekkei Genkai. Se han conocido varios casos en que se incrusta un ojo Sharingan en personas, requiriendo un mayor gasto de chakra y energía por parte de ellos. Fueron parte del Clan fundador de Konoha y fundadores de la policía de Konoha, a la vez intentaron destruir Konoha, por lo que Itachi los eliminó.",
      habilidades: "Los Uchiha eran famosos por tener grandes reservas de un chakra muy fuerte y jutsus formidables y la aptitud natural para todo lo relacionado con el combate. Aún así, su principal habilidad era su admirable y eficaz Sharingan.",
      imagen: "assets/clanes/uchiha.png"
  },
    {
      id_clan: 2,
      nombre: "Clan Uzumaki",
      descripcion: "El Clan Uzumaki era un Clan perteneciente del País del Remolino, este país era específicamente conocido por este Clan. La habilidad especial de este clan recae en la gran cantidad de jutsus de sellado conocidos. Además de conocerlos, los emplean de forma excelente, siendo temidos por el resto de los países ya que pueden sucumbir frente a la gran cantidad y variedad de sellados y poseían una larga juventud y longevidad durando mas tiempo que cualquier otra persona. A causa de este poder el Clan fue exterminado entre las guerras para evitar el gran poder. Poseía vínculos lejanos con el Clan Senju, y los sobrevivientes al ataque se dispersaron por el mundo y enseñaron sus jutsus de sellado para promulgar su legado.",
      habilidades: "Los Uzumaki eran conocidos por su uso del Fūinjutsu, empleando sellos que se asimilaban al emblema del clan.",
      imagen: "assets/clanes/uzumaki.png"
    },
    {
      id_clan: 3,
      nombre: "Clan Senju",
      descripcion: "El Clan Senju del Bosque es al igual que el Clan Uchiha considerado uno de los mas poderosos del mundo ninja. Este clan estuvo en guerra con los Uchiha (comandados por Uchiha Madara) por mucho tiempo,hasta que se aliaron y formaron la aldea oculta de Konoha junto al país del fuego. El clan esta aparentemente extinto a pesar de que tiene descendientes aun vivos (como la Hokage Tsunade Senju).",
      habilidades: "Los Senju, descendían de manera directa del Sabio de los Seis Caminos. Gracias a este linaje, los Senju tenderían a heredar de manera innata el Elemento Yang también. Otro aspecto destacable es que, llegaron a ser excelentes maestros en todas las habilidades Ninjutsu, Taijutsu y Genjutsu, hasta el punto de ser conocido como 'El Clan de las Mil Habilidades'",
      imagen: "assets/clanes/senju.png"
    },
    {
      id_clan: 4,
      nombre: "Clan Nara",
      descripcion: "El Clan Nara se encuentra en Konoha. Sus ninjas desarrollan la habilidad de usar las sombras, siendo capaces de atrapar a los enemigos sin darles libertad de movimiento. Su Clan posee un bosque donde crían y cuidan Ciervos, y de esa forma se pueden extraer de sus cuernos ingredientes para realizar recetas de curación y medicamentos que han salvado incluso de la muerte. Sus ninjas son caracterizados por un aspecto de vagos y despreocupados, pero leales a la vez, dotados de una gran inteligencia suelen ser llamados a ser estrategas en las batallas. Con su capacidad de apoderarse de las sombras de sus enemigos pueden paralizar y obligar a estos a imitar los movimientos del agresor, es el movimiento más común dentro del Clan, del Jutsu: Posesión de Sombra, derivan más técnicas.",
      habilidades: "Los miembros de este clan se conocen principalmente por que tienen un Jutsu Secreto que les permite manipular sus sombras para sus propios beneficios.",
      imagen: "assets/clanes/nara.png"
    },
  ]

  ClanesIntroComponent.listaEstatica = this.listaClanes;
}

}
