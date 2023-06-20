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

import com.joyfe.naruto.des.entity.Clan;
import com.joyfe.naruto.des.service.ClanService;

import jakarta.validation.Valid;

@RestController    
@RequestMapping("/naruto")		
public class ClanController {

	final static String port = "4200";
	
	@Autowired
	ClanService cs;
	
	@PostMapping(path="clan", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Clan> crearClan(@RequestBody @Valid  Clan clan) throws URISyntaxException {
		
		Clan nuevoclan = new Clan(clan.getNombre(), clan.getCualidad());
		
		cs.crearClan(nuevoclan);
		
		return ResponseEntity.created(new URI("/personajes/"+clan.getId_clan())).body(nuevoclan);
	}
	
	@GetMapping(path="/clan/{idclan}")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Optional<Clan>> obtenerClanById(@PathVariable long idclan) {
			
			return ResponseEntity.ok().body(cs.bucarClanId(idclan));
			
		}
	
	@GetMapping(path="/clan")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<List<Clan>> obtenerClan() {
			
			return ResponseEntity.ok().body(cs.obtenerClan());
			
		}
	
	@PutMapping(path = "/clan/{idClan}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Clan> editarClan(@Valid @PathVariable long idClan, @RequestBody Clan clan){
		
		if(cs.bucarClanId(idClan).get() != null) {
			
			Clan updateClan = new Clan();
			updateClan.setId_clan(idClan);
			updateClan.setNombre(clan.getNombre());
			updateClan.setCualidad(clan.getCualidad());
		
			cs.updateClan(updateClan);
		
			return ResponseEntity.ok(updateClan);
		
		}else{
			
			return ResponseEntity.notFound().build();
			
			}
		}
	
	}
