import { Component, OnInit } from '@angular/core';
import { Personajes } from 'src/app/shared/interfaces/personajes';

@Component({
  selector: 'app-wiki-intro',
  templateUrl: './wiki-intro.component.html',
  styleUrls: ['./wiki-intro.component.css']
})
export class WikiIntroComponent implements OnInit{
  listadoPersonajes: Personajes[] = [];

  constructor() {}

  ngOnInit(): void {
    this.generatePersonajes();
  }

  generatePersonajes() {
      this.listadoPersonajes = [{
        id_personaje: 1,
        nombre: "Naruto",
        apellido: "Uzumaki",
        descripcion: "Naruto Uzumaki (うずまきナルト, Uzumaki Naruto) es el protagonista de la serie del manga y anime Naruto y Naruto Shippūden. Asimismo es partícipe del manga y anime Boruto: Naruto Next Generations, secuela de la obra original de Masashi Kishimoto. Es residente de Konohagakure, hijo del Cuarto Hokage, Minato Namikaze y su esposa Kushina Uzumaki, además de ser la actual reencarnación de Asura Ōtsutsuki.Fue miembro del Equipo Kakashi junto a Sakura Haruno y Sasuke Uchiha. Actualmente es el Séptimo Hokage (七代目火影, Nanadaime Hokage; literalmente «Séptima Sombra del Fuego») de Konoha, cumpliendo su sueño, así como también el esposo de Hinata Hyūga y padre de Boruto Uzumaki y Himawari Uzumaki.",
        rango: "Kage",
        imagen: "https://www.somosxbox.com/wp-content/uploads/2022/10/Naruto.jpg"
      },
      {
        id_personaje: 2,
        nombre: "Kakashi",
        apellido: "Hatake",
        descripcion: "Kakashi Hatake (はたけカカシ, Hatake Kakashi) es un shinobi de Konohagakure. Fue un Jōnin, ex-ANBU y el líder del Equipo 7. Fue conocido mundialmente por su uso del Sharingan, lo que le valió el apodo de Kakashi el Ninja que Copia (コピー忍者のカカシ, Kopi Ninja no Kakashi) y Kakashi del Sharingan (写輪眼のカカシ, Sharingan no Kakashi). En su adolescencia fue alumno de Minato Namikaze y compañero de equipo de Obito Uchiha y Rin Nohara. También fue el capitán de la Tercera División de la Gran Alianza Shinobi. Después de los acontecimientos de la Cuarta Guerra Mundial Shinobi, Kakashi se convirtió en el Sexto Hokage (六代目火影, Rokudaime Hokage; que significa 'Sexta Sombra del Fuego') de Konoha.",
        rango: "Kage",
        imagen: "https://i0.wp.com/codigoespagueti.com/wp-content/uploads/2022/07/Naruto-Por-que-Kakashi-no-puede-desactivar-su-Sharingan.jpg?fit=1280%2C720&quality=80&ssl=1"
      },
      {
        id_personaje: 3,
        nombre: "Sasuke",
        apellido: "Uchiha",
        descripcion: "Sasuke Uchiha (うちはサスケ, Uchiha Sasuke) es el deuteragonista de la serie y uno de los supervivientes del Clan Uchiha. Es hijo de Fugaku Uchiha y Mikoto Uchiha, hermano de Itachi Uchiha, así como la Reencarnación actual de Indra Ōtsutsuki. A pesar de crear relaciones con los miembros del Equipo Kakashi, Sasuke decidió desertar de Konohagakure en busca del poder necesario para vengar a su clan y asesinar a Itachi. Después de descubrir la verdad de su hermano, fundó Taka, fue un aliado temporal de Akatsuki y se convirtió en un criminal internacional. Después de hablar con Hashirama Senju decidió seguir el sueño de su hermano, colaborar con las Fuerzas Aliadas Shinobi y se colocó como meta realizar una revolución en el Mundo Shinobi. Después de la Cuarta Guerra Mundial Shinobi, terminaría cediendo ante la mentalidad de Naruto Uzumaki, regresando a la aldea y dedicando su vida a protegerla y a sus habitantes, pasando a ser referido como el Kage de Soporte (支う影, Sasaukage; literalmente «Sombra de Soporte»). Igualmente, se volvió el esposo de Sakura Haruno y padre de Sarada Uchiha.",
        rango: "Sin rango",
        imagen: "https://areajugones.sport.es/wp-content/uploads/2020/03/sasuke-min.jpg"
      }
    ]
  }

}
