package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import com.joyfe.naruto.des.entity.Elementos;

public interface IElementoDAO {

	boolean registrarElemento(Elementos elemento);
	Optional<Elementos> buscarElementoById(Long id);
	List<Elementos> buscarElementoByName(String nombre);
	List<Elementos> buscarElemento();
	boolean updatElemento(Elementos elementos);
}
