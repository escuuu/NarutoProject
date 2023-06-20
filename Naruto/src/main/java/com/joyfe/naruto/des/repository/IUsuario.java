package com.joyfe.naruto.des.repository;

import com.joyfe.naruto.des.entity.Usuarios;

public interface IUsuario {

	public boolean registrarUsuario(Usuarios user);
	public Usuarios loguear(String nick, String pass);
	public boolean selectUsuario(String nick, String gmail);
}
