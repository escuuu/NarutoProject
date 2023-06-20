package com.joyfe.naruto.des.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joyfe.naruto.des.entity.Elementos;
import com.joyfe.naruto.des.service.ElementoService;

import jakarta.validation.Valid;

@RestController    
@RequestMapping("/naruto")
public class ElementoController {

	final static String port = "4200";
	@Autowired
	ElementoService es;
	
	@PostMapping(path="/elemento", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Elementos> crearElemento(@RequestBody @Valid  Elementos elementos) throws URISyntaxException {
		
		Elementos nuevoelemento = new Elementos(elementos.getNombre(), elementos.getCaracteristicas());
		
		es.crearElemento(nuevoelemento);
		
		return ResponseEntity.created(new URI("/personajes/"+elementos.getId_elemento())).body(nuevoelemento);
	}
	
	@GetMapping(path="/elemento/{idelemento}")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Optional<Elementos>> obtenerElementoById(@PathVariable long idelemento) {
			
			return ResponseEntity.ok().body(es.buscarElementoById(idelemento));
			
		}
	
	@GetMapping(path="/elemento")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<List<Elementos>> obtenerElemento() {
			
			return ResponseEntity.ok().body(es.obtenerElemeno());
			
		}
	
	@PutMapping(path = "/elemento/{idElemento}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Elementos> editarElementos(@Valid @PathVariable long idElemento,@Valid @RequestBody Elementos elementos){
		
		if(es.buscarElementoById(idElemento).get() != null) {
			
			Elementos updateElement = new Elementos();
			updateElement.setId_elemento(idElemento);
			updateElement.setNombre(elementos.getNombre());
			updateElement.setCaracteristicas(elementos.getCaracteristicas());
		
			es.updatElemento(updateElement);
		
			return ResponseEntity.ok(updateElement);
		
		}else{
			
			return ResponseEntity.notFound().build();
			
			}
		}
	}

