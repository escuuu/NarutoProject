package com.joyfe.naruto.des.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyfe.naruto.des.entity.Organizaciones;
import com.joyfe.naruto.des.execption.NotFound;
import com.joyfe.naruto.des.repository.OrganizacionDAO;

@Service
public class OrganizacionService {

	@Autowired
	private OrganizacionDAO dao;
	
	public boolean crearVilla(Organizaciones organizaciones){
		
		dao.registrarOrganizacion(organizaciones);
		
		return false;
	}
	
	public Optional<Organizaciones> bucarOrganizacionById(Long id) {
		
		Optional<Organizaciones> org = dao.buscarOrganizacionesById(id);
		
		if(org.isEmpty()) {
			
			throw new NotFound("No se ha encontrado dicho id: " + id);
			
		}else {
		
			org.get().setNum_miembro(dao.n_organizacion(id));
			
			return org;	
		
		}
	}
	
	public List<Organizaciones> bucarOrganizacionByName(String nombre) {
		
		List<Organizaciones> org = dao.buscarOrganizacionesByName(nombre);
		
		if(org.isEmpty()) {
			
			throw new NotFound("No se ha encontrado dicha organizacion: " + nombre);

		}else {
		
			return dao.buscarOrganizacionesByName(nombre);	
		}
	}
	public List<Organizaciones> obtenerOrganizacion(){
		
		List<Organizaciones> org = dao.buscarOrganizaciones();
		
		for (int i = 0; i < org.size(); i++) {
			
			org.get(i).setNum_miembro(dao.n_organizacion(org.get(i).getId_organizacion()));
		}
		
		return org;
	}
	
	public boolean updateOrg(Organizaciones organizaciones) {
		
		dao.updateOrg(organizaciones);
		
		return false;
	}
	
	public int n_miembros(String nombreOrganizacion) {
		
		Organizaciones org = dao.buscarOrganizacionesByName(nombreOrganizacion).get(0);
		
		return dao.n_organizacion(org.getId_organizacion());
	}
}
