package com.joyfe.naruto.des.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Usuarios {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id_usuario;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull
	@Size(min = 4, max = 24, message = "El nck debe tener 6 carácteres como mínimo")
	private String nick;
	@NotNull
	@Size(min = 8, max = 20, message = "La contraseña debe tener 8 carácteres como mínimo")
	private String password;
	@NotNull
	@Email
	private String gmail;
	
	public Usuarios() {
		super();
	}
	
	public Usuarios(String nombre, String apellidos, String nick, String password, String gmail) {
		
		this.nombre = nombre;
		this.apellidos =  apellidos;
		this.nick = nick;
		this.password = password;
		this.gmail = gmail;
	}
	
	
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
}
