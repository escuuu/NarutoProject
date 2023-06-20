package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.joyfe.naruto.des.entity.Villas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VillaDAO implements IVillaDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean registrarVilla(Villas villa) {
		em.persist(villa);
		return false;
	}

	@Override
	public Optional<Villas> buscarVillaById(Long id) {

		return Optional.ofNullable(em.find(Villas.class, id));
	}


	public List<Villas> buscarVillaByName(String nombre) {
		
		return em.createQuery("Select v from Villas v where v.nombre like '" + nombre + "'").getResultList();
	}

	@Override
	public List<Villas> buscarVilla() {
		
		return em.createQuery("Select v from Villas v").getResultList();
	}

	@Override
	public boolean updateVilla(Villas villas) {

		em.merge(villas);
		return false;
	}
}
