import { Component, OnInit } from '@angular/core';
import { Villas } from 'src/app/shared/interfaces/villas';

@Component({
  selector: 'app-villas-intro',
  templateUrl: './villas-intro.component.html',
  styleUrls: ['./villas-intro.component.css']
})
export class VillasIntroComponent implements OnInit{

  listaVillas!: Villas[]


  ngOnInit(): void {
    this.generateVillas();
  }

  generateVillas() {
    this.listaVillas = [{
      id_villa: 1,
      nombre: "Konohagakure",
      fundador: "Hashirama Senju",
      nacion: "País del Fuego.",
      kage: "Hokage",
      descripcion: "Konohagakure (木ノ葉隠れの里, Konohagakure no Sato, literalmente significa 'Aldea Oculta Entre las Hojas', también conocida como 'Aldea Oculta en las Hojas' o 'Aldea Oculta de la Hoja') es la aldea oculta del País del Fuego. Como una de las Cinco Grandes Aldeas Ninja, Konoha tiene un Kage cómo líder conocido como el Hokage. En total, Konoha, ha tenido siete Hokages, siendo Naruto Uzumaki el actual. En una montaña que domina el pueblo desde el norte se eleva la Roca Hokage. A pesar de que Konoha, al igual que el país en el que reside, ha sido relativamente pacífica desde el final de la Cuarta Gran Guerra Mundial Shinobi, sigue siendo uno de los pueblos más poderosos que existen, teniendo un gran poder militar e influencia, aunque esto había disminuido hace unos años por los ataques de Orochimaru y Pain.",
      imagen: "https://wallpapercave.com/wp/wp5845271.jpg"
  },
    {
      id_villa: 2,
      nombre: "Kirigakure",
      fundador: "Uzumaki",
      nacion: "País del Agua",
      kage: "Mizukage",
      descripcion: "Kirigakure (霧隠れの里, Kirigakure no sato, que significa literalmente 'Aldea Oculta de la Niebla'), también conocida como la Aldea de la Niebla Sangrienta (血霧の里, Chigiri no Sato) es una aldea ninja que se encuentra en el País del Agua. Al ser una de las grandes aldeas shinobi, tiene un Kage, que es el líder de la aldea conocido con el titulo de Mizukage, hasta ahora han sido seis, el más reciente es Chōjūrō. Los shinobis de esta aldea son muy hábiles en el uso de técnicas de Elemento Agua.",
      imagen: "https://static.wikia.nocookie.net/naruto/images/1/17/Kirigakure_Actualidad_Anime.png"
    },
    {
      id_villa: 3,
      nombre: "Kumogakure",
      fundador: "A",
      nacion: "País del Rayo",
      kage: "Raikage",
      descripcion: "Kumogakure (雲隠れの里, Kumogakure no Sato; literalmente 'Aldea Oculta de las Nubes') es la Aldea Oculta del País del Rayo. Como una de las Cinco Grandes Aldeas Shinobi, Kumogakure posee su propio Kage, un líder conocido como el Raikage. Cinco ninjas han estado en el puesto, el más reciente es Darui. El uso de técnicas de Elemento Rayo y del Kenjutsu parecen ser comunes en los ninjas de la aldea. Fue la única de las Cinco Grandes Aldeas que nunca tuvo un prófugo en Akatsuki,algo de lo que el Cuarto Raikage se enorgullecía.",
      imagen: "https://as.com/meristation/imagenes/2017/08/22/album/1503399720_399720_000004_album_normal.png"
    },
    {
      id_villa: 4,
      nombre: "Iwagakure",
      fundador: "Ishikawa",
      nacion: "País de la Tierra",
      kage: "Tsuchikage",
      descripcion: "Iwagakure (岩隠れの里, Iwagakure no Sato, literalmente significa 'Aldea Oculta entre las Rocas') es un aldea ninja que se encuentra en el País de la Tierra. Como es una de las Cinco Grandes Aldeas Shinobis tiene un Kage, que es el líder del pueblo conocido con el título de Tsuchikage, actualmente ha habido cuatro, siendo la más reciente Kurotsuchi. Los ninjas de esta aldea se especializan en el uso de técnicas que utilizan la naturaleza tipo Tierra. Además, se sabe que esta aldea ha tenido en su posesión dos bestias con colas: el Cuatro Colas y al Cinco Colas.",
      imagen: "assets/Aldea_Oculta_de_la_Roca.png"
    },
  ]
}

}
