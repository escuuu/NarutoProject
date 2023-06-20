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

import com.joyfe.naruto.des.entity.Villas;
import com.joyfe.naruto.des.service.VillaService;

import jakarta.validation.Valid;

@RestController    
@RequestMapping("/naruto")		
public class VillaController {

	final static String port = "4200";
	@Autowired
	private VillaService vs;
	
	@PostMapping(path="villa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Villas> crearVilla(@RequestBody @Valid  Villas villa) throws URISyntaxException {
		
		Villas nuevavilla = new Villas(villa.getNombre(), villa.getPais());
		
		vs.crearVilla(nuevavilla);
		
		return ResponseEntity.created(new URI("/personajes/"+villa.getId_villa())).body(nuevavilla);
	}
	
	@GetMapping(path="/villa/{idvilla}")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Optional<Villas>> obtenerVillaById(@PathVariable long idvilla) {
			
			return ResponseEntity.ok().body(vs.bucarVillaId(idvilla));
			
		}
	
	@GetMapping(path="/villa")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Villas>> obtenerVilla() {
			
			return ResponseEntity.ok().body(vs.obtenerVilla());
			
		}
	
	@PutMapping(path = "/villa/{idVilla}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Villas> editarVilla(@Valid @PathVariable long idVilla, @RequestBody Villas villas){
		
		if(vs.bucarVillaId(idVilla).get() != null) {
			
			Villas updateVilla = new Villas();
			updateVilla.setId_villa(idVilla);
			updateVilla.setNombre(villas.getNombre());
			updateVilla.setPais(villas.getPais());
		
			vs.updateVilla(updateVilla);
		
			return ResponseEntity.ok(updateVilla);
		
		}else{
			
			return ResponseEntity.notFound().build();
			
			}
		}
}
