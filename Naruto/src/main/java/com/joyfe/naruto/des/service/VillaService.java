package com.joyfe.naruto.des.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyfe.naruto.des.entity.Villas;
import com.joyfe.naruto.des.execption.NotFound;
import com.joyfe.naruto.des.repository.VillaDAO;

@Service
public class VillaService {

	@Autowired
	private VillaDAO dao;
	
	public boolean crearVilla(Villas villa){
		
		dao.registrarVilla(villa);
		
		return false;
	}
	
	public Optional<Villas> bucarVillaId(Long id) {
		
		Optional<Villas> villa = dao.buscarVillaById(id);
		
		if(villa.isEmpty()) {
			
			throw new NotFound("No se ha encontrado dicho id: " + id);
			
		}else {
			
			return dao.buscarVillaById(id);	
			
		}
	}
	
	public List<Villas> bucarVillaNombre(String nombre) {
		
		List<Villas> villa = dao.buscarVillaByName(nombre);
		
		if(villa.isEmpty()) {
			
			throw new NotFound("No se ha encontrado dicha villa: " + nombre);
			
		}else {
		
		return dao.buscarVillaByName(nombre);
		}
	}
	public List<Villas> obtenerVilla(){
		
		return dao.buscarVilla();
	}
	
	public boolean updateVilla(Villas villas) {
		
		dao.updateVilla(villas);
		return false;
	}
	
}
