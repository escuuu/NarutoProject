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

import com.joyfe.naruto.des.entity.Organizaciones;
import com.joyfe.naruto.des.service.OrganizacionService;

import jakarta.validation.Valid;

@RestController    
@RequestMapping("/naruto")		
public class OrganizacionesController {

	final static String port = "4200";
	@Autowired
	private OrganizacionService os;
	
	@PostMapping(path="organizacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Organizaciones> crearOrganizacion(@RequestBody @Valid  Organizaciones organizaciones) throws URISyntaxException {
		
		Organizaciones nuevaorganizacion = new Organizaciones(organizaciones.getNombre(), organizaciones.getTipo());

		os.crearVilla(nuevaorganizacion);
		
		return ResponseEntity.created(new URI("/personajes/"+organizaciones.getId_organizacion())).body(nuevaorganizacion);
		
	}
	
	@GetMapping(path="/organizacion/{idorg}")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Optional<Organizaciones>> obtenerOrgById(@PathVariable long idorg) {
			
			return ResponseEntity.ok().body(os.bucarOrganizacionById(idorg));
			
		}
	
	@GetMapping(path="/organizacion")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<List<Organizaciones>> obtenerOrg() {
			
			return ResponseEntity.ok().body(os.obtenerOrganizacion());
			
		}
	@PutMapping(path = "/organizacion/{idOrganizacion}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Organizaciones> editarElementos(@Valid @PathVariable long idOrganizacion, @RequestBody Organizaciones organizaciones){
		
		if(os.bucarOrganizacionById(idOrganizacion).get() != null) {
			
			Organizaciones updateOrg = new Organizaciones();
			updateOrg.setId_organizacion(idOrganizacion);
			updateOrg.setNombre(organizaciones.getNombre());
			updateOrg.setTipo(organizaciones.getTipo());
			updateOrg.setNum_miembro(os.bucarOrganizacionById(idOrganizacion).get().getNum_miembro());
		
			os.updateOrg(updateOrg);
		
			return ResponseEntity.ok(updateOrg);
		
		}else{
			
			return ResponseEntity.notFound().build();
			
			}
		}
}
