package com.joyfe.naruto.des.repository;

import java.util.List;
import java.util.Optional;

import com.joyfe.naruto.des.entity.Organizaciones;

public interface IOrganizacionDAO {

	boolean registrarOrganizacion(Organizaciones organizaciones);
	Optional<Organizaciones> buscarOrganizacionesById(Long id);
	List<Organizaciones> buscarOrganizacionesByName(String nombre);
	List<Organizaciones> buscarOrganizaciones();
	boolean updateOrg(Organizaciones organizaciones);
	int n_organizacion(long id_org);
}
