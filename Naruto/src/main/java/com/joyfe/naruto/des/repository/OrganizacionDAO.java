package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.joyfe.naruto.des.entity.Organizaciones;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OrganizacionDAO implements IOrganizacionDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean registrarOrganizacion(Organizaciones organizaciones) {
		em.persist(organizaciones);
		return false;
	}

	@Override
	public Optional<Organizaciones> buscarOrganizacionesById(Long id) {
		
		return Optional.ofNullable(em.find(Organizaciones.class, id));
	}

	@Override
	public List<Organizaciones> buscarOrganizacionesByName(String nombre) {
		
		return em.createQuery("Select o from Organizaciones o where o.nombre like '" + nombre +"'").getResultList();
	}

	@Override
	public List<Organizaciones> buscarOrganizaciones() {
		
		return em.createQuery("Select o from Organizaciones o").getResultList();
	}

	@Override
	public boolean updateOrg(Organizaciones organizaciones) {
		
		em.merge(organizaciones);
		return false;
	}

	@Override
	public int n_organizacion(long id_org) {
		
		long num_miembro = (long) em.createQuery("Select count(p.organizaciones) from Personajes p where p.organizaciones = " + id_org).getSingleResult();
		
		int num = (int) num_miembro;
		
		return num;
	}	
}
