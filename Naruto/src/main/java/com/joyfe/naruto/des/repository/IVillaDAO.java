package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import com.joyfe.naruto.des.entity.Villas;

public interface IVillaDAO {

	boolean registrarVilla(Villas villa);
	Optional<Villas> buscarVillaById(Long id);
	List<Villas> buscarVillaByName(String nombre);
	List<Villas> buscarVilla();
	boolean updateVilla(Villas villas);
}
