package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.joyfe.naruto.des.entity.Clan;
import com.joyfe.naruto.des.entity.Elementos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ElementoDAO implements IElementoDAO{

	@PersistenceContext
	private EntityManager em;
	


	@Override
	public boolean registrarElemento(Elementos elemento) {
		em.persist(elemento);
		return false;
	}

	@Override
	public Optional<Elementos> buscarElementoById(Long id) {
		
		return Optional.ofNullable(em.find(Elementos.class, id));
	}

	@Override
	public List<Elementos> buscarElementoByName(String nombre) {
		
		return em.createQuery("Select e from Elementos e where e.nombre like '" + nombre + "'").getResultList();
	}

	@Override
	public List<Elementos> buscarElemento() {
		
		return em.createQuery("Select e from Elementos e").getResultList();
	}

	@Override
	public boolean updatElemento(Elementos elementos) {
		em.merge(elementos);
		return false;
	}

}
