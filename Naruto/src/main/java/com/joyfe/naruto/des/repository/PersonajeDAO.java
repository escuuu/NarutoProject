package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.joyfe.naruto.des.entity.Personajes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonajeDAO implements IPersonajeDAO{

	@PersistenceContext
	private EntityManager em;
	
	public boolean registrarPersonaje(Personajes personaje) {
		
		em.persist(personaje);
		return false;
	}

	@Override
	public Optional<Personajes> buscarPersonajeById(Long id) {
		
		return Optional.ofNullable(em.find(Personajes.class, id));
	}


	public boolean eliminarPersonaje(Long id) {
			
				em.createQuery("Delete from Personajes where id_personaje = " + id).executeUpdate();
		return false;
	}

	@Override
	public boolean editarPersonaje(Personajes personaje) {
				
				em.merge(personaje);
		return false;
	}

	@Override
	public List<Personajes> buscarPersonajes() {
		
		List<Personajes> resultList = em.createQuery("Select p from Personajes p").getResultList();
		return resultList;
	}
}
