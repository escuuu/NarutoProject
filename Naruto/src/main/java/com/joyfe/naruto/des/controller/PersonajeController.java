package com.joyfe.naruto.des.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joyfe.naruto.des.entity.Clan;
import com.joyfe.naruto.des.entity.Elementos;
import com.joyfe.naruto.des.entity.Organizaciones;
import com.joyfe.naruto.des.entity.Personajes;
import com.joyfe.naruto.des.entity.Villas;
import com.joyfe.naruto.des.execption.NotFound;
import com.joyfe.naruto.des.execption.NullPoint;
import com.joyfe.naruto.des.service.PersonajeService;

import jakarta.validation.Valid;

@RestController    
@RequestMapping("/naruto")		
public class PersonajeController {
	
	final static String port = "4200";

	@Autowired
	PersonajeService ps;
	
	@PostMapping(path="personajes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Personajes> crearPersonaje(@RequestBody @Valid  Personajes personaje) throws URISyntaxException, NullPoint {
		
		Organizaciones organizacion = new Organizaciones(personaje.getOrganizaciones().getNombre());
		Villas villa = new Villas(personaje.getVillas().getNombre());
		Clan clan = new Clan(personaje.getClan().getNombre());
		
		List<Elementos> listeElementos = new ArrayList<>();
		
		for (int i = 0; i < personaje.getElementos().size(); i++) {
			
			Elementos newEle = new Elementos(personaje.getElementos().get(i).getNombre());
			listeElementos.add(newEle);
		}
		
		Personajes nuevopersonaje = new Personajes(personaje.getNombre(), personaje.getEdad(), personaje.getEstado(), clan, villa, listeElementos, organizacion);
		
		ps.crearPersonaje(nuevopersonaje);
		
		return ResponseEntity.created(new URI("/personajes/"+nuevopersonaje.getId_personaje())).body(nuevopersonaje);
		
	}
	
	@GetMapping(path="/personajes/{idper}")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Optional<Personajes>> obtenerPersonajeById(@PathVariable long idper) {
			
			return ResponseEntity.ok().body(ps.bucarPersonajeById(idper));
			
		}
	
	@DeleteMapping(path="/personajes/{idper}")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Object> borrarPersonaje(@PathVariable Long idper) throws NotFound {
		
		if (idper != null){
			
				ps.eliminarPersonaje(idper);
			
			try {
				return ResponseEntity.created(new URI("/personajes/" + idper)).body(ps.bucarPersonajeById(idper));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.ok().body("");
			}
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping(path="/personajes/{idper}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Personajes> actualizarPersonaje(@PathVariable @Valid long idper, @RequestBody Personajes personaje) throws  NotFound {
			
			Organizaciones organizacion = new Organizaciones(personaje.getOrganizaciones().getNombre());
			Villas villa = new Villas(personaje.getVillas().getNombre());
			Clan clan = new Clan(personaje.getClan().getNombre());
			List<Elementos> listeElementos = new ArrayList<>();
			
			for (int i = 0; i < personaje.getElementos().size(); i++) {
				
				Elementos newEle = new Elementos(personaje.getElementos().get(i).getNombre());
				listeElementos.add(newEle);
			}
		
			Personajes personajeupdate = new Personajes();
			personajeupdate.setId_personaje(idper);
			personajeupdate.setNombre(personaje.getNombre());
			personajeupdate.setEdad(personaje.getEdad());
			personajeupdate.setEstado(personaje.getEstado());
			personajeupdate.setClan(clan);
			personajeupdate.setElementos(listeElementos);
			personajeupdate.setOrganizaciones(organizacion);
			personajeupdate.setVillas(villa);
			
			ps.editarPersonaje(personajeupdate);
			
			
			return ResponseEntity.ok().body(personajeupdate);
		}
	@GetMapping(path="/personajes")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<List<Personajes>> obtenerPersonajes() {
			
			return ResponseEntity.ok().body(ps.buscarPersonajes());
			
		}
	}

