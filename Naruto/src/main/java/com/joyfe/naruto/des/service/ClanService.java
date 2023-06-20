package com.joyfe.naruto.des.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyfe.naruto.des.entity.Clan;
import com.joyfe.naruto.des.execption.NotFound;
import com.joyfe.naruto.des.repository.ClanDAO;

@Service
public class ClanService {

	@Autowired
	private ClanDAO dao;
	
	public boolean crearClan(Clan clan){
		
		dao.registrarClan(clan);
		
		return false;
	}
	
	public Optional<Clan> bucarClanId(Long id) {
		
		Optional<Clan> clan = dao.findClanById(id);
		
		if(clan.isEmpty()) {
			
			throw new NotFound("No se ha encontrado dicho id: " + id);
			
		}else {
		
			return dao.findClanById(id);	
		}
	}
	
public List<Clan> bucarClanNombre(String nombre) {
		
		List<Clan> clan = dao.findClanByName(nombre);
		
		if(clan.isEmpty()) {
			
			throw new NotFound("No se ha encontrado dicho clan: " + nombre);
			
		}else {
			
			return dao.findClanByName(nombre);	
			
		}

	}

	public List<Clan> obtenerClan(){
		
		return dao.findClan();
	}
	
	
	public boolean updateClan(Clan clan) {
		
		dao.updateClan(clan);
		
		return false;
	}
}
