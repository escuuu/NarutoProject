package com.joyfe.naruto.des.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyfe.naruto.des.entity.Clan;
import com.joyfe.naruto.des.entity.Elementos;
import com.joyfe.naruto.des.entity.Organizaciones;
import com.joyfe.naruto.des.entity.Personajes;
import com.joyfe.naruto.des.entity.Villas;
import com.joyfe.naruto.des.execption.NotFound;
import com.joyfe.naruto.des.execption.NullPoint;
import com.joyfe.naruto.des.repository.PersonajeDAO;

@Service
public class PersonajeService {

	@Autowired
	private PersonajeDAO dao;
	@Autowired
	private ClanService cs;
	@Autowired
	private OrganizacionService os;
	@Autowired
	private ElementoService es;
	@Autowired
	private VillaService vs;
	
	
	public boolean crearPersonaje(Personajes personaje) throws NullPoint{
			
		List<Clan> clan = cs.bucarClanNombre(personaje.getClan().getNombre());
		List<Elementos> elemento = new ArrayList<>();
		for (int i = 0; i < personaje.getElementos().size(); i++) {
			elemento.addAll(es.buscarElementoByName(personaje.getElementos().get(i).getNombre()));
		}
		List<Villas> villa = vs.bucarVillaNombre(personaje.getVillas().getNombre());
		List<Organizaciones> orga = os.bucarOrganizacionByName(personaje.getOrganizaciones().getNombre());
			
		orga.get(0).setNum_miembro(os.n_miembros(orga.get(0).getNombre()));
			
		Personajes nuevopersonaje = new Personajes(personaje.getNombre(), personaje.getEdad(), personaje.getEstado(),
			clan.get(0), villa.get(0), elemento, orga.get(0));
			
		return dao.registrarPersonaje(nuevopersonaje);

	}
	public Optional<Personajes> bucarPersonajeById(Long id) {
			
			Optional<Personajes> per = dao.buscarPersonajeById(id);
			
			if(per.isEmpty()) {
				
				throw new NotFound("No se ha encontrado dicho id: " + id);
				
			}else {
			
				List<Organizaciones> orga = os.bucarOrganizacionByName(per.get().getOrganizaciones().getNombre());
				
				orga.get(0).setNum_miembro(os.n_miembros(orga.get(0).getNombre()));
				per.get().setOrganizaciones(orga.get(0));
				return per;	

			}
		}
	
	public boolean eliminarPersonaje(Long id) throws NotFound {
		
			Optional<Personajes> personaje = dao.buscarPersonajeById(id);
			
			if(personaje.isPresent()) {
				
				List<Organizaciones> orga = os.bucarOrganizacionByName(personaje.get().getOrganizaciones().getNombre());
				
				orga.get(0).setNum_miembro(os.n_miembros(orga.get(0).getNombre()));
				dao.eliminarPersonaje(id);
				return true;
			}
			else {
				
				throw new NotFound("No se ha encontrado este id");
			}
		}
	public boolean editarPersonaje(Personajes personaje) throws NotFound {
				
			List<Clan> clan = cs.bucarClanNombre(personaje.getClan().getNombre());
			List<Elementos> elemento = new ArrayList<>();
			for (int i = 0; i < personaje.getElementos().size(); i++) {
				elemento.addAll(es.buscarElementoByName(personaje.getElementos().get(i).getNombre()));
			}
			List<Villas> villa = vs.bucarVillaNombre(personaje.getVillas().getNombre());
			List<Organizaciones> orga = os.bucarOrganizacionByName(personaje.getOrganizaciones().getNombre());
			orga.get(0).setNum_miembro(os.n_miembros(personaje.getOrganizaciones().getNombre()));
			
			personaje.setClan(clan.get(0));
			personaje.setElementos(elemento);
			personaje.setVillas(villa.get(0));
			personaje.setOrganizaciones(orga.get(0));
			
			
			dao.editarPersonaje(personaje);
			return true;

	}
	
	public List<Personajes> buscarPersonajes(){
		
		List<Personajes> per = dao.buscarPersonajes();
		
		for (int i = 0; i < per.size(); i++) {
			
			List<Organizaciones> orga = os.bucarOrganizacionByName(per.get(i).getOrganizaciones().getNombre());
			
			orga.get(0).setNum_miembro(os.n_miembros(orga.get(0).getNombre()));
		}
		
		return per;
	}
}
