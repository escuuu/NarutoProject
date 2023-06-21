import { Clan } from "./clan";
import { Elementos } from "./elementos";
import { Organizacion } from "./organizaciones";
import { Villa } from "./villa";

export class Personaje{
    id_personaje?: number;
    nombre?: string;
    edad?: number;
    estado?: string;
    clan?: Clan;
    villas?: Villa
    organizaciones?: Organizacion;
    elementos?: Elementos[];
}