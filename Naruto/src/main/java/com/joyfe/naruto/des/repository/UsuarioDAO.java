package com.joyfe.naruto.des.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.joyfe.naruto.des.entity.Usuarios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioDAO implements IUsuario {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean registrarUsuario(Usuarios user) {
		
		em.persist(user);
		return false;
	}

	public Usuarios loguear(String nick, String pass) {
		
		try {
		return (Usuarios) em.createQuery("Select u from Usuarios u where u.nick = '" + nick +"' and u.password = '" + pass + "'").getSingleResult();
		}catch (Exception e) {
			return null;
		}
	
	}

	@Override
	public boolean selectUsuario(String nick, String gmail) {
		
		List<Object> listaver = em.createQuery("Select u from Usuarios u where u.nick = '" + nick +"' or u.gmail = '" + gmail + "'").getResultList();
		
		if(listaver.size() > 0) {
			
			return false;
		}
		else {
			
			return true;
		}
	}

}
