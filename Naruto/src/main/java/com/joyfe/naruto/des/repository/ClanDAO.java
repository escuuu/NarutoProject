package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.joyfe.naruto.des.entity.Clan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClanDAO implements IClanDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean registrarClan(Clan clan) {
		em.persist(clan);
		return false;
	}

	@Override
	public Optional<Clan> findClanById(Long id) {
		
		return Optional.ofNullable(em.find(Clan.class, id));
	}

	@Override
	public List<Clan> findClanByName(String nombre) {

		return em.createQuery("Select c from Clan c where c.nombre like '" + nombre + "'").getResultList();
	}

	@Override
	public List<Clan> findClan() {
		
		return em.createQuery("Select c from Clan c").getResultList();
	}

	@Override
	public boolean updateClan(Clan clan) {
		
		em.merge(clan);
		return false;
	}
}
