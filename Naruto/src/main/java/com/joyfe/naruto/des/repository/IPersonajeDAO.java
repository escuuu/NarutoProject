package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import com.joyfe.naruto.des.entity.Personajes;

public interface IPersonajeDAO {

	boolean registrarPersonaje(Personajes personaje);
	Optional<Personajes> buscarPersonajeById(Long id);
	List<Personajes> buscarPersonajes();
	boolean eliminarPersonaje(Long id);
	boolean editarPersonaje(Personajes personaje);
}
