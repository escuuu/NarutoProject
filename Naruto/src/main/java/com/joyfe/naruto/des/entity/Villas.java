package com.joyfe.naruto.des.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Villas {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id_villa;
	@NotBlank(message = "Tiene que tener un nombre")
	@Size(min=5, max= 100)
	private String nombre;
	@Enumerated(EnumType.STRING)
	private Pais pais;
	@OneToMany(mappedBy = "villas")
	@JsonBackReference
	private List<Personajes> personajes;
	
	public enum Pais{
		Fuego, 
		Agua, 
		Viento, 
		Tierra, 
		Trueno
	}
	
public Villas() {
		super();
	}
	
	public Villas(String nombre, Pais pais) {
		
		this.nombre = nombre;
		this.pais = pais;
	}
	public Villas(String nombre) {
		
		this.nombre = nombre;
	}
	
	
	
	public List<Personajes> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personajes> personajes) {
		this.personajes = personajes;
	}

	public long getId_villa() {
		return id_villa;
	}

	public void setId_villa(long id_villa) {
		this.id_villa = id_villa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
