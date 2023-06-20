package com.joyfe.naruto.des.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.joyfe.naruto.des.dto.TokenDto;
import com.joyfe.naruto.des.entity.Usuarios;
import com.joyfe.naruto.des.repository.UsuarioDAO;
import com.joyfe.naruto.des.security.JwtUtil;

@Component
public class LoginService {
	private PasswordEncoder passwordEncoder;
	private UserDetailsManager userDetails;
	private JwtUtil jwtUtil;
	
	public LoginService(PasswordEncoder passwordEncoder, UserDetailsManager userDetails, JwtUtil jwtUtil) {
		this.passwordEncoder = passwordEncoder;
		this.userDetails = userDetails;
		this.jwtUtil = jwtUtil;
	}
	
	
	@Autowired
	UsuarioDAO dao;
	
	public TokenDto login(String userName, String password) {
		
		try {
			UserDetails userDetails = this.userDetails.loadUserByUsername(userName);
			
			if (this.passwordEncoder.matches(password, userDetails.getPassword())) {
				return new TokenDto(this.jwtUtil.encode(userDetails.getUsername()));
			} else {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o password incorrecto");			
			}
			
		} catch(UsernameNotFoundException unnfe) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o password incorrecto");			
		}
	}
	
	public boolean registarUsuario(Usuarios user) {
		
		dao.registrarUsuario(user);
		
		return false;
		
	}
	
	public Usuarios loguear(String nick, String pass) {
		
		return dao.loguear(nick, pass);
		
		
	}
	
	public boolean verificar(String nick, String gmail) {
		
		return dao.selectUsuario(nick, gmail);
	}
	
}
