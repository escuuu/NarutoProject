package com.joyfe.naruto.des.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Clan {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id_clan;
	@NotBlank(message = "Tiene que tener un nombre")
	private String nombre;
	@NotBlank(message = "Tiene que tener una cualidad")
	private String cualidad;
	@OneToMany(mappedBy = "clan")
	@JsonBackReference
	private List<Personajes> personajes;
	
	
	
	public List<Personajes> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personajes> personajes) {
		this.personajes = personajes;
	}

	public Clan() {
		super();
	}
	
	public Clan(String nombre, String cualidad){
		
		this.nombre = nombre;
		this.cualidad = cualidad;
	}
	
	public Clan(long id_clan, String nombre, String cualidad){
		
		this.id_clan = id_clan;
		this.nombre = nombre;
		this.cualidad = cualidad;
	}
	
	public Clan(String nombre){
		
		this.nombre = nombre;
	}
	
	public long getId_clan() {
		return id_clan;
	}
	public void setId_clan(long id_clan) {
		this.id_clan = id_clan;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCualidad() {
		return cualidad;
	}
	public void setCualidad(String cualidad) {
		this.cualidad = cualidad;
	}
	
	
}
