package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import com.joyfe.naruto.des.entity.Clan;

public interface IClanDAO {

	boolean registrarClan(Clan clan);
	Optional<Clan> findClanById(Long id);
	List<Clan> findClanByName(String nombre);
	List<Clan> findClan();
	boolean updateClan(Clan clan);
}
