package com.joyfe.naruto.des.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyfe.naruto.des.entity.Elementos;
import com.joyfe.naruto.des.execption.NotFound;
import com.joyfe.naruto.des.repository.ElementoDAO;

@Service
public class ElementoService {

	@Autowired
	private ElementoDAO dao;
	
	public boolean crearElemento(Elementos elemento){
		
		dao.registrarElemento(elemento);
		
		return false;
	}
	
	public Optional<Elementos> buscarElementoById(Long id){
			
		Optional<Elementos>elemento = dao.buscarElementoById(id);
		
		if(elemento.isEmpty()) {
			
			throw new NotFound("No se ha encontrado dicho id: " + id);
			
		}else {
		
			
			return dao.buscarElementoById(id);
		}
	}
	
	public List<Elementos> buscarElementoByName(String nombre){
		
		List<Elementos>elemento = dao.buscarElementoByName(nombre);
		
		if(elemento.isEmpty()) {
			
			throw new NotFound("No se ha encontrado este elemento: " + nombre);
			
		}else {
		
		return dao.buscarElementoByName(nombre);
		}
		
	}
	public List<Elementos> obtenerElemeno(){
		
		return dao.buscarElemento();
	}
	
	public boolean updatElemento(Elementos elementos) {
		
		dao.updatElemento(elementos);
		return false;
		
	}
}
